package com.ndourcodeur.springemployeerestapi.service;

import com.ndourcodeur.springemployeerestapi.entity.*;
import com.ndourcodeur.springemployeerestapi.payload.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    public List<Employee> findAllEmployees();
    public Employee findEmployee(String employeeId);
    public Employee addEmployee(EmployeeRequest request);
    public Employee updateEmployee(String employeeId, EmployeeRequest request);
    public void deleteEmployee(String employeeId);
    public long employeeAccount();
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
