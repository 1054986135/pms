package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.UserDao;
import com.zs.pms.dao.UserDao2;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constant;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.UserQuery;
import com.zs.sm.exception.AppException;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao dao;
	@Autowired
	UserDao2 dao2;

	@Override
	public TUser queryByLogin(UserQuery uq) throws AppException {
		/**
		 * 明码转密码
		 */
		if (!"".equals(uq.getPassword())&&uq.getPassword()!=null) {
			MD5 md5=new MD5();
			//加密后的密码
			String pws=md5.getMD5ofStr(uq.getPassword());
			uq.setPassword(pws);
		}
		
		List<TUser> users=dao.queryByCon(uq);
		if (users==null|| users.size()!=1) {
			throw new AppException(10000, "账号或密码错误");
		}
//	获得登录用户
		TUser us=users.get(0);
		//关联权限列表
		return dao.queryById(us.getId());
	}

	@Override
	public TUser queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

	@Override
	public List<TUser> queryByCon(UserQuery uq){
		// TODO Auto-generated method stub
		return dao.queryByCon(uq);
	}
//批量删除
	@Override
	public void deletes(int[] ids) throws AppException {
		// TODO Auto-generated method stub
		dao.deletes(ids);
		
	}
//  修改
	@Override
	public void update(TUser user) throws AppException {
		// TODO Auto-generated method stub

				if (user.getPassword() == null || user.getPassword().length() <= 4) {
					throw new AppException(1004, "用户密码不得少于6位 ");
				}

				/*
				 * 明码变密码 
				 * 
				 */
				//如果数据库中的密码不等于页面上传过来的密码则密码改变了，需要加密
				if (!dao.queryById(user.getId()).getPassword().equals(user.getPassword())) {
					MD5 md5 = new MD5();
					// 加密后的密码
					String pwd = md5.getMD5ofStr(user.getPassword());
					user.setPassword(pwd);
				}

				dao.update(user);
			}

//分页查询
	@Override
	public List<TUser> queryByPage(UserQuery query, int page) {
		// TODO Auto-generated method stub
//		根据页数算起止数
		int s=(page-1)*Constant.SIZE+1;
		int e=page*Constant.SIZE;
		query.setStart(s);
		query.setEnd(e);
		
		return dao.queryByPage(query);
	}

	@Override
	public int queryPageCount(UserQuery query) {
		// TODO Auto-generated method stub
//		总条数
		int cont=dao.queryCount(query);
//		是每页条数的倍数
		if (cont%Constant.SIZE==0) {
			return cont/Constant.SIZE;
		}
//		有余数
		return cont/Constant.SIZE+1;
	}

	@Override
	public List<TUser> queryByName(String name) {
		// TODO Auto-generated method stub
		return dao2.queryByName(name);
	}

	@Override
	public void insert(TUser user) {
		// TODO Auto-generated method stub
		dao.insert(user);
	}

	@Override
	public void deleteById(int id) throws AppException {
		// TODO Auto-generated method stub
		 dao.delete(id);
		 
	}


}
