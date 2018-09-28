package com.sxt.sys.service;

import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.LogInfoVo;

public interface LogInfoService {
	
	
	/**
	 * 查询
	 */
	public DataGridView queryAllLogInfo(LogInfoVo logInfoVo);

	/**
	 * 删除
	 * @param logInfoVo
	 * @return
	 */
	public int deleteLogInfo(LogInfoVo logInfoVo);

	/**
	 * 保存登陆日志
	 * @param logInfoVo
	 */
	public void addLogInfo(LogInfoVo logInfoVo);

}
