package com.bawei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.TbMoney;

public interface TbMoneyMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(TbMoney record);

    int insertSelective(TbMoney record);

    TbMoney selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(TbMoney record);

    int updateByPrimaryKey(TbMoney record);
    //按照名称查询
    List<TbMoney> selectListByName(@Param("mname")String mname);
    
    //购买成功更新余额
    int updateBabance(@Param("mid")Integer mid ,@Param("mcount")double mcount);
    //撤销购买更新余额
    int updateByBalance2(@Param("mid")Integer mid ,@Param("mcount")double mcount);

}