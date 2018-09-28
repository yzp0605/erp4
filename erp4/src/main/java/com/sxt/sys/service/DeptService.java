package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Dept;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.DeptVo;

public interface DeptService {
	
	
	/**
	 * 分页查询
	 */
	public DataGridView queryAllDept(DeptVo deptVo);

	
	/**
	 * 查询部门返回List
	 */
	public List<Dept> queryAllDeptForList(DeptVo deptVo);
	
	/**
	 * 删除
	 * @param deptVo
	 * @return
	 */
	public int deleteDept(DeptVo deptVo);


	/**
	 * 添加部门
	 * @param deptVo
	 * @return
	 */
	public int addDept(DeptVo deptVo);


	/**
	 * 根据ID查询部门
	 * @param id
	 * @return
	 */
	public Dept querDeptById(Integer id);


	/**
	 * 修改部门信息
	 * @param deptVo
	 * @return
	 */
	public int updateDept(DeptVo deptVo);



}
