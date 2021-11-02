package com.luv2code.spring.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.spring.cruddemo.entity.Employee;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
