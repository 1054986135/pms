package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.TPermisssion;
import com.zs.pms.po.TUser;


@Controller
public class FrameController {
	@RequestMapping("/top.do")
	public String top() {
		return "top";
	}
	@RequestMapping("/left.do")
	public String left(HttpSession session,ModelMap map) {
		/*
		 * 加权限菜单
		 */
//		从session中获取当前登陆用用户
		TUser user=(TUser) session.getAttribute("CUSER");
//		获取该用户的登陆菜单
		List<TPermisssion> menu=user.getMenu();
//		带入left页面
		map.addAttribute("menu", menu);
		
		return "left";
	}
	@RequestMapping("/right.do")
	public String right() {
		return "right";
	}

}
