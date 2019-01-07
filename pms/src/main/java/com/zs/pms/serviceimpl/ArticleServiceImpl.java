package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.ArticleDao;
import com.zs.pms.po.Tarticle;
import com.zs.pms.service.ArticleService;
import com.zs.pms.utils.Constant;
import com.zs.pms.vo.ArticleQuery;
import com.zs.sm.exception.AppException;

@Service // spring生成和数据库无关的对象
public class ArticleServiceImpl implements ArticleService {

	// 自动装配对象
	@Autowired
	ArticleDao dao;

	
	/**
	 * 根据id查询数据
	 */
	@Override
	public Tarticle queryById(int id) {
		// TODO Auto-generated method stub

		// 返回根据id查询文章的方法
		return dao.queryArticleById(id);
	}

	
	/**
	 * 多条件查询语句
	 */
	@Override
	public List<Tarticle> queryArticleByCon(ArticleQuery query) throws AppException {

		return dao.queryArticleByCon(query);
	}

	
	/**
	 * 分页查询
	 */
	@Override
	public List<Tarticle> queryArticleByPage(ArticleQuery query, int page) {
		// TODO Auto-generated method stub

		// 根据页数算初始截止数
		// 起始,从0开始，需要加一
		int s = (page - 1) * Constant.SIZE + 1;
		// 截止
		int e = page * Constant.SIZE;
		query.setStart(s);
		query.setEnd(e);
		return dao.queryArticleByPage(query);
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int queryPageCount(ArticleQuery query) {
		// TODO Auto-generated method stub
		// 总条数
		int count = dao.queryByCount(query);

		// 是每条页数的倍数。例如条数定死5，共有20条，就有4页
		if (count % Constant.SIZE == 0) {
			return count / Constant.SIZE;
		}
		// 有余数则把剩余的分到下一页
		else {
			return count / Constant.SIZE + 1;
		}
	}

	/**
	 *  根据id进行删除
	 */
	@Override
	public void deleteArticle(int id) throws AppException {
		// TODO Auto-generated method stub
		dao.deleteArticleById(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public int deletesArticle(int[] ids) throws AppException {
		// TODO Auto-generated method stub
		return dao.deletesArticle(ids);
	}
	
	

	/**
	 * 新增数据
	 */
	@Override
	public int insertArticle(Tarticle tarticle) throws AppException {
		// TODO Auto-generated method stub

		// 添加主键				
		dao.insertArticle(tarticle);
		// 返回主键
		return tarticle.getId();
	}

	/**
	 * 修改数据
	 */
	@Override
	public void updateArticle(Tarticle tarticle) throws AppException {
		// TODO Auto-generated method stub
		dao.updateArticle(tarticle);
	}

}
