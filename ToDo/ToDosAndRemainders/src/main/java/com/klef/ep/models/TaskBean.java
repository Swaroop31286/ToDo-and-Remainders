package com.klef.ep.models;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;

import com.klef.ep.services.TaskService;

@ManagedBean(name = "taskBean",eager = true)
public class TaskBean {
	
	private String taskid;
	private String taskname;
	private String taskstatus;
	private String tasktarget;
	private int taskprogress;
	List<Task> tasklist;
	private String response;
	
	@EJB(lookup = "java:global/ToDosAndRemainders/TaskServiceImpl!com.klef.ep.services.TaskService")
	TaskService taskService;
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<Task> getTasklist() {
		return taskService.viewalltasks();
	}
	public void setTasklist(List<Task> tasklist) {
		this.tasklist = tasklist;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public String getTasktarget() {
		return tasktarget;
	}
	public void setTasktarget(String tasktarget) {
		this.tasktarget = tasktarget;
	}
	public int getTaskprogress() {
		return taskprogress;
	}
	public void setTaskprogress(int taskprogress) {
		this.taskprogress = taskprogress;
	}
	public void inserttask()
	{
		try
		{
			Task t = new Task();
			int randomNum = 10000 + (int)(Math.random() * 100000);
			String s= Integer.toString(randomNum);
			String taskid="TASK"+s;
			t.setTaskid(taskid);
			t.setTaskname(taskname);
			t.setTasktarget(tasktarget);
			t.setTaskprogress(taskprogress);
			if(taskprogress<100) 
			{
				taskstatus = "Inprogress";
			}
			else
			{
				taskstatus = "Complete";
			}
			t.setTaskstatus(taskstatus);
			response=taskService.inserttask(t);
		}
		catch(Exception e)
		{
			response=e.getMessage();
		}
	}
	public void viewalltask()
	{
		try
		{
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void updatetask()
	{
		try
		{
			Task task = new Task();
			task.setTaskid(taskid);
			task.setTaskprogress(taskprogress);
			if(taskprogress<100) 
			{
				taskstatus = "Inprogress";
			}
			else
			{
				taskstatus = "Complete";
			}
			task.setTaskstatus(taskstatus);
			response=taskService.updatetask(task, taskid);
		}
		catch(Exception e)
		{
			response=e.getMessage();
		}
	}
}
