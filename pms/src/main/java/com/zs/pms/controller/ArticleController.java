package com.zs.pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.po.Tarticle;
import com.zs.pms.po.Tchannel;
import com.zs.pms.service.ArticleService;
import com.zs.pms.vo.ArticleQuery;
import com.zs.sm.exception.AppException;

/**
 * 文章控制器
 * @author Administrator
 *
 */
@Controller
public class ArticleController {
	@Autowired
	ArticleService  as;
	@RequestMapping("/tarticle/toadd.do")
	public String toAdd() {
		return "tarticle/add";
		
	}
	
	/**
	 * 查询
	 * @param query  查询条件
	 * @param page   当前页
	 * @param map   带回数据
	 * @return
	 * @throws NumberFormatException 
	 */
	@RequestMapping("/tarticle/list.do")
	public String list(ArticleQuery query,String page,ModelMap map) throws NumberFormatException, AppException {
//		当前页数是空，默认第一页
		if (page==null) {
			page="1";
		}
//		分页数据带入页面
		map.addAttribute("LIST", as.queryArticleByPage(query,Integer.parseInt(page)));
//		总页数
		map.addAttribute("PAGECONT",as.queryPageCount(query));
//		当前页
		map.addAttribute("PAGE",page);
//		查询条件
		map.addAttribute("QUERY", query);
		return "tarticle/list";
	}

	/**
	 * 新增
	 * 
	 * @param tarticle
	 *            栏目信息
	 * @param map
	 *            回带
	 * @return 列表页
	 */
	@RequestMapping("/tarticle/add.do")
	public String add(Tarticle tarticle, ModelMap map) {
	  

		try {
			 as.insertArticle(tarticle);
			// 跳转url 不需要参数 刷新数据
			return "redirect:list.do";
		} catch (AppException e) {
			// TODO Auto-generated catch block
			map.addAttribute("MSG", e.getErrMsg());
			return "/tarticle/add";
		}

	}
	@RequestMapping("/tarticle/get.do")
	public String get(int id, ModelMap map) {

		// 根据主键获得
		Tarticle tarticle=as.queryById(id);
		tarticle.setId(id);
		// 带入页面
		map.addAttribute("TARTICLE", tarticle);

		return "/tarticle/update";

	}
	
	/**
	 * 修改
	 * 
	 * @param id
	 *            主键
	 * @param tarticle
	 *            修改的信息
	 * @param session
	 *            登录人
	 * @param map
	 *            回带消息
	 * @return 列表刷新
	 */
	@RequestMapping("/tarticle/update.do")
	public String update(int id, Tarticle tarticle, HttpSession session, ModelMap map) {
		// 补数据
		tarticle.setId(id); // 主键
		try {
			as.updateArticle(tarticle);
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
	@RequestMapping("tarticle/delete.do")
	public String deleteOne(int id) {
		try {
			as.deleteArticle(id);

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
	@RequestMapping("tarticle/deletes.do")
	public String deleteMany(int[] ids) {
		try {
			as.deletesArticle(ids);

		} catch (AppException e) {
			// TODO Auto-generated catch block

		}
		// 跳转url 不需要参数 刷新数据
		return "redirect:list.do";
	}

}
