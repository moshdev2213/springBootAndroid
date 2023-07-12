package com.example.springserver.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springserver.modal.Employee;
import com.example.springserver.repo.EmployeeRepo;

@Service
public class EmployeeDao {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee save(Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}
	public void delete(Employee employee) {
		employeeRepo.delete(employee);
	}
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeRepo.findAll();
	}
}
