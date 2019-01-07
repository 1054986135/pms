package com.zs.pms.vo;

import java.io.Serializable;

/**
 * 多条件查询文章
 * @author LXG
 *
 */
public class ArticleQuery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8730803360244411721L;
	//根据标题查询数据
	private String title;
	//根据作者查询数据
	private String author;
	
	
	//起始行
	private int start;
	//截止行,每行最多展示条数
	private int end;
	
	
	
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
