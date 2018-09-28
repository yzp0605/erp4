package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Inport;
import com.sxt.bus.domain.Ouport;

public interface OuportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ouport record);

    int insertSelective(Ouport record);

    Ouport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ouport record);

    int updateByPrimaryKey(Ouport record);
    //商品全查询
    List<Ouport> queryAllInport(Ouport ouport);
}