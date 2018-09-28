package com.sxt.bus.vo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sxt.bus.domain.Inport;
import com.sxt.bus.domain.Ouport;

public class OuportVo extends Ouport {
	//批量删除的参数
	private Integer[] ids;
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	//时间参数
		@DateTimeFormat(pattern="yyy-MM-dd HH:mm:ss")
		/*开始时间*/
		private Date startDate;
		@DateTimeFormat(pattern="yyy-MM-dd HH:mm:ss")
		//结束时间
		private Date endDate;
		
	public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
	//分页参数
	private Integer page;
	private Integer limit;
	
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
	
	public OuportVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
