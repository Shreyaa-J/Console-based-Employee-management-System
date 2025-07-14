package com.dao;

import com.model.Employee;
import com.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
	
	 private Connection connection;

	    public EmployeeDaoImpl() {
	        connection = DBConnection.getConnection();
	    }

	    @Override
	    public void insertEmployee(Employee employee) {
	        String sql = "INSERT INTO employee (name, email, phone, department, designation, salary, joining_date) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, employee.getName());
	            preparedStatement.setString(2, employee.getEmail());
	            preparedStatement.setString(3, employee.getPhone());
	            preparedStatement.setString(4, employee.getDepartment());
	            preparedStatement.setString(5, employee.getDesignation());
	            preparedStatement.setDouble(6, employee.getSalary());
	            preparedStatement.setDate(7, employee.getJoiningDate());
	            preparedStatement.executeUpdate();
	            System.out.println("Employee inserted successfully.");
	        } catch (SQLException e) {
	            System.out.println("Error inserting employee: " + e.getMessage());
	        }
	    }

	    @Override
	    public List<Employee> getAllEmployees() {
	        List<Employee> list = new ArrayList<>();
	        String sql = "SELECT * FROM employee";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                Employee employee = new Employee(
	                        resultSet.getInt("empid"),
	                        resultSet.getString("name"),
	                        resultSet.getString("email"),
	                        resultSet.getString("phone"),
	                        resultSet.getString("department"),
	                        resultSet.getString("designation"),
	                        resultSet.getDouble("salary"),
	                        resultSet.getDate("joining_date")
	                );
	                list.add(employee);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error fetching employees: " + e.getMessage());
	        }
	        return list;
	    }

	    @Override
	    public Employee getEmployeeById(int empid) {
	        String sql = "SELECT * FROM employee WHERE empid = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, empid);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                return new Employee(
	                        resultSet.getInt("empid"),
	                        resultSet.getString("name"),
	                        resultSet.getString("email"),
	                        resultSet.getString("phone"),
	                        resultSet.getString("department"),
	                        resultSet.getString("designation"),
	                        resultSet.getDouble("salary"),
	                        resultSet.getDate("joining_date")
	                );
	            }
	        } catch (SQLException e) {
	            System.out.println("Error finding employee: " + e.getMessage());
	        }
	        return null;
	    }

	    @Override
	    public void updateEmployee(Employee employee) {
	        String sql = "UPDATE employee SET name=?, email=?, phone=?, department=?, designation=?, salary=?, joining_date=? " +
	                     "WHERE empid=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, employee.getName());
	            preparedStatement.setString(2, employee.getEmail());
	            preparedStatement.setString(3, employee.getPhone());
	            preparedStatement.setString(4, employee.getDepartment());
	            preparedStatement.setString(5, employee.getDesignation());
	            preparedStatement.setDouble(6, employee.getSalary());
	            preparedStatement.setDate(7, employee.getJoiningDate());
	            preparedStatement.setInt(8, employee.getEmpid());
	            int rows = preparedStatement.executeUpdate();
	            if (rows > 0)
	                System.out.println("Employee updated successfully.");
	            else
	                System.out.println("Employee not found.");
	        } catch (SQLException e) {
	            System.out.println("Error updating employee: " + e.getMessage());
	        }
	    }

	    @Override
	    public void deleteEmployee(int empid) {
	        String sql = "DELETE FROM employee WHERE empid=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, empid);
	            int rows = preparedStatement.executeUpdate();
	            if (rows > 0)
	                System.out.println("Employee deleted successfully.");
	            else
	                System.out.println("Employee not found.");
	        } catch (SQLException e) {
	            System.out.println("Error deleting employee: " + e.getMessage());
	        }
	    }

	
		
}


