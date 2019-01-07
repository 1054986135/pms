package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TUser;
import com.zs.pms.vo.UserQuery;
import com.zs.sm.exception.AppException;

public interface UserService {

	public TUser queryByLogin(UserQuery uq) throws AppException;
	
	public TUser queryById(int id);
//	按条件查询
	public List<TUser> queryByCon(UserQuery uq);
//	删除多条
	public void deletes(int[] ids)throws AppException;
//	修改
	public void update(TUser user) throws AppException;
//	分页查询
	public List<TUser> queryByPage(UserQuery query,int page)throws AppException;
//	查询总页数
	public int queryPageCount(UserQuery query);
	
	public List<TUser> queryByName(String name);
	//新增
	public void insert(TUser user ) throws AppException;
//	删除一条
	public void deleteById(int id) throws AppException;
}
