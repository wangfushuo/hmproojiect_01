package com.bawei.service;

import java.util.List;

import com.bawei.entity.TbMiddle;
import com.bawei.entity.TbMiddleKey;
import com.bawei.entity.TbMoney;
import com.github.pagehelper.PageInfo;

public interface MoneyService {

	  //按照名称查询
	PageInfo<TbMoney> selectListByName(String mname,Integer pageIndex,Integer pageSize);
	//根据ID 返回基金对象
	 TbMoney selectByPrimaryKey(Integer mid);
	 //购买基金
	 boolean buy(TbMiddle middle);
	 
	  //根据用户ID 查询购买明细
	    List<TbMiddle> selectByUid(Integer uid);
	    
	  //购买基金
        boolean chexiao(TbMiddle middle);   
	    
}
