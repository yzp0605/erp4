package com.sxt.sys.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.LeaveBill;
import com.sxt.sys.mapper.LeaveBillMapper;
import com.sxt.sys.service.WorkFlowService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.SessionUtils;
import com.sxt.sys.vo.WorkFlowVo;
import com.sxt.sys.vo.act.ActCommentEntity;
import com.sxt.sys.vo.act.ActDeploymentEntity;
import com.sxt.sys.vo.act.ActProcessDefinitionEntity;
import com.sxt.sys.vo.act.ActTaskEntity;

@Service
public class WorkFlowServiceImpl implements WorkFlowService {
	@Autowired
	private LeaveBillMapper leaveBillMapper;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private ManagementService managementService;
	@Autowired
	private FormService formService;

	/**
	 * 查询流程部署信息
	 */
	@Override
	public DataGridView loadAllProcessDeployment(WorkFlowVo flowVo) {
		String deploymentName = flowVo.getDeploymentName();
		if (null == deploymentName) {
			deploymentName = "";
		}
		// 查询总条数
		long count = repositoryService.createDeploymentQuery().deploymentNameLike("%" + deploymentName + "%").count();
		// 分页查询
		List<Deployment> list = repositoryService.createDeploymentQuery().deploymentNameLike("%" + deploymentName + "%")
				.listPage((flowVo.getPage() - 1) * flowVo.getLimit(), flowVo.getLimit());

		List<ActDeploymentEntity> entities = new ArrayList<>();
		for (Deployment deployment : list) {
			ActDeploymentEntity entity = new ActDeploymentEntity();
			BeanUtils.copyProperties(deployment, entity);
			entities.add(entity);
		}
		return new DataGridView(count, entities);
	}

	/**
	 * 查询流程定义信息
	 */
	@Override
	public DataGridView loadAllProcessDef(WorkFlowVo flowVo) {
		String deploymentName = flowVo.getDeploymentName();
		if (null == deploymentName) {
			deploymentName = "";
		}
		// 先查询出部署ID信息
		List<Deployment> list = repositoryService.createDeploymentQuery().deploymentNameLike("%" + deploymentName + "%")
				.list();
		if (list.size() == 0) {
			return new DataGridView(0L, null);
		} else {
			Set<String> deploymentIds = new HashSet<>();
			for (Deployment d : list) {
				deploymentIds.add(d.getId());
			}
			// 再查询总条数
			long count = this.repositoryService.createProcessDefinitionQuery().deploymentIds(deploymentIds).count();
			// 分页面查询
			List<ProcessDefinition> data = this.repositoryService.createProcessDefinitionQuery()
					.deploymentIds(deploymentIds)
					.listPage((flowVo.getPage() - 1) * flowVo.getLimit(), flowVo.getLimit());
			List<ActProcessDefinitionEntity> entities = new ArrayList<>();
			for (ProcessDefinition pd : data) {
				ActProcessDefinitionEntity entity = new ActProcessDefinitionEntity();
				BeanUtils.copyProperties(pd, entity);
				entities.add(entity);
			}
			return new DataGridView(count, entities);
		}

	}

	// 部署流程
	@Override
	public void addDelpoyment(InputStream inputStream, String deploymentName) {
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		this.repositoryService.createDeployment().name(deploymentName).addZipInputStream(zipInputStream).deploy();
	}

	// 根据部署ID删除流程
	@Override
	public void deleteDeployment(String deploymentId) {
		this.repositoryService.deleteDeployment(deploymentId, true);
	}

	// 根据部署ID查看流程图
	@Override
	public InputStream viewProcessImage(String deploymentId) {
		// 根据部署ID查询流程定义对象
		ProcessDefinition processDefinition = this.repositoryService.createProcessDefinitionQuery()
				.deploymentId(deploymentId).singleResult();
		// 从流程定义对象里取出resourceName
		String resourceName = processDefinition.getDiagramResourceName();// 在act_re_procdef
		InputStream stream = this.repositoryService.getResourceAsStream(deploymentId, resourceName);
		return stream;
	}

