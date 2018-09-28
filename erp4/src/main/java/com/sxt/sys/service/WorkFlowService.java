package com.sxt.sys.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;

import com.sxt.sys.domain.LeaveBill;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.WorkFlowVo;

/**
 * 工作流的服务类
 * @author LJH
 *
 */
public interface WorkFlowService {

	//查询所有的流程部署信息
	DataGridView loadAllProcessDeployment(WorkFlowVo flowVo);
	//查询所有的流程这定义信息
	DataGridView loadAllProcessDef(WorkFlowVo flowVo);
	//保存部署信息
	void addDelpoyment(InputStream inputStream, String deploymentName);
	//根据部署ID删除流程
	void deleteDeployment(String deploymentId);
	//根据部署ID查询流程图的流
	InputStream viewProcessImage(String deploymentId);
	//启动流程
	public void startLeaveBillProcess(Integer id);
	//查询当前用户的待办任务
	DataGridView queryCurrentUserTask(WorkFlowVo workFlowVo);
	//根据任务ID查询请假单的信息
	LeaveBill queryLeaveBillByTaskId(String taskId);
	//根据任务ID查询按钮的集合
	List<String> queryOutComeByTaskId(String taskId);
	//3,根据任务ID查询批注信息
	DataGridView queryCommonsByTaskId(String taskId);
	//根据任务ID完成任务并添加批注信息
	void completeTask(WorkFlowVo workFlowVo);
	//根据任务ID查询流程定义对象
	ProcessDefinition queryProcessDefinitionByTaskId(String taskId);
	//根据任务ID查询节点坐标
	Map<String, Object> queryCoordinateByTaskId(String taskId);
	//根据请假单位ID查询批注信息
	DataGridView queryCommonsByLeaveBillId(Integer id);
	//根据当前用户名称查询历史审批记录
	DataGridView queryHistoryTaskByAssignee(WorkFlowVo workFlowVo);

}
