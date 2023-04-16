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

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeServiceImpl implements EmployeeService
{

	@Override
	public String insertemployee(Employee emp) 
	{
		
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpb");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    entityManager.persist(emp);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object Inserted Successfully";
	}

	@Override
	public String updateemployee(Employee emp, int eid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Employee e=entityManager.find(Employee.class,eid);
	    e.setEmpid(emp.getEmpid());
	    e.setEmpname(emp.getEmpname());
	    e.setEmppwd(emp.getEmppwd());
	    
	    
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object Updated Successfully";
		
	}

	@Override
	public String deleteemployee(int eid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Employee e=entityManager.find(Employee.class,eid);
	    entityManager.remove(e);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object deleted Successfully";
		
	}

	@Override
	public List<Employee> viewallemployees() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Query qry=entityManager.createQuery("select emp from Employee emp");
	    List<Employee> emplist=qry.getResultList();
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return emplist;
		
	}
	@Override
	  public String employeelogin(Employee e,int eid, String epwd) 
	  {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	      EntityManager entityManager = entityManagerFactory.createEntityManager();
	      
	      entityManager.getTransaction().begin();
	      Employee emp=entityManager.find(Employee.class,eid);
	      entityManager.getTransaction().commit();
	      
	      entityManager.close();
	      entityManagerFactory.close();
	      
	      return "Admin Logged In Successfully";
	  }

	@Override
	public Employee viewemployee(int eid) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Query qry=entityManager.createQuery("select emp from Employee emp where employeeid=?");
	    qry.setParameter(1, eid);
	   Employee emp=(Employee)qry.getSingleResult();
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return emp;
	}
   
}
