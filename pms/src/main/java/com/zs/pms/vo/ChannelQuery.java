package com.zs.pms.vo;
/**
 * 栏目的多条件查询类
 * @author LXG
 *
 */

import java.io.Serializable;

public class ChannelQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1481484512782951659L;

	
	private String cname;//栏目名称
	
	// 起始行
	private int start;
	// 截止行,每行最多展示条数
	private int end;
	
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	
}
