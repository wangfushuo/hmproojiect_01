package com.bawei.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.entity.TbUser;
import com.bawei.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 跳转到注册页面
	@RequestMapping("toZhuce")
	public String toZhuce() {
		return "zhuce";
	}

	// 执行注册
	@ResponseBody
	@RequestMapping("zhuce")
	public boolean zhuce(TbUser user){
		
		int i = userService.zhuce(user);
		if(i>0)
			return true;//注册成功
		  return false;
	}
	@ResponseBody
	@RequestMapping("validate")
	public boolean validate(String uname){
		int i = userService.selectCountByName(uname);
		if(i>0)
		return false;//如果用户存在则返回false
		return true;
	}
	//登录
	
	@RequestMapping("login")
	public String login(String uname,String upwd,HttpSession session,Model model){
		TbUser user = userService.login(uname, upwd);
		if(null!=user){//登录成功
			//1.把用户信息存入到session
			 user.setUpwd(null);//去掉用户密码
			session.setAttribute("user", user);
			//2.重定向到跳转到基金列表页面
			return "redirect:money/list";
		}else{//登录失败
			model.addAttribute("lgError", "登录失败,检查用户名或密码!");
			return "index";
			
		}
		
	}
	
	//注销
	@RequestMapping("logout")
	public String logout(HttpSession session){
		//让session过期 方式-
		session.invalidate();
		//方式二
		//session.removeAttribute("user");
		return "index";
	}

}
