package com.klef.ep.models;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name="manager_table")
public class Manager implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="managerid")
	private int mid;
    @Column(name="managername")
	private String mname;
    @Column(name="managerpwd")
   	private String mpwd;
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
	
	
 

}
