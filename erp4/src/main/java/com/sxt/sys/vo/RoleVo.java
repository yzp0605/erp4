package com.sxt.sys.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxt.sys.domain.Role;

public class RoleVo extends Role{
	
	private Integer[] ids;
	/**
	 * 分页参数
	 */
	private Integer page;
	private Integer limit;
	
	@JsonProperty("LAY_CHECKED")
	private Boolean LAY_CHECKED=false;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Boolean getLAY_CHECKED() {
		return LAY_CHECKED;
	}
	public void setLAY_CHECKED(Boolean lAY_CHECKED) {
		LAY_CHECKED = lAY_CHECKED;
	}

	
}
