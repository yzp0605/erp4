package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TreeNode {

	private Integer id;
	@JsonProperty("pId")
	private Integer pid;
	private String title;
	private String href;
	private String icon;
	private Boolean spread;// 是否展开
	private String target;
	
	private List<TreeNode> children=new ArrayList<>();
	
	
	//zTree添加的属性
	private String name;
	private Boolean open;
	private Boolean isParent;
	
	//zTree的复选树的属性
	private Boolean checked;
	
	/**
	 * zTree的复选树构造方法
	 */
	public TreeNode(Integer id, Integer pid, String name, Boolean open, Boolean isParent,Boolean checked) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
		this.checked=checked;
	}
	/**
	 * zTree的菜单树构造方法
	 */
	public TreeNode(Integer id, Integer pid, String name, Boolean open, Boolean isParent) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.open = open;
		this.isParent = isParent;
	}
	/**
	 * 主页的导航菜单使用的构造方 法
	 */
	public TreeNode(Integer id, Integer pid, String title, String href, String icon, Boolean spread, String target) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.href = href;
		this.icon = icon;
		this.spread = spread;
		this.target = target;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Boolean getSpread() {
		return spread;
	}
	public void setSpread(Boolean spread) {
		this.spread = spread;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	

}