	// 启动流程
	@Override
	public void startLeaveBillProcess(Integer id) {
		// 得到流程的Key
		String processDefinitionKey = LeaveBill.class.getSimpleName();
		// 设置流程变量，设置下一个任务的办理人
		Map<String, Object> variables = new HashMap<>();
		// 得到当前用户的用户名
		String name = SessionUtils.getUserNameInSession("user");
		variables.put("username", name);
		// 设置业务ID
		String businessKey = processDefinitionKey + "_" + id;
		this.runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
		// 把请假单的状态 由未提交到审批中 0-1
		LeaveBill record = new LeaveBill();
		record.setId(id);
		record.setState(String.valueOf(SYS_Constast.TYPE_LEAVEBILL_STATE_ONE));
		this.leaveBillMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 查询当前用户的待办任务
	 */
	@Override
	public DataGridView queryCurrentUserTask(WorkFlowVo flowVo) {
		// 1,得到当前的登陆用户名
		String name = SessionUtils.getUserNameInSession("user");
		// 2,得到当前用户待办任务的总数
		long count = this.taskService.createTaskQuery().taskAssignee(name).count();
		// 3,查询任务列表
		List<Task> data = this.taskService.createTaskQuery().taskAssignee(name).orderByTaskCreateTime().desc()
				.listPage((flowVo.getPage() - 1) * flowVo.getLimit(), flowVo.getLimit());
		// 4，转化集合
		List<ActTaskEntity> entities = new ArrayList<>();
		for (Task task : data) {
			ActTaskEntity entity = new ActTaskEntity();
			BeanUtils.copyProperties(task, entity);
			entities.add(entity);
		}
		return new DataGridView(count, entities);
	}

	/**
	 * ,根据任务ID查询请假单的信息
	 */
	@Override
	public LeaveBill queryLeaveBillByTaskId(String taskId) {
		// 1,根据任务ID查询任务对象
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
		// 2,从任务对象里面取出流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 3.使用流程实例ID查询流程实例
		ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		// 4,从流程实例里面取出业务ID
		String bussinessKey = processInstance.getBusinessKey();
		// 5,从业务ID里面截取请假单的ID
		String id = bussinessKey.split("_")[1];
		// 5,根据请假单的ID查询请假单
		LeaveBill leaveBill = this.leaveBillMapper.selectByPrimaryKey(Integer.valueOf(id));
		return leaveBill;
	}

	@Override
	public List<String> queryOutComeByTaskId(String taskId) {
		List<String> outcomes = new ArrayList<>();
		// 1,根据任务ID查询任务实例
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
		// 2,得到流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 3,取到当前活动的ID usertask1
		String activityId = task.getTaskDefinitionKey();
		// 4,使用流程定义ID查询流程定义对象 里面的xml的数据
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) this.repositoryService
				.getProcessDefinition(processDefinitionId);
		// 5,使用活动ID从流程定义里面查询出节点
		ActivityImpl activitImpl = processDefinitionEntity.findActivity(activityId);
		// 6,取出当前活动节点的连线信息
		List<PvmTransition> outgoingTransitions = activitImpl.getOutgoingTransitions();
		if (null != outgoingTransitions && outgoingTransitions.size() > 0) {
			for (PvmTransition pvmTransition : outgoingTransitions) {
				Object name = pvmTransition.getProperty("name");
				outcomes.add(name.toString());
			}
		}
		return outcomes;
	}

	/**
	 * 3,根据任务ID查询批注信息
	 */
	@Override
	public DataGridView queryCommonsByTaskId(String taskId) {
		// taskService.getTaskComments查询出的是当前任务的批注
		// List<Comment> comments = this.taskService.getTaskComments(taskId);
		// 1,根据任务ID查询任务对象
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
		// 2，从任务对象里面取出流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 3,查询整个流程实例里面的所有批注信息
		List<Comment> comments = this.taskService.getProcessInstanceComments(processInstanceId);
		List<ActCommentEntity> entities = new ArrayList<>();
		for (Comment comment : comments) {
			ActCommentEntity entity = new ActCommentEntity();
			BeanUtils.copyProperties(comment, entity);
			entities.add(entity);
		}
		return new DataGridView(Long.valueOf(entities.size()), entities);
	}

