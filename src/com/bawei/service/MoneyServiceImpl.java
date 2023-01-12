package com.bawei.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.PagerUtils;
import com.bawei.entity.TbMiddle;
import com.bawei.entity.TbMiddleKey;
import com.bawei.entity.TbMoney;
import com.bawei.mapper.TbMiddleMapper;
import com.bawei.mapper.TbMoneyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("moneyService")
public class MoneyServiceImpl implements MoneyService {
	
	@Autowired
	private TbMoneyMapper mapper;
	@Autowired
	private TbMiddleMapper middleMapper;

	@Override
	public PageInfo<TbMoney> selectListByName(String mname, Integer pageIndex, Integer pageSize) {
		
		//ʹ�÷�ҳ����
		PageHelper.startPage(pageIndex, pageSize);
		List<TbMoney> list = mapper.selectListByName(mname);
		 //��װ��pageInfo ��
		PageInfo<TbMoney> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public TbMoney selectByPrimaryKey(Integer mid) {
		return mapper.selectByPrimaryKey(mid);
	}

	@Override
	public boolean buy(TbMiddle middle) {
		
		try {
		//1.���м��,TbMiddle����빺����Ϣ
		middleMapper.insert(middle);
		//2.���»����/ �����ٻ������
		mapper.updateBabance(middle.getMid(), middle.getMcount());
		
		return true;
		} catch (Exception e) {
			//
			throw new RuntimeException("����ʧ��:"+e.getMessage());
			//e.printStackTrace();
		}
	}

	@Override
	public List<TbMiddle> selectByUid(Integer uid) {
		return middleMapper.selectByUid(uid);
	}

	@Override
	public boolean chexiao(TbMiddle middle) {
		 try {
	
		//1ɾ���м��
		TbMiddleKey key = new TbMiddleKey();
		key.setMid(middle.getMid());
		key.setUid(middle.getUid());
		middleMapper.deleteByPrimaryKey(key);
		
		//2 �������
		mapper.updateByBalance2(middle.getMid(), middle.getMcount());
		return true;
		} catch (Exception e) {
			throw new RuntimeException("����ʧ��"+e.getMessage());
		}
		  
	}

}
