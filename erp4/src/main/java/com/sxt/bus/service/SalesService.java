package com.sxt.bus.service;

import java.util.List;

import com.sxt.bus.domain.Sales;
import com.sxt.bus.vo.salesVo;
import com.sxt.sys.utils.DataGridView;

public interface SalesService {

	List<Sales> queryAllSales(salesVo salesVo);

	DataGridView loadSales(salesVo salesVo);

	void addSales(salesVo salesVo);

	Sales querySalesById(Integer id);

	void updateSales(salesVo salesVo);

	void deleteSales(salesVo salesVo);

}
