package com.zs.pms.test;
/**
 * 测试文章
 * @author 
 *
 */

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.Tarticle;
import com.zs.pms.po.Tchannel;
import com.zs.pms.service.ArticleService;
import com.zs.pms.vo.ArticleQuery;
import com.zs.sm.exception.AppException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestArticle {

	@Autowired
	ArticleService as;

	//根据id查询数据
	
	public void testQueryById() {
		Tarticle tarticle = as.queryById(1);
		System.out.println(tarticle.getTitle());
	}

	// 多条件查询
	public void testQueryByCon() {
		ArticleQuery query = new ArticleQuery();
		query.setTitle("语文");
		query.setAuthor("老舍");
		try {
			System.out.println(as.queryArticleByCon(query).get(0).getContent());
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}
	}

	// 分页查询
	
	public void testQueryByPage() {
		ArticleQuery query = new ArticleQuery();
		List<Tarticle> list = as.queryArticleByPage(query, 1);

		for (Tarticle tarticle : list) {
			System.out.println(tarticle);
		}
	}

	// 测试条数

	public void testQueryCount() {
		ArticleQuery query = new ArticleQuery();
		List<Tarticle> list = as.queryArticleByPage(query, 1);
		System.out.println("总页数为" + as.queryPageCount(query));
		for (Tarticle tarticle : list) {
			System.out.println(tarticle);
		}
	}

	// 根据id删除数据
	public void testDel() {
		try {
			as.deleteArticle(1);
			System.out.println("根据id删除成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}
		

	}

	// 批量删除数据
	@Test
	public void testDels() {
		// 传入要删除的参数值，和数据库一致
		int[] id = {2,3 };
		// 执行批量删除条件
		try {
			as.deletesArticle(id);
			System.out.println("批量删除成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}
		
	}

	// 新增文章
	public void testAdd() {
		// 创建对象
		Tarticle tarticle = new Tarticle();
		// 放入数据
		tarticle.setTitle("语文");
		tarticle.setContent("骆驼祥子");
		tarticle.setAuthor("老舍");

		Tchannel tchannel = new Tchannel();
		tchannel.setId(1);
		tarticle.setIsremod(1);
		tarticle.setIshot(1);

		// 放入新增的方法
		try {
			as.insertArticle(tarticle);
			System.out.println("新增成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}
	}

	// 修改数据
	public void testUp() {

		// 创建对象
		Tarticle tarticle = new Tarticle();
		tarticle.setId(1);
		// 放入数据
		tarticle.setTitle("语文");
		tarticle.setContent("五柳先生传");
		tarticle.setAuthor("柳宗元");
		Tchannel tchannel = new Tchannel();
		tchannel.setId(1);
		tarticle.setIsremod(1);
		tarticle.setIshot(1);
		
		try {
			as.updateArticle(tarticle);
			System.out.println("修改成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}
	}
}
