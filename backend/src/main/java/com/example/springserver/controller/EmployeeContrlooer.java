package com.example.springserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springserver.Dao.EmployeeDao;
import com.example.springserver.modal.Employee;

@RestController
@CrossOrigin("*")
public class EmployeeContrlooer {

	@Autowired 
	private EmployeeDao employeeDao;
	
	@GetMapping("/employee/getAll")
	public List<Employee> getAllEmployee(){
		return employeeDao.getAllEmployee();
	}
	
	@PostMapping("/employee/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeDao.save(employee);
	}
}
