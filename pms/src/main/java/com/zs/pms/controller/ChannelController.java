package com.zs.pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.Tchannel;
import com.zs.pms.service.ChannelService;
import com.zs.pms.vo.ChannelQuery;
import com.zs.sm.exception.AppException;

/**
 * 栏目控制器
 * @author Administrator
 *
 */
@Controller
public class ChannelController {
	@Autowired
ChannelService cs;
//	去栏目新增页面
@RequestMapping("/tchannel/toadd.do")
	public String toAdd() {
		return "tchannel/add";
		
	}

/**
 * 查询
 * @param query  查询条件
 * @param page   当前页
 * @param map   带回数据
 * @return
 * @throws NumberFormatException 
 */
@RequestMapping("/tchannel/list.do")
public String list(ChannelQuery query,String page,ModelMap map) throws NumberFormatException, AppException {
//	当前页数是空，默认第一页
	if (page==null) {
		page="1";
	}
//	分页数据带入页面
	map.addAttribute("LIST", cs.queryChannelByPage(query,Integer.parseInt(page)));
//	总页数
	map.addAttribute("PAGECONT",cs.queryByCount(query));
//	当前页
	map.addAttribute("PAGE",page);
//	查询条件
	map.addAttribute("QUERY", query);
	return "tchannel/list";
}

/**
 * 新增
 * 
 * @param tchannel
 *            栏目信息
 * @param map
 *            回带
 * @return 列表页
 */
@RequestMapping("/tchannel/add.do")
public String add(Tchannel tchannel, ModelMap map) {
  

	try {
		 cs.insertChannel(tchannel);
		// 跳转url 不需要参数 刷新数据
		return "redirect:list.do";
	} catch (AppException e) {
		// TODO Auto-generated catch block
		map.addAttribute("MSG", e.getErrMsg());
		return "/tchannel/add";
	}

}

@RequestMapping("/tchannel/get.do")
public String get(int id, ModelMap map) {

	// 根据主键获得
	Tchannel tchannel=cs.queryChannelById(id);
	tchannel.setId(id);
	// 带入页面
	map.addAttribute("TCHANNEL", tchannel);

	return "/tchannel/update";

}

/**
 * 修改
 * 
 * @param id
 *            主键
 * @param tchannel
 *            修改的信息
 * @param session
 *            登录人
 * @param map
 *            回带消息
 * @return 列表刷新
 */
@RequestMapping("/tchannel/update.do")
public String update(int id, Tchannel tchannel, HttpSession session, ModelMap map) {
	// 补数据
	tchannel.setId(id); // 主键
	try {
		cs.updateChannel(tchannel);
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
@RequestMapping("tchannel/delete.do")
public String deleteOne(int id) {
	try {
		cs.deleteChannelById(id);

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
@RequestMapping("tchannel/deletes.do")
public String deleteMany(int[] ids) {
	try {
		cs.deletesChannel(ids);

	} catch (AppException e) {
		// TODO Auto-generated catch block

	}
	// 跳转url 不需要参数 刷新数据
	return "redirect:list.do";
}


}
