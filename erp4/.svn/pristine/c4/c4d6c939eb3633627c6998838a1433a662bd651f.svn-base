package com.sxt.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.LogInfoVo;

@Controller
@RequestMapping("logInfo")
public class LogInfoController {
	@Autowired
	private LogInfoService  logInfoService;
	
	/**
	 * 跳转到日志管理的页面
	 */
	@RequestMapping("toLogInfoManager")
	public String toLogInfoManager() {
		return "system/logInfo/logInfoManager";
	}
	
	/**
	 * 加载日志的数据
	 */
	@RequestMapping("loadAllLogInfo")
	@ResponseBody
	public DataGridView loadAllLogInfo(LogInfoVo logInfoVo) {
		return this.logInfoService.queryAllLogInfo(logInfoVo);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteLogInfo")
	@ResponseBody
	public Map<String,Object> deleteLogInfo(LogInfoVo logInfoVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			int num=this.logInfoService.deleteLogInfo(logInfoVo);
			if(num>0) {
				msg="删除成功";
			}else {
				msg="删除失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteLogInfo")
	@ResponseBody
	public Map<String,Object> batchDeleteLogInfo(LogInfoVo logInfoVo){
		Map<String,Object> map=new HashMap<>();
		String msg="";
		try {
			Integer[] ids=logInfoVo.getIds();
			if(ids!=null&&ids.length>0) {
				for (int i = 0; i < ids.length; i++) {
					logInfoVo.setId(ids[i]);
					int num=this.logInfoService.deleteLogInfo(logInfoVo);
					if(num>0) {
						msg="删除成功";
					}else {
						msg="删除失败";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		map.put("msg", msg);
		return map;
	}
	

}
