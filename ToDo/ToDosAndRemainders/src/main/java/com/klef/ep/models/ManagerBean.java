package com.klef.ep.models;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "managerBean",eager = true)
public class ManagerBean 
{
	private int mid;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	private String mname;
	private String mpwd;

}
