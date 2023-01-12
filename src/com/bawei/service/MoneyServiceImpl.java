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
		
		//使用分页助手
		PageHelper.startPage(pageIndex, pageSize);
		List<TbMoney> list = mapper.selectListByName(mname);
		 //封装到pageInfo 中
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
		//1.向中间表,TbMiddle表插入购买信息
		middleMapper.insert(middle);
		//2.更新基金表/ 即减少基金余额
		mapper.updateBabance(middle.getMid(), middle.getMcount());
		
		return true;
		} catch (Exception e) {
			//
			throw new RuntimeException("购买失败:"+e.getMessage());
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
	
		//1删除中间表
		TbMiddleKey key = new TbMiddleKey();
		key.setMid(middle.getMid());
		key.setUid(middle.getUid());
		middleMapper.deleteByPrimaryKey(key);
		
		//2 更新余额
		mapper.updateByBalance2(middle.getMid(), middle.getMcount());
		return true;
		} catch (Exception e) {
			throw new RuntimeException("撤销失败"+e.getMessage());
		}
		  
	}

}
