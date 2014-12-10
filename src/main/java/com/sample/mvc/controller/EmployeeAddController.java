package com.sample.mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;


import com.sample.mvc.command.EmployeeCommand;
import com.sample.mvc.domain.Employee;
import com.sample.mvc.service.EmployeeService;

public class EmployeeAddController extends SimpleFormController{
	
	private EmployeeService employeeService;
	static Logger logger = Logger.getLogger(EmployeeAddController.class.getName());

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/* 
	 * submit employee data
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		

		Properties props= new Properties();
		FileInputStream  fin=new FileInputStream("D:/workspace/Logging/WebContent/WEB-INF/mylogging.properties");
		try {
			props.load(fin);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try{
			Handler fileHandler = new FileHandler("D:/tmp/logger.log", 2000, 5);
			fileHandler.setFormatter(new MyFormatter());
			
			logger.addHandler(fileHandler);
			for(int i=0; i<1000; i++){
                //logging messages
                logger.log(Level.WARNING, "Msg"+i +"ready to be fed to New Relic");
                logger.log(Level.SEVERE, "Msg"+i +"ready to be fed to New Relic");
                logger.log(Level.INFO, "Msg"+i +"ready to be fed to New Relic");
                logger.info("In Employee Add Controller");
            }
            logger.log(Level.CONFIG, "Config data");
        } catch (IOException e) {
            e.printStackTrace();
		}
		
		EmployeeCommand empCommand = (EmployeeCommand) command;
			Employee e = new Employee();
			e.setCode(empCommand.getCode());
			e.setName(empCommand.getName());
			e.setCity(empCommand.getCity());
			employeeService.addEmployee(e);
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
}
