package com.bawei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.entity.TbUser;
import com.bawei.mapper.TbUserMapper;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper mapper;
	
	@Override
	public int zhuce(TbUser user) {
		return mapper.insert(user);
	}

	@Override
	public int selectCountByName(String uname) {
		return mapper.selectCountByName(uname);
	}

	@Override
	public TbUser login(String uname, String upwd) {
		return mapper.login(uname, upwd);
	}

}
