package com.bawei.service;

import org.apache.ibatis.annotations.Param;

import com.bawei.entity.TbUser;

public interface UserService {
	
	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	int zhuce(TbUser user);
	
	   //���û�ȥͳ�Ƹ��û��Ƿ����
    int selectCountByName(String uname);
    
    
    //��¼
    TbUser login(String uname,String upwd);
	
	

}
