package com.ndourcodeur.springemployeerestapi.service;

import com.ndourcodeur.springemployeerestapi.entity.Employee;
import com.ndourcodeur.springemployeerestapi.payload.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    public List<Employee> findAllEmployees();
    public Employee findEmployee(String idEmployee);
    public Employee addEmployee(EmployeeRequest request);
    public Employee updateEmployee(String idEmployee, EmployeeRequest request);
    public void deleteEmployee(String idEmployee);
    public Optional<Employee> findByEmail(String email);
    public Optional<Employee> findByPhone(String phone);
    public boolean existsByEmail(String email);
    public boolean existsByPhone(String phone);
}
