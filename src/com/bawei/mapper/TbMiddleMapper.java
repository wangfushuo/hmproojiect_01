package com.bawei.mapper;

import java.util.List;

import com.bawei.entity.TbMiddle;
import com.bawei.entity.TbMiddleKey;

public interface TbMiddleMapper {
    int deleteByPrimaryKey(TbMiddleKey key);

    int insert(TbMiddle record);

    int insertSelective(TbMiddle record);

    TbMiddle selectByPrimaryKey(TbMiddleKey key);

    int updateByPrimaryKeySelective(TbMiddle record);

    int updateByPrimaryKey(TbMiddle record);
    //根据用户ID 查询购买明细
    List<TbMiddle> selectByUid(Integer uid);
}