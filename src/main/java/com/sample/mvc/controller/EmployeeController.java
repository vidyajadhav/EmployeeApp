package com.sample.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.sample.mvc.domain.Employee;
import com.sample.mvc.service.EmployeeService;


public class EmployeeController extends AbstractController {

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<Employee> employeeList = employeeService.getEmployeeList();
		System.out.println("count= " + employeeList.size());

		return new ModelAndView("home", "employees", employeeList);
	}

}
