package com.bawei.service;

import java.util.List;

import com.bawei.entity.TbMiddle;
import com.bawei.entity.TbMiddleKey;
import com.bawei.entity.TbMoney;
import com.github.pagehelper.PageInfo;

public interface MoneyService {

	  //�������Ʋ�ѯ
	PageInfo<TbMoney> selectListByName(String mname,Integer pageIndex,Integer pageSize);
	//����ID ���ػ������
	 TbMoney selectByPrimaryKey(Integer mid);
	 //�������
	 boolean buy(TbMiddle middle);
	 
	  //�����û�ID ��ѯ������ϸ
	    List<TbMiddle> selectByUid(Integer uid);
	    
	  //�������
        boolean chexiao(TbMiddle middle);   
	    
}
