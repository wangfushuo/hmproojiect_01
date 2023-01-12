package com.bawei.service;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.TbUser;

public interface UserService {
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	int zhuce(TbUser user);
	
	   //按用户去统计该用户是否存在
    int selectCountByName(String uname);
    
    
    //登录
    TbUser login(String uname,String upwd);
	
	

}
