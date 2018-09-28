package com.sxt.bus.mapper;

import java.util.List;


import com.sxt.bus.domain.Sales;
import com.sxt.bus.vo.salesVo;

public interface SalesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
    List<Sales> queryAllSalest(salesVo salesVo);
    
}