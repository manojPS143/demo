package com.example.employeeapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposatory extends JpaRepository<Employee,Integer>{

}
