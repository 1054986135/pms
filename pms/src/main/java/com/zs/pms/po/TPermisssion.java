package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * TPermisssion 表实体
 *
 */

public class TPermisssion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5983509185410200106L;

	private int id;
	private String pname;
	private int pid;
	private int lev;
	private int isleaf;
	private int sorts;
	private String url;
	private String icon;
	
//	子菜单
	public List<TPermisssion> children=new ArrayList<TPermisssion>();
//	添加子权限  一个一个加进去
	public void addChildren(TPermisssion tp){
		children.add(tp);
	}
	
	public List<TPermisssion> getChildren() {
		return children;
	}
//	一次性加进去
	public void setChildren(List<TPermisssion> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
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
	public int getSorts() {
		return sorts;
	}
	public void setSorts(int sorts) {
		this.sorts = sorts;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
