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
   //@RequestParam(defaultValue="1") Integer page  :  如果page 没有传值则默认 为1
	@RequestMapping("/list")
	public String list(String mname,@RequestParam(defaultValue="1")Integer page,HttpServletRequest request){
		int pageSize =3;//每页记录数
		
		PageInfo<TbMoney> pageInfo = service.selectListByName(mname, page, pageSize);
		//初始化分页工具类
		PageUtil.page(request, "/money/list", pageSize, pageInfo.getList(),(int) pageInfo.getTotal(), page);
		//封装集合
		request.setAttribute("list", pageInfo.getList());
		//封装查询条件
		request.setAttribute("mname", mname);
		
	  return "list";
	}
	//跳转到购买页面
	@RequestMapping("toBuy")
	public String toBuy(Integer mid,Model model){
		TbMoney tbMoney = service.selectByPrimaryKey(mid);
		model.addAttribute("money", tbMoney);
		return "buy";
	}
	//执行购买
	@ResponseBody
	@RequestMapping("buy")
	public boolean buy(TbMiddle middle ){
		return service.buy(middle);
	}
	//查看购买明细
	@RequestMapping("showMoney")
	public String showMoney(Integer uid ,Model model){
		List<TbMiddle> list = service.selectByUid(uid);
		model.addAttribute("list", list);
		return "showMoney";
	}
	//撤销
	@ResponseBody
	@RequestMapping("deleteByUidAndMid")
	public boolean deleteByUidAndMid(TbMiddle middle){
		return service.chexiao(middle);
	}
	
}
