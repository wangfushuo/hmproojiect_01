package com.bawei.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.entity.TbMiddle;
import com.bawei.entity.TbMiddleKey;
import com.bawei.entity.TbMoney;
import com.bawei.service.MoneyService;
import com.bawei.utils.PageUtil;
import com.github.pagehelper.PageInfo;

@RequestMapping("money")
@Controller
public class MoneyController {
	@Autowired
	private MoneyService service;
   //@RequestParam(defaultValue="1") Integer page  :  ���page û�д�ֵ��Ĭ�� Ϊ1
	@RequestMapping("/list")
	public String list(String mname,@RequestParam(defaultValue="1")Integer page,HttpServletRequest request){
		int pageSize =3;//ÿҳ��¼��
		
		PageInfo<TbMoney> pageInfo = service.selectListByName(mname, page, pageSize);
		//��ʼ����ҳ������
		PageUtil.page(request, "/money/list", pageSize, pageInfo.getList(),(int) pageInfo.getTotal(), page);
		//��װ����
		request.setAttribute("list", pageInfo.getList());
		//��װ��ѯ����
		request.setAttribute("mname", mname);
		
	  return "list";
	}
	//��ת������ҳ��
	@RequestMapping("toBuy")
	public String toBuy(Integer mid,Model model){
		TbMoney tbMoney = service.selectByPrimaryKey(mid);
		model.addAttribute("money", tbMoney);
		return "buy";
	}
	//ִ�й���
	@ResponseBody
	@RequestMapping("buy")
	public boolean buy(TbMiddle middle ){
		return service.buy(middle);
	}
	//�鿴������ϸ
	@RequestMapping("showMoney")
	public String showMoney(Integer uid ,Model model){
		List<TbMiddle> list = service.selectByUid(uid);
		model.addAttribute("list", list);
		return "showMoney";
	}
	//����
	@ResponseBody
	@RequestMapping("deleteByUidAndMid")
	public boolean deleteByUidAndMid(TbMiddle middle){
		return service.chexiao(middle);
	}
	
}
