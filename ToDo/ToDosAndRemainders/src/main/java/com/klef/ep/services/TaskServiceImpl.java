package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Employee;
import com.klef.ep.models.Task;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TaskServiceImpl implements TaskService
{

	public String inserttask(Task t) 
	{
		
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpb");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    entityManager.persist(t);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object Inserted Successfully";
	}

	@Override
	public List<Task> viewalltasks() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpb");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Query qry=entityManager.createQuery("select tsk from Task tsk");
	    List<Task> tasklist=qry.getResultList();
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return tasklist;
	}

	@Override
	public String updatetask(Task task, String taskid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Task t=entityManager.find(Task.class,taskid);
	    t.setTaskid(task.getTaskid());
	    t.setTaskprogress(task.getTaskprogress());
	    t.setTaskstatus(task.getTaskstatus());
	    
	    
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object Updated Successfully";
	}
}
