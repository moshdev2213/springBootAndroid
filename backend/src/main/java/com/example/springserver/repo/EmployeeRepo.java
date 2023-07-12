package com.example.springserver.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springserver.modal.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
