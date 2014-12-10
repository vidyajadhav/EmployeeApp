package com.sample.mvc.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;



import org.junit.Test;

import com.sample.mvc.domain.Employee;
import com.sample.mvc.service.EmployeeService;

public class EmployeeServiceTest {
	List<Employee> employeeList = new ArrayList<Employee>();
	List<Employee> empList = new ArrayList<Employee>();
	EmployeeService empService = new EmployeeService();
	Employee emp = new Employee();
	Employee employee = new Employee();

	/**
	 * Check weather employeelist return from empservice and actual employee
	 * list are same
	 */
	@Test
	public void testAddTrue() {
		System.out.println(":::::");
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		System.out.println("Set City :::::" + emp.getCity());
		employeeList.add(emp);
		empService.setEmployeeList(employeeList);
		empList.add(emp);
		empService.addEmployee(emp);
		assertNotNull(emp);
	}

	/**
	 * Pass emplist as Null and check weather employee list return from
	 * empservice and actual emplist are not same
	 */
	@Test
	public void testAddFalse() {
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		empService.setEmployeeList(employeeList);
		empList.add(null);
		empService.addEmployee(emp);
		assertNotSame(empList, empService.getEmployeeList());
	}

	/**
	 * Positive scenario test for findEmployeeCode method
	 */
	@Test
	public void findByEmployeeCodeTrue() {

		emp.setCode(1);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(2);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);

		empService.setEmployeeList(employeeList);
		assertEquals("Find Employee Successfully done", 1, empService
				.findByEmployeeCode(1).getCode());
	}

	/**
	 * Negative scenario test for findEmployeeCode method
	 */
	@Test
	public void findByEmployeeCodeFalse() {

		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(12);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);

		empService.setEmployeeList(employeeList);
		assertNotSame(12, empService.findByEmployeeCode(11).getCode());
		assertNull(empService.findByEmployeeCode(13));
	}
	
	@Test
	public void deleteEmployeeTrue() {
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(12);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);
		empService.setEmployeeList(employeeList);
		boolean actual = empService.deleteEmployee(12);
		boolean expected = true;
		empList.add(emp);
		assertSame(expected, actual);
	}
	
	@Test
	public void deleteEmployeeFalse() {
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(12);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);
		empService.setEmployeeList(employeeList);
		boolean actual = empService.deleteEmployee(13);
		boolean expected = false;
		empList.add(emp);
		assertSame(expected, actual);	
	}
	
	@Test
	public void editEmployeeTrue() {
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(12);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);
		empService.setEmployeeList(employeeList);
		
		Employee editEmp = new Employee();
		editEmp.setCode(12);
		editEmp.setName("Manjul");
		editEmp.setCity("Kanpur");
		boolean actual=empService.editEmployee(editEmp);
		boolean expected = true;
		assertSame(expected, actual);
	}
	
	@Test
	public void editEmployeeFalse() {
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(12);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);
		empService.setEmployeeList(employeeList);
		
		Employee editEmp = new Employee();
		editEmp.setCode(13);
		editEmp.setName("Manjul");
		editEmp.setCity("Kanpur");
		boolean actual=empService.editEmployee(editEmp);
		boolean expected = true;
		assertNotSame(expected, actual);
	}
}
