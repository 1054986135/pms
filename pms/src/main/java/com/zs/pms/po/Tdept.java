package com.zs.pms.po;

import java.io.Serializable;

public class Tdept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -240378874590096666L;

	private int id;
	private String dname;
	private int pid;
	
	

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
