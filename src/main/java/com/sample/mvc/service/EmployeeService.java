package com.sample.mvc.service;

import java.util.Iterator;
import java.util.List;

import com.sample.mvc.domain.Employee;


public class EmployeeService {
	
	List<Employee> employeeList;

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public Employee findByEmployeeCode(int code){
		for (Employee e: employeeList){
			if (e.getCode() == code){
				return e;
			}
		}
		return null;
	}
	
	public void addEmployee(Employee e){
		System.out.println("code= "+e.getCode());
		System.out.println("name= "+e.getName());
		System.out.println("city= "+e.getCity());
		employeeList.add(e);
		System.out.println("count = "+employeeList.size());
	}
	
	public boolean deleteEmployee(int code)
	{
		boolean flag = false;
		Iterator<Employee> itr = employeeList.iterator();
		while(itr.hasNext())
		{
			Employee emp = itr.next();
			if(emp.getCode() == code)
			{
				itr.remove();
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean editEmployee(Employee e)
	{
		boolean flag = false;
		flag=deleteEmployee(e.getCode());
		if(flag){
		employeeList.add(e);
		}
		return flag;
	}
}
