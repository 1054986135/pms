package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

import com.zs.pms.utils.DateUtil;

public class Tarticle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3926020251068046531L;
	private int id;//id编号
	private String title;//标题
	private String content;//内容
	private String author;//作者
	private Date crtime;//添加日期
	private int channel;//所属栏目
	private int isremod;//是否推荐
	private int ishot;//是否热点
	
	private String cname;//栏目名
	private String isremodTxt;//是否推荐
	private String ishotTxt;//是否热点
	private String crtimeTxt;//显示日期
		
	
	
		public String getCrtimeTxt() {
			return DateUtil.getStrDate(crtime);
	}

	public void setCrtimeTxt(String crtimeTxt) {
		this.crtimeTxt = crtimeTxt;
	}

		public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getIsremodTxt() {
		if (isremod==1) {
			return "是";
		}else {
			return "否";
		}
		
	}

	public void setIsremodTxt(String isremodTxt) {
		this.isremodTxt = isremodTxt;
	}

	public String getIshotTxt() {
		if (ishot==1) {
			return "是";
		}else {
			return "否";
		}
	}

	public void setIshotTxt(String ishotTxt) {
		this.ishotTxt = ishotTxt;
	}

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCrtime() {
		return crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getIsremod() {
		return isremod;
	}

	public void setIsremod(int isremod) {
		this.isremod = isremod;
	}

	public int getIshot() {
		return ishot;
	}

	public void setIshot(int ishot) {
		this.ishot = ishot;
	}

		@Override
		public String toString() {
			return "ArticlePo [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", crtime="
					+ crtime + ", channel=" + channel + ", isremod=" + isremod + ", ishot=" + ishot + "]";
		} 
		
		
		
		
	
}
