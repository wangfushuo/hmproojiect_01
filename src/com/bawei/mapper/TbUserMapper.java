package com.bawei.mapper;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.TbUser;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
    
    //按用户去统计该用户是否存在
    int selectCountByName(String uname);
    //登录
    TbUser login(@Param("uname")String uname,@Param("upwd")String upwd);
    
    
}