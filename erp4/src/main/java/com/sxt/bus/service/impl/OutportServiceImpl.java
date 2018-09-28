package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Ouport;
import com.sxt.bus.domain.Ouport;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.mapper.OuportMapper;
import com.sxt.bus.mapper.OuportMapper;

import com.sxt.bus.service.OutportService;
import com.sxt.bus.vo.OuportVo;
import com.sxt.sys.utils.DataGridView;

@Service
public class OutportServiceImpl implements OutportService {

	@Autowired
	private OuportMapper inportMapper;
	@Autowired
	private OuportMapper ouportMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Ouport> queryAllOuport(OuportVo ouportVo) {
		return inportMapper.queryAllInport(ouportVo);
	}
	@Override
	public DataGridView loadOuport(OuportVo ouportVo) {
		Page<Ouport> page=PageHelper.startPage(ouportVo.getPage(), ouportVo.getLimit());
		List<Ouport> list = this.ouportMapper.queryAllInport(ouportVo);
		DataGridView view=new DataGridView();
		view.setCount(page.getTotal());
		view.setData(list);
		return view;
	}
	@Override
	public void addOuport(OuportVo ouportVo) {
		this.inportMapper.insert(ouportVo);
		//更新商品的库存
		Integer goodsId=ouportVo.getGoodsid();
		Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
		//新的库存是  老库存+进货的数量
		
		goods.setNumber(goods.getNumber()-ouportVo.getNumber());
		//更新
		this.goodsMapper.updateByPrimaryKey(goods);
	}
	@Override
	public Ouport queryOuportById(Integer id) {
		return this.inportMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateOuport(OuportVo ouportVo) {
	
		this.inportMapper.updateByPrimaryKey(ouportVo);
	}
	@Override
	public void deleteOuport(OuportVo ouportVo) {
		this.inportMapper.deleteByPrimaryKey(ouportVo.getId());
	}
	
}
