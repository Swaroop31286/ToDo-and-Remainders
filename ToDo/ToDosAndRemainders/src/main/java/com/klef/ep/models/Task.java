package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="task_table")
public class Task implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="taskid")
	private String taskid;
    @Column(name="taskname")
	private String taskname;
    @Column(name="taskstatus")
	private String taskstatus;
    @Column(name="tasktarget")
   	private String tasktarget;
    @Column(name="taskprogress")
   	private int taskprogress;
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid2) {
		this.taskid = taskid2;
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
    
   

}
