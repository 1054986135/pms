package com.zs.pms.test;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TPermisssion;
import com.zs.pms.po.TUser;
import com.zs.pms.po.Tdept;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.UserQuery;
import com.zs.sm.exception.AppException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUser {
	@Autowired
	UserService us;

	public void testLogin(){
		UserQuery uq=new UserQuery();
		uq.setLoginname("test1");
		uq.setPassword("123");
		TUser ts;
		try {
			ts=us.queryByLogin(uq);
			System.out.println(ts.getRealname()+"他的权限列表是");
			for (TPermisssion tp : ts.getMenu()) {
				System.out.println(tp.getPname());
		    for (TPermisssion children : tp.children) {
				System.out.println("----"+children.getPname());
		}
			}
		} catch (AppException e) {
			System.out.println("数据异常");
		}
	}
	
	  public void testDeletes() {
		  int[] ids={1,2,3};
		  try {
			us.deletes(ids);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	public void testUpdate(){
		TUser user=new TUser();
		user.setCreator(1);
		Tdept td=new Tdept();
		td.setId(1);
		user.setDept(td);
		user.setEmail("123");
		user.setId(1);
		user.setIsenabled(1);
		user.setLoginname("123");
		user.setPassword("123");
		user.setPic("123");
		user.setRealname("123");
		user.setSex("nan1");
		user.setUpdator(121);
		try {
			us.update(user);
		} catch (AppException e) {
			System.out.println("修改失败");
		}
	}

	@Test
	public void testPage() {
		UserQuery query=new UserQuery();
		query.setSex("男");
		List<TUser> list;
		try {
			list = us.queryByPage(query, 1);
			System.out.println("总页数为："+us.queryPageCount(query));
			for (TUser user : list) {
				System.out.println(user.getRealname());
			}
		} catch (AppException e) {
			System.out.println("123");
		}
		
	}

	public void testQuery() {
		List<TUser> users=us.queryByName("test1");
		System.out.println(users.get(0).getRealname());
	}
	public void testAdd() {
		TUser user=new TUser();
		user.setCreator(1);
		Tdept td=new Tdept();
		td.setId(1);
		user.setDept(td);
		user.setEmail("123");
		user.setIsenabled(1);
		user.setLoginname("123");
		user.setPassword("123");
		user.setPic("123");
		user.setRealname("123");
		user.setSex("nan1");
		user.setBirthday(new Date());
		try {
			us.insert(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
