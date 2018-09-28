	package com.sxt.bus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domain.Inport;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.InportService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.InportVo;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;

@Controller
@RequestMapping("ouport")
public class OutportController {

	@Autowired
	private InportService inportService;

	@Autowired
	private ProviderService providerService;

	/**
	 * 跳转到 退货管理页面
	 */
	@RequestMapping("toInportManager")
	public String toInportManager() {
		return "business/inport/inportManager";
	}

	/**
	 * 左边的树地址
	 */
	@RequestMapping("toInportLeft")
	public String toInportLeft() {
		return "business/inport/inportLeft";
	}

	/**
	 * 右边的列表
	 */
	@RequestMapping("toInportRight")
	public String toInportRight() {
		return "business/inport/inportRight";
	}

	/**
	 * 加载左边的供应商树 返回json
	 */
	@RequestMapping("loadLeftProviderTree")
	@ResponseBody
	public List<TreeNode> loadLeftProviderTree(InportVo inportVo) {
		// 查询所有供应商
		List<Provider> providers = providerService.queryAllProvider(new ProviderVo());
		List<TreeNode> nodes=new ArrayList<>();
		nodes.add(new TreeNode(0, 0, "所有供应商", true, true));
		for (Provider d : providers) {
			nodes.add(new TreeNode(d.getId(), 0, d.getProvidername(), false, false));
		}
		return nodes;
	}

	/**
	 * 加载 退货数据
	 */
	@RequestMapping("loadInport")
	@ResponseBody
	public DataGridView loadInport(InportVo inportVo) {
		return inportService.loadInport(inportVo);
	}

	/**
	 * 跳转到添加 退货页面
	 */
	@RequestMapping("toAddInport")
	public String toAddInport(Model model) {
		// 查询所有供应商
		List<Provider> providers = this.providerService
				.queryAllProvider(new ProviderVo());
		model.addAttribute("providers", providers);
		return "business/inport/inportAdd";
	}

	/**
	 * 添加 退货
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("addInport")
	@ResponseBody
	public Map<String, Object> addInport(InportVo inportVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加成功";
		try {
			inportVo.setInporttime(new Date().toLocaleString());
			inportService.addInport(inportVo);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "添加失败";
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 跳转到修改 退货页面
	 */
	@RequestMapping("toUpdateInport")
	public String toUpdateInport(InportVo inportVo, Model model) {
		// 查询所有供应商
		List<Provider> providers = this.providerService
				.queryAllProvider(new ProviderVo());
		model.addAttribute("providers", providers);
		// 根据 退货ID查询所有 退货信息
		Inport inport = this.inportService.queryInportById(inportVo.getId());
		model.addAttribute("inport", inport);
		return "business/inport/inportUpdate";
	}

	/**
	 * 修改 退货
	 */
	@RequestMapping("updateInport")
	@ResponseBody
	public Map<String, Object> updateInport(InportVo inportVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改成功";
		try {
			inportService.updateInport(inportVo);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "修改失败";
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 删除 退货
	 */
	@RequestMapping("deleteInport")
	@ResponseBody
	public Map<String, Object> deleteInport(InportVo inportVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			inportService.deleteInport(inportVo);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "删除失败";
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteInport")
	@ResponseBody
	public Map<String, Object> batchDeleteInport(InportVo inportVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			Integer[] ids = inportVo.getIds();
			for (Integer id : ids) {
				inportVo.setId(id);
				inportService.deleteInport(inportVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "删除失败";
		}
		map.put("msg", msg);
		return map;
	}

}
