package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="student_table")
public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="Student id")
	private int sid;
	@Column(name="Student name")
	private String sname;
    @Column(name="Student Phonenumber")
   	private int phnum;
    public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getPhnum() {
		return phnum;
	}
	public void setPhnum(int phnum) {
		this.phnum = phnum;
	}
	
    

}
