package com.luv2code.spring.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.spring.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	/**
	 * Version 2: Using Jpa with JPSQL
	 */
	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {

		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> employeeList = theQuery.getResultList();
		
		return employeeList;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Employee newEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(newEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
	}

}
