package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.klef.ep.models.Student;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class StudentServiceImpl implements StudentService
{

	public String insertstudent(Student s) 
	{
		
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpb");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    entityManager.persist(s);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object Inserted Successfully";
	}

	@Override
	public String updatestudent(Student s, int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletestudent(int sid) {
		// TODO Auto-generated method stub
		return null;
	}
}
