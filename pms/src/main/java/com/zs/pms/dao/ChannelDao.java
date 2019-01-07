package com.zs.pms.dao;

import java.util.List;


import com.zs.pms.po.Tchannel;
import com.zs.pms.vo.ChannelQuery;
import com.zs.sm.exception.AppException;

/**
 * 栏目的实体
 * @author LXG
 *
 */
public interface ChannelDao {

        //1、根据条件查询
		public List<Tchannel> queryChannelByCon(ChannelQuery query);
		
		//2、根据id进行查询
		public Tchannel queryChannelById(int id);
		
		//3、分页查询
		public List<Tchannel> queryChannelByPage(ChannelQuery query);
		
		//4、查询条数
		public int queryByCount(ChannelQuery query);
		
		//5、根据id进行删除
		public void deleteChannelById(int id)throws AppException;
		
		//6、批量删除
		public int deletesChannel(int[] ids)throws AppException;
		
		//7、新增数据
		public int insertChannel(Tchannel tchannel)throws AppException;
		
		//8、修改数据
		public void updateChannel(Tchannel tchannel)throws AppException;
		
		
}
