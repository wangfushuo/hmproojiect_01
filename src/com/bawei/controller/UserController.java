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

	// ��ת��ע��ҳ��
	@RequestMapping("toZhuce")
	public String toZhuce() {
		return "zhuce";
	}

	// ִ��ע��
	@ResponseBody
	@RequestMapping("zhuce")
	public boolean zhuce(TbUser user){
		
		int i = userService.zhuce(user);
		if(i>0)
			return true;//ע��ɹ�
		  return false;
	}
	@ResponseBody
	@RequestMapping("validate")
	public boolean validate(String uname){
		int i = userService.selectCountByName(uname);
		if(i>0)
		return false;//����û������򷵻�false
		return true;
	}
	//��¼
	
	@RequestMapping("login")
	public String login(String uname,String upwd,HttpSession session,Model model){
		TbUser user = userService.login(uname, upwd);
		if(null!=user){//��¼�ɹ�
			//1.���û���Ϣ���뵽session
			 user.setUpwd(null);//ȥ���û�����
			session.setAttribute("user", user);
			//2.�ض�����ת�������б�ҳ��
			return "redirect:money/list";
		}else{//��¼ʧ��
			model.addAttribute("lgError", "��¼ʧ��,����û���������!");
			return "index";
			
		}
		
	}
	
	//ע��
	@RequestMapping("logout")
	public String logout(HttpSession session){
		//��session���� ��ʽ-
		session.invalidate();
		//��ʽ��
		//session.removeAttribute("user");
		return "index";
	}

}
