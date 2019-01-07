package com.zs.pms.po;

import java.io.Serializable;

public class Tchannel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -383994779416829417L;


	private int id;//编号
	private String cname;//栏目名
	private int pid;//上级栏目
	private int lev;//级别
	private int isleaf;//是否叶子
	private int sort;//顺序
	
	private String pidtxt;//上级栏目名
	private String isleafTxt;//是否叶子
	private String levTxt;//等级
	
	public String getLevTxt() {
		if (lev==1) {
           return"第一等级";
			} else {
		   return "第二等级";
			}
	}
	public void setLevTxt(String levTxt) {
		this.levTxt = levTxt;
	}
	public String getPidtxt() {
		return pidtxt;
	}
	public void setPidtxt(String pidtxt) {
		this.pidtxt = pidtxt;
	}
	public String getIsleafTxt() {
		if (isleaf==1) {
           return "是叶子";
		} else {
		 return "不是叶子";
		}
	}
	public void setIsleafTxt(String isleafTxt) {
		this.isleafTxt = isleafTxt;
	}
	public String getCname() {
		return cname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPid() {
		if ("pid"!=null) {
			return pid;
		}else {
		     return   0;
		}	
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getLev() {
		
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
	@Override
	public String toString() {
		return "ChannelPo [id=" + id + ", cname=" + cname + ", pid=" + pid + ", lev=" + lev + ", isleaf=" + isleaf
				+ ", sort=" + sort + "]";
	}
	
	
	
	
	
}
