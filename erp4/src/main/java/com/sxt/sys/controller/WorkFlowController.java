package com.sxt.sys.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sxt.sys.domain.LeaveBill;
import com.sxt.sys.service.LeaveBillService;
import com.sxt.sys.service.WorkFlowService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.WorkFlowVo;

/**
 * 流程管理
 * 
 * @author LJH
 *
 */
@Controller
@RequestMapping("workFlow")
public class WorkFlowController {
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private LeaveBillService leaveBillService;
	

	/**
	 * 跳转到流程管理的页面
	 */
	@RequestMapping("toWorkFlowManager")
	public String toWorkFlowManager() {
		return "system/workFlow/workFlowManager";
	}

	/**
	 * 加载所有有部署信息
	 * 
	 */
	@RequestMapping("loadAllProcessDeployment")
	@ResponseBody
	public DataGridView loadAllProcessDeployment(WorkFlowVo flowVo) {
		return this.workFlowService.loadAllProcessDeployment(flowVo);
	}

	/**
	 * 加载所有的流程定义信息
	 */
	@RequestMapping("loadAllProcessDef")
	@ResponseBody
	public DataGridView loadAllProcessDef(WorkFlowVo flowVo) {
		return this.workFlowService.loadAllProcessDef(flowVo);
	}
	
	/**
	 * 跳转到部署流程的页面
	 */
	@RequestMapping("toAddDeployment")
	public String toAddDeployment(WorkFlowVo flowVo) {
		return "system/workFlow/workFlowAdd";
	}
	
	/**
	 * 上传部署
	 */
	@RequestMapping("addDeployment")
	@ResponseBody
	public Map<String,Object> addDeployment(MultipartFile mf,WorkFlowVo flowVo){
		Map<String,Object> map=new HashMap<String, Object>();
		String msg="部署成功";
		try {
			this.workFlowService.addDelpoyment(mf.getInputStream(),flowVo.getDeploymentName());
		} catch (Exception e) {
			e.printStackTrace();
			msg="部署失败";
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 删除流程部署
	 */
	@RequestMapping("deleteDeployment")
	@ResponseBody
	public Map<String,Object> deleteDeployment(WorkFlowVo flowVo){
		Map<String,Object> map=new HashMap<String, Object>();
		String msg="删除成功";
		try {
			this.workFlowService.deleteDeployment(flowVo.getDeploymentId());
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		map.put("msg", msg);
		return map;
	}
	/**
	 * 跳转到查询查看流程图的页面
	 */
	@RequestMapping("toViewProcessImage")
	public String toViewProcessImage(WorkFlowVo workFlowVo) {
		return "system/workFlow/viewProcessImage";
	}
	
	
	/**
	 * 查看流程图
	 */
	@RequestMapping("viewProcessImage")
	public void viewProcessImage(WorkFlowVo workFlowVo,HttpServletResponse response)
	{
		//得到流程图的流
		InputStream is=this.workFlowService.viewProcessImage(workFlowVo.getDeploymentId());
		try {
			//把流程的流转成图片
			BufferedImage image=ImageIO.read(is);
			//把图片流写出
			ImageIO.write(image, "JPEG", response.getOutputStream());
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 提交申请
	 */
	@RequestMapping("startLeaveBillProcess")
	@ResponseBody
	public Map<String,Object> startLeaveBillProcess(WorkFlowVo workFlowVo){
		Map<String, Object> map=new HashMap<>();
		String msg="启动成功";
		try {
			//启动流程
			this.workFlowService.startLeaveBillProcess(workFlowVo.getId());
		} catch (Exception e) {
			msg="启动失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到我的待办任务
	 */
	@RequestMapping("toTaskManager")
	public String toTaskManager() {
		return "system/workFlow/taskManager";
	}
	
	/**
	 * 查询当前用户的待办任务
	 */
	@RequestMapping("queryCurrentUserTask")
	@ResponseBody
	public DataGridView queryCurrentUserTask(WorkFlowVo workFlowVo) {
		return this.workFlowService.queryCurrentUserTask(workFlowVo);
	}
	
	/**
	 * 跳转到办理任务的页面
	 */
	@RequestMapping("toDoTask")
	public String toDoTask(WorkFlowVo workFlowVo,Model model) {
		//1,根据任务ID查询请假单的信息
		LeaveBill leaveBill=this.workFlowService.queryLeaveBillByTaskId(workFlowVo.getTaskId());
		//2,根据任务ID查询按钮的集合
		List<String> outcomes=this.workFlowService.queryOutComeByTaskId(workFlowVo.getTaskId());
		
		model.addAttribute("leaveBill", leaveBill);
		model.addAttribute("outcomes", outcomes);
		return "system/workFlow/doTaskManager";
	}
	
	/**
	 * //3,根据任务ID查询批注信息
	 */
	@RequestMapping("queryCommonsByTaskId")
	@ResponseBody
	public DataGridView queryCommonsByTaskId(WorkFlowVo flowVo) {
		return this.workFlowService.queryCommonsByTaskId(flowVo.getTaskId());
	}
	
	
	/**
	 * 完成任务
	 */
	@RequestMapping("completeTask")
	@ResponseBody
	public Map<String,Object> completeTask(WorkFlowVo workFlowVo){
		Map<String, Object> map=new HashMap<>();
		String msg="任务完成成功";
		try {
			//完成任务
			this.workFlowService.completeTask(workFlowVo);
		} catch (Exception e) {
			msg="任务完成失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 根据任务ID查看任务办理的流程图
	 */
	@RequestMapping("toViewProcessImageByTaskId")
	public String toViewProcessImageByTaskId(WorkFlowVo flowVo,Model model) {
		//1,根据任务ID查询流程定义对象
		ProcessDefinition processDefinition=this.workFlowService.queryProcessDefinitionByTaskId(flowVo.getTaskId());
		//2,取出流程部署
		String deploymentId = processDefinition.getDeploymentId();
		flowVo.setDeploymentId(deploymentId);
		//3,根据任务ID查询当前办理任务的坐标
		Map<String,Object> coordinate=this.workFlowService.queryCoordinateByTaskId(flowVo.getTaskId());
		model.addAttribute("c", coordinate);
		return "system/workFlow/viewProcessImage";
	}
	
	
	/**
	 * 跳转到查询审批进度的页面
	 */
	@RequestMapping("toViewApprovalProgress")
	public String toViewApprovalProgress(WorkFlowVo workFlowVo,Model model) {
		//1,根据请假单的信息
		LeaveBill leaveBill = this.leaveBillService.queryLeaveBillById(workFlowVo.getId());
		model.addAttribute("leaveBill", leaveBill);
		return "system/workFlow/showApprovalProgress";
	}
	
	/**
	 * 根据请假单位ID查询批注信息
	 */
	@RequestMapping("queryCommonsByLeaveBillId")
	@ResponseBody
	public DataGridView queryCommonsByLeaveBillId(WorkFlowVo flowVo) {
		return this.workFlowService.queryCommonsByLeaveBillId(flowVo.getId());
	}
	
}
