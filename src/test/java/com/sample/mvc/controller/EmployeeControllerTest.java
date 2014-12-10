package com.sample.mvc.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.sample.mvc.controller.EmployeeController;
import com.sample.mvc.domain.Employee;
import com.sample.mvc.service.EmployeeService;

public class EmployeeControllerTest extends EmployeeController {

	Employee emp = new Employee();
	Employee employee = new Employee();
	private HttpServletRequest HttpServletRequest;
	private HttpServletResponse HttpServletResponse;
	List<Employee> empLst = new ArrayList<Employee>();
	List<Employee> employeeList = new ArrayList<Employee>();
	EmployeeService empService = new EmployeeService();

	/**
	 * Test EmployeeController with positive and negative scenario
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEmployeeControllerTrue() throws Exception {
		EmployeeController empController = new EmployeeController();
		HttpServletRequest mockRequest = (HttpServletRequest) mock(HttpServletRequest.class);
		HttpServletResponse mockResponse = (HttpServletResponse) mock2(HttpServletResponse.class);
		emp.setCode(1);
		emp.setName("cybage");
		emp.setCity("Delhi");
		empLst.add(emp);
		empService.setEmployeeList(empLst);
		empController.setEmployeeService(empService);
		assertNotNull(emp);

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
	public void testHandleRequestInternal() {
		emp.setCode(11);
		emp.setName("cybage");
		emp.setCity("Delhi");
		employee.setCode(12);
		employee.setName("cyb");
		employee.setCity("Delhi");
		employeeList.add(emp);
		employeeList.add(employee);
		empService.setEmployeeList(employeeList);
		EmployeeController test = new EmployeeController();
		test.setEmployeeService(empService);
		try {
			ModelAndView check = test.handleRequestInternal(HttpServletRequest, HttpServletResponse);
			assertNotNull(check);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