	/**
	 * 完成任务
	 */
	@Override
	public void completeTask(WorkFlowVo workFlowVo) {
		String taskId = workFlowVo.getTaskId();// 任务ID
		String outcome = workFlowVo.getOutcome();// 连接名称
		String comment = workFlowVo.getComment();// 批注信息
		Integer id = workFlowVo.getId();// 请假单的ID
		// 1,创建流程变量的Map
		Map<String, Object> variables = new HashMap<>();
		variables.put("outcome", outcome);
		// 2,根据任务ID查询流程实例对象
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
		// 3,得到流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 4,得到当前用户
		String username = SessionUtils.getUserNameInSession("user");
		// 6,设置当前线程用户的局部变量
		Authentication.setAuthenticatedUserId(username);
		// 7,添加批注信息
		/**
		 * 因为批注 是属性某个办理人 所以一空设置办理人的ID。可以查看addComment-->AddcomentAdd--> String userId =
		 * Authentication.getAuthenticatedUserId(); CommentEntity comment = new
		 * CommentEntity(); comment.setUserId(userId);
		 */
		this.taskService.addComment(taskId, processInstanceId, "[" + outcome + "]" + comment);
		// 8，完成任务
		this.taskService.complete(taskId, variables);
		// 9,判断任务是否完成
		ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		if (null == processInstance) {
			// 说明任务这完成了
			// 更新请假单的状态
			LeaveBill record = new LeaveBill();
			record.setId(id);
			if (outcome.equals("放弃")) {
				record.setState(String.valueOf(SYS_Constast.TYPE_LEAVEBILL_STATE_THREE));
			} else {
				record.setState(String.valueOf(SYS_Constast.TYPE_LEAVEBILL_STATE_TOW));
			}
			this.leaveBillMapper.updateByPrimaryKeySelective(record);
		}
	}

	// /根据任务ID查询流程定义对象
	@Override
	public ProcessDefinition queryProcessDefinitionByTaskId(String taskId) {
		// 1,根据任务ID查询任务实例
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
		// 2,从任务实例里面取出流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 3,根据流程定义ID查询流程定义对象
		return this.repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId)
				.singleResult();
	}

	@Override
	public Map<String, Object> queryCoordinateByTaskId(String taskId) {
		 Map<String, Object> map=new HashMap<>();
		// 1,根据任务ID查询任务实例
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
		// 2,得到流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 3,取到当前活动的ID usertask1
		String activityId = task.getTaskDefinitionKey();
		// 4,使用流程定义ID查询流程定义对象 里面的xml的数据
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) this.repositoryService
				.getProcessDefinition(processDefinitionId);
		// 5,使用活动ID从流程定义里面查询出节点
		ActivityImpl activitImpl = processDefinitionEntity.findActivity(activityId);
		map.put("x", activitImpl.getX());
		map.put("y", activitImpl.getY());
		map.put("width", activitImpl.getWidth());
		map.put("height", activitImpl.getHeight());
		return map;
	}

	/**
	 * 根据请假单位ID查询批注信息
	 */
	@Override
	public DataGridView queryCommonsByLeaveBillId(Integer id) {
		//因为用户要请假单页面查询审批进度时可用这个任务已经审批完成所有act_ru表里面就没有数据数据，但是act_hi里面肯定有
		//1,组装BussinessKey
		String businessKey=LeaveBill.class.getSimpleName()+"_"+id;
		//2,根据BussinessKey去历史流程实例里面查询历史流程实例对象
		HistoricProcessInstance historicProcessInstance = this.historyService
				.createHistoricProcessInstanceQuery().processInstanceBusinessKey(businessKey).singleResult();
		// 3，从历史流程实例对象里面取出流程实例ID
		String processInstanceId = historicProcessInstance.getId();
		// 4,查询整个流程实例里面的所有批注信息
		List<Comment> comments = this.taskService.getProcessInstanceComments(processInstanceId);
		List<ActCommentEntity> entities = new ArrayList<>();
		for (Comment comment : comments) {
			ActCommentEntity entity = new ActCommentEntity();
			BeanUtils.copyProperties(comment, entity);
			entities.add(entity);
		}
		return new DataGridView(Long.valueOf(entities.size()), entities);
	}

	@Override
	public DataGridView queryHistoryTaskByAssignee(WorkFlowVo vo) {
		long count = this.historyService.createHistoricTaskInstanceQuery().taskAssignee(vo.getAssignee()).count();
		List<HistoricTaskInstance> list = this.historyService.createHistoricTaskInstanceQuery().taskAssignee(vo.getAssignee())
		.listPage((vo.getPage() - 1) * vo.getLimit(), vo.getLimit());
		return null;
	}

}
