package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.Tdept;

public interface DepService {

	public List<Tdept> queryByPid(int pid);
}
