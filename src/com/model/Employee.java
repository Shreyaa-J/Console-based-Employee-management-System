package com.model;

import java.sql.Date;

public class Employee {

    private int empid;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private double salary;
    private Date joiningDate;

    public Employee() {
    }


    public Employee(int empid, String name, String email, String phone, String department,
                    String designation, double salary, Date joiningDate) {
        this.empid = empid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

   
    public Employee(String name, String email, String phone, String department,
                    String designation, double salary, Date joiningDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

}
