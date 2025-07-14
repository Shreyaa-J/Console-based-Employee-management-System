package com.main;

import com.model.Employee;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;

import java.sql.Date;
import java.util.Scanner;
import java.util.List;

public class Main {
	 public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	        EmployeeDao dao = new EmployeeDaoImpl();

	        while (true) {
	            System.out.println("\n--------------- Employee Management System ---------------------");
	            System.out.println("1. Add Employee");
	            System.out.println("2. View All Employees");
	            System.out.println("3. View Employee by ID");
	            System.out.println("4. Update Employee");
	            System.out.println("5. Delete Employee");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1 -> {
	                    System.out.print("Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Email: ");
	                    String email = sc.nextLine();
	                    System.out.print("Phone: ");
	                    String phone = sc.nextLine();
	                    System.out.print("Department: ");
	                    String department = sc.nextLine();
	                    System.out.print("Designation: ");
	                    String designation = sc.nextLine();
	                    System.out.print("Salary: ");
	                    double salary = sc.nextDouble();
	                    sc.nextLine();
	                    System.out.print("Joining Date (yyyy-mm-dd): ");
	                    String date = sc.nextLine();

	                    Employee employee = new Employee(name, email, phone, department, designation, salary, Date.valueOf(date));
	                    dao.insertEmployee(employee);
	                }

	                case 2 -> {
	                    List<Employee> list = dao.getAllEmployees();
	                    for (Employee employee : list) {
	                        System.out.println(employee.getEmpid() + " | " + employee.getName() + " | " + employee.getEmail());
	                    }
	                }

	                case 3 -> {
	                    System.out.print("Enter Employee ID to search: ");
	                    int empid = sc.nextInt();
	                    Employee employee = dao.getEmployeeById(empid);
	                    if (employee != null)
	                        System.out.println(employee.getEmpid() + " | " + employee.getName() + " | " + employee.getEmail());
	                    else
	                        System.out.println("Employee not found.");
	                }

	                case 4 -> {
	                    System.out.print("Enter Employee ID to update: ");
	                    int empid = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Email: ");
	                    String email = sc.nextLine();
	                    System.out.print("Phone: ");
	                    String phone = sc.nextLine();
	                    System.out.print("Department: ");
	                    String department = sc.nextLine();
	                    System.out.print("Designation: ");
	                    String designation = sc.nextLine();
	                    System.out.print("Salary: ");
	                    double salary = sc.nextDouble();
	                    sc.nextLine();
	                    System.out.print("Joining Date (yyyy-mm-dd): ");
	                    String date = sc.nextLine();

	                    Employee employee = new Employee(empid, name, email, phone, department, designation, salary, Date.valueOf(date));
	                    dao.updateEmployee(employee);
	                }

	                case 5 -> {
	                    System.out.print("Enter Employee ID to delete: ");
	                    int empid = sc.nextInt();
	                    dao.deleteEmployee(empid);
	                }

	                case 6 -> {
	                    System.out.println("Exiting...");
	                    return;
	                }

	                default -> System.out.println("Invalid choice.");
	            }
	        }
	    }
}


