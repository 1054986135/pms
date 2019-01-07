package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zs.pms.utils.DateUtil;
/* *
 * TUser表实体
 */
public class TUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5293214558214995122L;

	private int id;
	private String loginname;
	private String password;
	private String sex;
	private Date birthday;
	private String email;
	private Tdept dept;
	private String realname;
	private int creator;
	private Date creatime;
	private int updator;
	private Date updatime;
	private String pic;
	private int isenabled;
	// 日期显示
	private String birthdayTxt;
		// 是否可用显示
	private String enabledTxt;
//	该用户所有的权限
	private List<TPermisssion> plist;
//	整理后的菜单
	private List<TPermisssion> menu=new ArrayList<TPermisssion>();
	
	public List<TPermisssion> getMenu() {
		/*
		 * 根据plist生成菜单
		 */
//		清空一级菜单
		menu.clear();
		for (TPermisssion prs1 : plist) {
			if (prs1.getPid()==0) {
				/*
				 * 找出该一级菜单下的二级菜单
				 */
//				清空二级菜单
				prs1.getChildren().clear();
				for (TPermisssion prs2 : plist) {
//					一级菜单的id等于二级菜单的上级id
					if (prs2.getPid()==prs1.getId()) {
//						加入到子权限列表中
						prs1.addChildren(prs2);
						
					}
				}
//    prs1中带着list<prs2>
				menu.add(prs1);
			}
		}
		return menu;
	}

	public void setMenu(List<TPermisssion> menu) {
		this.menu = menu;
	}
	

	public String getBirthdayTxt() {
		return DateUtil.getStrDate(birthday);
	}

	public void setBirthdayTxt(String birthdayTxt) {
		this.birthdayTxt = birthdayTxt;
	}

	public String getEnabledTxt() {
		if(isenabled==1) {
			return "可用";
		}
		else {
			return "不可用";
		}
	}

	public void setEnabledTxt(String enabledTxt) {
		this.enabledTxt = enabledTxt;
	}

	public List<TPermisssion> getPlist() {
		return plist;
	}
	public void setPlist(List<TPermisssion> plist) {
		this.plist = plist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Tdept getDept() {
		return dept;
	}
	public void setDept(Tdept dept) {
		this.dept = dept;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public int getUpdator() {
		return updator;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	@Override
	public String toString() {
		return "TUser [id=" + id + ", loginname=" + loginname + ", password=" + password + ", sex=" + sex
				+ ", birthday=" + birthday + ", email=" + email + ", dept=" + dept + ", realname=" + realname
				+ ", creator=" + creator + ", creatime=" + creatime + ", updator=" + updator + ", updatime=" + updatime
				+ ", pic=" + pic + ", isenabled=" + isenabled + "]";
	}
	
	
}
