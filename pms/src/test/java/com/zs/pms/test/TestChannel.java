package com.zs.pms.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zs.pms.po.Tchannel;
import com.zs.pms.service.ChannelService;
import com.zs.pms.vo.ChannelQuery;
import com.zs.sm.exception.AppException;

/**
 * 测试栏目
 * 
 * @author
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestChannel {

	@Autowired
	ChannelService cs;

//根据id查询数据

	public void testQueryById() {
		Tchannel tchannel = cs.queryChannelById(10086);
		System.out.println(tchannel.getCname());
	}

	// 多条件查询
	public void testQueryByCon() {
		ChannelQuery query = new ChannelQuery();
		query.setCname("四大名著");
		// 声明文章实体 
		System.out.println(cs.queryChannelByCon(query).get(1).getId());
	}

	// 分页查询
	public void testQueryByPage() {
		ChannelQuery query = new ChannelQuery();
		List<Tchannel> list = cs.queryChannelByPage(query, 1);

		for (Tchannel channel : list) {
			System.out.println(channel);
		}
	}

	// 测试条数
	public void testQueryCount() {
		ChannelQuery query = new ChannelQuery();
		List<Tchannel> list = cs.queryChannelByPage(query, 1);
		System.out.println("总页数为" + cs.queryByCount(query));
		for (Tchannel channel : list) {
			System.out.println(channel);
		}
	}

	// 根据id删除数据
	public void testDel() {
		try {
			cs.deleteChannelById(2);
			System.out.println("根据id删除成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}

	}
	
	// 批量删除数据
	public void testDels() {
		// 传入要删除的参数值，和数据库一致
		int[] id = { 10086, 10087 };
		// 执行批量删除条件
		try {
			cs.deletesChannel(id);
			System.out.println("批量删除成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}
	}

	// 新增文章
	public void testAdd() {
		// 创建对象
		Tchannel tchannel = new Tchannel();
		// 放入数据
		tchannel.setCname("历史");
		tchannel.setPid(0);
		tchannel.setLev(1);
		tchannel.setIsleaf(1);
		tchannel.setSort(1);
		// 放入新增的方法
		try {
			cs.insertChannel(tchannel);
			System.out.println("新增成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}
	}

	// 修改数据
	public void testUp() {
		// 创建对象
		Tchannel tchannel = new Tchannel();
		// 放入数据
		tchannel.setId(2);
		tchannel.setCname("数学");
		tchannel.setPid(2);
		tchannel.setLev(2);
		tchannel.setIsleaf(2);
		tchannel.setSort(2);

		try {
			cs.updateChannel(tchannel);
			System.out.println("修改成功");
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.getErrMsg();
		}

	}

}
