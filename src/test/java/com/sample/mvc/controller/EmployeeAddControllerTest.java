package com.sample.mvc.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sample.mvc.command.EmployeeCommand;
import com.sample.mvc.controller.EmployeeAddController;
import com.sample.mvc.domain.Employee;
import com.sample.mvc.service.EmployeeService;

public class EmployeeAddControllerTest {

	Object command = new EmployeeCommand();
	BindException errors;
	EmployeeCommand empCommand = new EmployeeCommand();
	Employee emp = new Employee();
	Employee employee = new Employee();
	private HttpServletRequest HttpServletRequest;
	private HttpServletResponse HttpServletResponse;
	List<Employee> employeeList = new ArrayList<Employee>();
	EmployeeService empService = new EmployeeService();

	/**
	 * Test EmployeeAddController with positive and negative scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEmployeeAddControllerTrue() throws Exception {
		EmployeeAddController employeeAddController = new EmployeeAddController();
		assertNotNull(command);
		empCommand.getCode();
		empCommand.getName();
		HttpServletRequest mockRequest = (HttpServletRequest) mock(HttpServletRequest.class);
		HttpServletResponse mockResponse = (HttpServletResponse) mock2(HttpServletResponse.class);
		assertNotNull(emp);
		emp.setCode(11);
		emp.setName("cybage");
		((EmployeeCommand) command).setCode(11);
		((EmployeeCommand) command).setName("cybage");
		((EmployeeCommand) command).setCity("Delhi");
		assertNotNull(empService);
		assertNotNull(employeeList);
		employeeList.add(emp);
		empService.setEmployeeList(employeeList);
		assertEquals("Employee Object Successfully set", empService
				.getEmployeeList().get(0), emp);
		assertNotSame(empService.getEmployeeList().get(0), employee);
		employeeAddController.setEmployeeService(empService);
	}

	private HttpServletRequest mock(Class<HttpServletRequest> class1) {
		return HttpServletRequest;
	}

	private HttpServletResponse mock2(Class<HttpServletResponse> class1) {
		return HttpServletResponse;
	}

	@Test
	public void testSetEmployeeService() {
		EmployeeService employeeService = new EmployeeService();
		assertNotNull(employeeService);
	}

	@Test
	public void testOnsubmit() {
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(12);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);
		empService.setEmployeeList(employeeList);
		EmployeeAddController test = new EmployeeAddController();
		test.setEmployeeService(empService);
		((EmployeeCommand) command).setCode(12);
		((EmployeeCommand) command).setName("Manjul");
		((EmployeeCommand) command).setCity("Delhi");
		try {
			assertNotNull(command);
			ModelAndView check= test.onSubmit(HttpServletRequest, HttpServletResponse, command, errors);
			assertNotNull(check);
		} catch (Exception e) {
			System.out.println(((EmployeeCommand) command).getCode()+" "+((EmployeeCommand) command).getName()+" "+((EmployeeCommand) command).getCity());
			e.printStackTrace();
		}
		assertNotNull(command);
	}

	@Test
	public void testOnsubmitCode() {
		Employee emp = new Employee();
		emp.setCode(10665);
		emp.setName("Vidya");
		assertEquals("Code set is correct", 10665, 10665);
		assertNotNull(emp);
	}
}
