package com.ndourcodeur.springemployeerestapi.service;

import com.ndourcodeur.springemployeerestapi.entity.Employee;
import com.ndourcodeur.springemployeerestapi.exception.ResourceNotFoundException;
import com.ndourcodeur.springemployeerestapi.payload.request.EmployeeRequest;
import com.ndourcodeur.springemployeerestapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee findEmployee(String idEmployee) {
        return employeeRepository.findById(idEmployee)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+idEmployee+" is not found"));
    }

    @Transactional
    @Override
    public Employee addEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setId(request.getId());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setImageUrl(request.getImageUrl());
        employee.setSalary(request.getSalary());
        employee.setDob(new Date());
        employee.setGender(request.getGender());
        employee.setDepartment(request.getDepartment());
        employee.setStatus(request.getStatus());
        employee.setAddress(request.getAddress());
        employee.setCreatedAt(request.getCreatedAt());
        employee.setUpdatedAt(request.getUpdatedAt());
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(String idEmployee, EmployeeRequest request) {
        Employee existingEmployee = employeeRepository.findById(idEmployee)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+idEmployee+" is not found"));
        existingEmployee.setId(request.getId());
        existingEmployee.setFirstName(request.getFirstName());
        existingEmployee.setLastName(request.getLastName());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setPhone(request.getPhone());
        existingEmployee.setEmployeeCode(UUID.randomUUID().toString());
        existingEmployee.setImageUrl(request.getImageUrl());
        existingEmployee.setSalary(request.getSalary());
        existingEmployee.setDob(new Date());
        existingEmployee.setGender(request.getGender());
        existingEmployee.setDepartment(request.getDepartment());
        existingEmployee.setStatus(request.getStatus());
        existingEmployee.setAddress(request.getAddress());
        existingEmployee.setCreatedAt(request.getCreatedAt());
        existingEmployee.setUpdatedAt(request.getUpdatedAt());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(String idEmployee) {
        Employee employee = employeeRepository.findById(idEmployee)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+idEmployee+" is not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmailContaining(email);
    }

    @Override
    public Optional<Employee> findByPhone(String phone) {
        return employeeRepository.findByPhoneContaining(phone);
    }

    @Override
    public boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return employeeRepository.existsByPhone(phone);
    }
}
