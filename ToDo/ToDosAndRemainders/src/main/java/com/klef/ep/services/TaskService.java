package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Employee;
import com.klef.ep.models.Task;

@Remote
public interface TaskService 
{
	public String inserttask(Task t);
	public List<Task> viewalltasks();
	public String updatetask(Task task,String taskid);
}
