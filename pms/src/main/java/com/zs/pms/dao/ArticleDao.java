package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.Tarticle;
import com.zs.pms.vo.ArticleQuery;
import com.zs.sm.exception.AppException;



/**
 * 文章数据操作对象
 * 
 * @author LXG
 *
 */
public interface ArticleDao {

	// 1、根据条件查询
	public List<Tarticle> queryArticleByCon(ArticleQuery query);

	// 2、根据id进行查询
	public Tarticle queryArticleById(int id);

	// 3、分页查询
	public List<Tarticle> queryArticleByPage(ArticleQuery query);

	// 4、查询条数
	public int queryByCount(ArticleQuery query);

	// 5、根据id进行删除
	public void deleteArticleById(int id) throws AppException;

	// 6、批量删除
	public int deletesArticle(int[] ids) throws AppException;

	// 7、新增数据
	public int insertArticle(Tarticle tarticle) throws AppException;

	// 8、修改数据
	public void updateArticle(Tarticle tarticle) throws AppException;

}
