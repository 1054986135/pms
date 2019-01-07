package com.zs.pms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zs.pms.po.TUser;
@Repository
public interface UserDao2 {
	@Select("select * from tuser where loginname=#{name}")
	public List<TUser> queryByName(String name);

}
