package com.klef.ep.services;

import javax.ejb.Remote;
import java.util.List;

import com.klef.ep.models.Employee;

@Remote
public interface EmployeeService 
{
   public String insertemployee(Employee emp);
   public String updateemployee(Employee emp,int eid);
   public String deleteemployee(int eid);
   public List<Employee> viewallemployees();
public String employeelogin(Employee e, int eid, String epwd);
public Employee viewemployee(int eid);
}
