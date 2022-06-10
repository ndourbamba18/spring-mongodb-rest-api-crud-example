package com.ndourcodeur.springemployeerestapi.service;

import com.ndourcodeur.springemployeerestapi.entity.*;
import com.ndourcodeur.springemployeerestapi.exception.ResourceNotFoundException;
import com.ndourcodeur.springemployeerestapi.payload.request.EmployeeRequest;
import com.ndourcodeur.springemployeerestapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        log.info("Find all employees inside EmployeeService.");
        return employees;
    }

    @Override
    public Employee findEmployee(String _id) {
        Employee existingEmployee = employeeRepository.findById(_id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+_id+" is not found"));
        log.info("Find employee inside EmployeeService.");
        return existingEmployee;
    }

    @Transactional
    @Override
    public Employee addEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.set_id(request.get_id());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setJobTitle(request.getJobTitle());
        employee.setImageUrl(request.getImageUrl());
        employee.setSalary(request.getSalary());
        employee.setDob(new Date());
        employee.setGender(request.getGender());
        employee.setDepartment(request.getDepartment());
        employee.setStatus(request.getStatus());
        employee.setAddress(request.getAddress());
        employee.setCreatedAt(request.getCreatedAt());
        employee.setUpdatedAt(request.getUpdatedAt());
        log.info("Add new employee inside EmployeeService.");
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(String _id, EmployeeRequest request) {
        Employee existingEmployee = employeeRepository.findById(_id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+_id+" is not found"));
        existingEmployee.set_id(request.get_id());
        existingEmployee.setFirstName(request.getFirstName());
        existingEmployee.setLastName(request.getLastName());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setPhone(request.getPhone());
        existingEmployee.setEmployeeCode(UUID.randomUUID().toString());
        existingEmployee.setJobTitle(request.getJobTitle());
        existingEmployee.setImageUrl(request.getImageUrl());
        existingEmployee.setSalary(request.getSalary());
        existingEmployee.setDob(new Date());
        existingEmployee.setGender(request.getGender());
        existingEmployee.setDepartment(request.getDepartment());
        existingEmployee.setStatus(request.getStatus());
        existingEmployee.setAddress(request.getAddress());
        existingEmployee.setCreatedAt(request.getCreatedAt());
        existingEmployee.setUpdatedAt(request.getUpdatedAt());
        log.info("Update employee by id inside EmployeeService.");
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(String _id) {
        Employee employee = employeeRepository.findById(_id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+_id+" is not found"));
        log.info("Delete employee by id inside EmployeeService.");
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        log.info("Find email of employee inside EmployeeService.");
        return employeeRepository.findByEmailContaining(email);
    }

    @Override
    public Optional<Employee> findByPhone(String phone) {
        log.info("Find phone number of employee inside EmployeeService.");
        return employeeRepository.findByPhoneContaining(phone);
    }

    @Override
    public boolean existsByEmail(String email) {
        log.info("Check existing email of employee inside EmployeeService.");
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        log.info("Check existing phone number of employee inside EmployeeService.");
        return employeeRepository.existsByPhone(phone);
    }

    @Override
    public List<Employee> fetchEmployeesByDepartment(Department department) {
        log.info("fetchEmployeesByDepartment Inside EmployeeService.");
        List<Employee> employees = employeeRepository.findByDepartment(department);
        return employees;
    }

    @Override
    public List<Employee> fetchEmployeesByGender(Gender gender) {
        log.info("fetchEmployeesByGender Inside EmployeeService.");
        List<Employee> employees = employeeRepository.findByGender(gender);
        return employees;
    }

    @Override
    public List<Employee> fetchEmployeesByStatus(EmployeeStatus status) {
        log.info("fetchEmployeesByEmployeeStatus Inside EmployeeService.");
        List<Employee> employees = employeeRepository.findByStatus(status);
        return employees;
    }

    @Override
    public List<Employee> fetchEmployeesByAddress(Address address) {
        log.info("fetchEmployeesByAddress Inside EmployeeService.");
        List<Employee> employees = employeeRepository.findByAddress(address);
        return employees;
    }
}
