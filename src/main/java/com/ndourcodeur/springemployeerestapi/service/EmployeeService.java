package com.ndourcodeur.springemployeerestapi.service;

import com.ndourcodeur.springemployeerestapi.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    public List<Employee> findAllEmployees();
    public Employee findEmployee(String employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(String employeeId, Employee employee);
    public Employee updateEmployeeById(String employeeId, Employee employee);
    public void deleteEmployee(String employeeId);
    public Optional<Employee> findByEmail(String email);
    public Optional<Employee> findByPhone(String phone);
    public boolean existsByEmail(String email);
    public boolean existsByPhone(String phone);
    //
    public List<Employee> fetchEmployeesByDepartment(Department department);
    public List<Employee> fetchEmployeesByGender(Gender gender);
    public List<Employee> fetchEmployeesByStatus(EmployeeStatus status);
    public List<Employee> fetchEmployeesByAddress(Address address);
}
