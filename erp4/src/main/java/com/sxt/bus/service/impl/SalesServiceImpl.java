package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Sales;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.mapper.SalesMapper;
import com.sxt.bus.service.SalesService;

import com.sxt.bus.vo.salesVo;
import com.sxt.sys.utils.DataGridView;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesMapper salesMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Sales> queryAllSales(salesVo salesVo) {
		return salesMapper.queryAllSalest(salesVo);
	}
	@Override
	public DataGridView loadSales(salesVo salesVo) {
		Page<Sales> page=PageHelper.startPage(salesVo.getPage(), salesVo.getLimit());
		List<Sales> list=this.salesMapper.queryAllSalest(salesVo);
		DataGridView view=new DataGridView();
		view.setCount(page.getTotal());
		view.setData(list);
		return view;
	}
	@Override
	public void addSales(salesVo salesVo) {
		
		this.salesMapper.insert(salesVo);
		//更新商品的库存
		Integer goodsId=salesVo.getGoodsid();
		Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
		System.out.println(goods.toString());
		//新的库存是  老库存+进货的数量
		goods.setNumber(goods.getNumber()+salesVo.getNumber());
		//更新
		this.goodsMapper.updateByPrimaryKeySelective(goods);
	salesMapper.insert(salesVo);
	}
	@Override
	public Sales querySalesById(Integer id) {
		return this.salesMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateSales(salesVo salesVo) {
		this.salesMapper.updateByPrimaryKey(salesVo);
	}
	@Override
	public void deleteSales(salesVo salesVo) {
		this.salesMapper.deleteByPrimaryKey(salesVo.getId());
	}
	
}
