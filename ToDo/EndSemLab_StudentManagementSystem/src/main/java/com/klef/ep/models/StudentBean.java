package com.klef.ep.models;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;

import com.klef.ep.services.StudentService;

@ManagedBean(name = "studentBean",eager = true)
public class StudentBean {
	
	private int sid;
	private String sname;
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
	
	
	@EJB(lookup = "java:global/EndSemLab_StudentManagementSystem/StudentServiceImpl!com.klef.ep.services.StudentService")
	StudentService studentService;
	
	public void insertstudent()
	{
		String response;
		try
		{
			int sid=123;
			String sname="William";
			int phnum=75632;
			Student s = new Student();
			
			s.setSid(sid);
			s.setSname(sname);
			s.setPhnum(phnum);
			response=StudentService.insertstudent(s);
		}
		catch(Exception e)
		{
			response=e.getMessage();
		}
	}
	

	
}
