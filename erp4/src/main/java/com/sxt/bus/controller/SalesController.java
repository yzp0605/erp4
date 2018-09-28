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

import com.sxt.bus.domain.Sales;
import com.sxt.bus.domain.Customer;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.SalesService;
import com.sxt.bus.service.CustomerService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.salesVo;
import com.sxt.bus.vo.CustomerVo;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;

@Controller
@RequestMapping("sales")
public class SalesController {

	@Autowired
	private SalesService salesService;

	@Autowired
	private CustomerService customerService;
@Autowired
private ProviderService providerService;
	/**
	 * 跳转到销售管理页面
	 */
	@RequestMapping("toSalesManager")
	public String toSalesManager() {
		return "business/sales/salesManager";
	}

	/**
	 * 左边的树地址
	 */
	@RequestMapping("toSalesLeft")
	public String toSalesLeft() {
		return "business/sales/salesLeft";
	}

	/**
	 * 右边的列表
	 */
	@RequestMapping("toSalesRight")
	public String toSalesRight() {
		return "business/sales/salesRight";
	}

	/**
	 * 加载左边的供应商树 返回json
	 */
	@RequestMapping("loadLeftCustomerTree")
	@ResponseBody
	public List<TreeNode> loadLeftCustomerTree(salesVo sVo) {
		// 查询所有供应商
		List<Customer> customers = customerService.queryAllCustomer(new CustomerVo());
		List<TreeNode> nodes=new ArrayList<>();
		nodes.add(new TreeNode(0, 0, "所有客户", true, true));
		for (Customer d : customers) {
			nodes.add(new TreeNode(d.getId(), 0, d.getCustomername(), false, false));
		}
		return nodes;
	}

	/**
	 * 加载销售数据
	 */
	@RequestMapping("loadSales")
	@ResponseBody
	public DataGridView loadSales(salesVo ssVo) {
		return salesService.loadSales(ssVo);
	}

	/**
	 * 跳转到添加销售页面
	 */
	@RequestMapping("toAddSales")
	public String toAddSales(Model model) {
		// 查询所有供应商
		List<Customer> customers = this.customerService
				.queryAllCustomer(new CustomerVo());
		List<Provider> providers = this.providerService
				.queryAllProvider(new ProviderVo());
		model.addAttribute("providers", providers);
		model.addAttribute("customers", customers);
		model.addAttribute("providers", providers);
		return "business/sales/salesAdd";
	}

	/**
	 * 添加销售
	 */
	
	@RequestMapping("addSales")
	@ResponseBody
	public Map<String, Object> addSales(salesVo sVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加成功";
		try {
		
			salesService.addSales(sVo);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "添加失败";
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 跳转到修改销售页面
	 */
	@RequestMapping("toUpdateSales")
	public String toUpdateSales(salesVo salesVo, Model model) {
		// 查询所有供应商
		List<Customer> customers = this.customerService
				.queryAllCustomer(new CustomerVo());
		model.addAttribute("customers", customers);
		// 根据销售ID查询所有销售信息
		Sales sales = this.salesService.querySalesById(salesVo.getId());
		model.addAttribute("sales", sales);
		return "business/sales/salesUpdate";
	}

	/**
	 * 修改销售
	 */
	@RequestMapping("updateSales")
	@ResponseBody
	public Map<String, Object> updateSales(salesVo salesVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改成功";
		try {
			salesService.updateSales(salesVo);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "修改失败";
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 删除销售
	 */
	@RequestMapping("deleteSales")
	@ResponseBody
	public Map<String, Object> deleteSales(salesVo salesVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			salesService.deleteSales(salesVo);
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
	@RequestMapping("batchDeleteSales")
	@ResponseBody
	public Map<String, Object> batchDeleteSales(salesVo salesVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			Integer[] ids = salesVo.getIds();
			for (Integer id : ids) {
				salesVo.setId(id);
				salesService.deleteSales(salesVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "删除失败";
		}
		map.put("msg", msg);
		return map;
	}

}
