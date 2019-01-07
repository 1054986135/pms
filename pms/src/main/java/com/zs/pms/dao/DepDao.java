package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.Tdept;

public interface DepDao {
	
	public List<Tdept> queryByPid(int pid);

}
