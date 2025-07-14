package com.dao;

import com.model.Employee;
import java.util.List;

public interface EmployeeDao {

	void insertEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);

}
