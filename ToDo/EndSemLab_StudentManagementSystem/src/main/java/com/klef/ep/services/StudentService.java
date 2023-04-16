package com.klef.ep.services;

import javax.ejb.Remote;

import com.klef.ep.models.Student;

@Remote
public interface StudentService 
{
	public static String insertstudent(Student s) {
		// TODO Auto-generated method stub
		return null;
	}
	   public String updatestudent(Student s,int sid);
	   public String deletestudent(int sid);
}
