package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zs.pms.po.TUser;
import com.zs.pms.po.Tdept;
import com.zs.pms.service.DepService;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.UserQuery;
import com.zs.sm.exception.AppException;

/*
 * 用户管理控制器
 * @author Administrator
 */
@Controller
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	DepService ds;
//	去用户新增页面
@RequestMapping("/user/toadd.do")
	public String toAdd(ModelMap map) {
//	把第一部门带入
	map.addAttribute("DLIST1", ds.queryByPid(0));
		return "user/add";
		
	}
@ResponseBody //json返回
@RequestMapping("user/getDep2.do")
public List<Tdept> queryDep2(int pid){
	return ds.queryByPid(pid);
	
}

/**
 * 查询
 * @param query  查询条件
 * @param page   当前页
 * @param map   带回数据
 * @return
 * @throws NumberFormatException 
 */
@RequestMapping("/user/list.do")
public String list(UserQuery query,String page,ModelMap map) throws NumberFormatException, AppException {
//	当前页数是空，默认第一页
	if (page==null) {
		page="1";
	}
//	分页数据带入页面
	map.addAttribute("LIST", us.queryByPage(query,Integer.parseInt(page)));
//	总页数
	map.addAttribute("PAGECONT",us.queryPageCount(query));
//	当前页
	map.addAttribute("PAGE",page);
//	查询条件
	map.addAttribute("QUERY", query);
	return "user/list";
}

/**
 * 新增
 * 
 * @param user
 *            用户信息
 * @param session
 *            登录人信息
 * @param map
 *            回带
 * @return 列表页
 */
@RequestMapping("/user/add.do")
public String add(TUser user, HttpSession session, ModelMap map) {
	TUser cu = (TUser) session.getAttribute("CUSER");
	// 当前登录人
	user.setCreator(cu.getId());
	// 可用
	user.setIsenabled(1);

	try {
		us.insert(user);
		// 跳转url 不需要参数 刷新数据
		return "redirect:list.do";
	} catch (AppException e) {
		// TODO Auto-generated catch block
		map.addAttribute("MSG", e.getErrMsg());
		return "/user/add";
	}

}


@RequestMapping("/user/get.do")
public String get(int id, ModelMap map) {

	// 根据主键获得
	TUser user=us.queryById(id);
	user.setId(id);
	// 带入页面
	map.addAttribute("USER", user);

	return "/user/update";

}

/**
 * 修改
 * 
 * @param id
 *            主键
 * @param user
 *            修改的信息
 * @param session
 *            登录人
 * @param map
 *            回带消息
 * @return 列表刷新
 */
@RequestMapping("/user/update.do")
public String update(int id, TUser user, HttpSession session, ModelMap map) {
	// 补数据
	user.setId(id); // 主键
	TUser cu = (TUser) session.getAttribute("CUSER");
	user.setUpdator(cu.getId());// 修改人
	try {
		us.update(user);
		// 跳转url 不需要参数 刷新数据
		return "redirect:list.do";
	} catch (AppException e) {
		// TODO Auto-generated catch block
		map.addAttribute("MSG", e.getErrMsg());
		// 带数据
		return this.get(id, map);
	}

}

/**
 * 根据主键删除
 * @param id
 * @return
 */
@RequestMapping("user/delete.do")
public String deleteOne(int id) {
	try {
		us.deleteById(id);

	} catch (AppException e) {
		// TODO Auto-generated catch block

	}
	// 跳转url 不需要参数 刷新数据
	return "redirect:list.do";
}

/**
 * 批量删除
 * @param ids  多选框的name
 * @return
 */
@RequestMapping("user/deletes.do")
public String deleteMany(int[] ids) {
	try {
		us.deletes(ids);

	} catch (AppException e) {
		// TODO Auto-generated catch block

	}
	// 跳转url 不需要参数 刷新数据
	return "redirect:list.do";
}

}

