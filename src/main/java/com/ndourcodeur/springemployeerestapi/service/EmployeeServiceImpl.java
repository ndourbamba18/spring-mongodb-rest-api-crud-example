package com.ndourcodeur.springemployeerestapi.service;

import com.ndourcodeur.springemployeerestapi.entity.*;
import com.ndourcodeur.springemployeerestapi.exception.ResourceNotFoundException;
import com.ndourcodeur.springemployeerestapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> list = this.employeeRepository.findAll();
        list = list.stream().sorted(Comparator.comparing(Employee::get_id).reversed())
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public Employee findEmployee(String employeeId) {
        Employee existingEmployee = this.employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+employeeId+" is not found"));
        log.info("Find employee inside EmployeeService.");
        return existingEmployee;
    }

    @Transactional
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        log.info("Add new employee inside EmployeeService.");
        return this.employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(String employeeId, Employee employee) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        if (!optionalEmployee.isPresent()) {
             throw new ResourceNotFoundException("Employee not found with ID : " + employeeId);
        }
        Employee updateEmployee = optionalEmployee.get();
        log.info("Update employee by id inside EmployeeService.");
        return employeeRepository.save(updateEmployee);
    }

    @Override
    public Long employeeAccount() {
        return this.employeeRepository.count();
    }

    @Transactional
    @Override
    public Employee updateEmployeeById(String employeeId, Employee employee) {
        Employee existingEmployee = this.employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+employeeId+" is not found"));
        log.info("Update employee by id inside EmployeeService.");
        return this.employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(String employeeId) {
        Employee employee = this.employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee with ID:"+employeeId+" is not found"));
        log.info("Delete employee by id inside EmployeeService.");
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        log.info("Find email of employee inside EmployeeService.");
        return this.employeeRepository.findByEmailContaining(email);
    }

    @Override
    public Optional<Employee> findByPhone(String phone) {
        log.info("Find phone number of employee inside EmployeeService.");
        return this.employeeRepository.findByPhoneContaining(phone);
    }

    @Override
    public boolean existsByEmail(String email) {
        log.info("Check existing email of employee inside EmployeeService.");
        return this.employeeRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        log.info("Check existing phone number of employee inside EmployeeService.");
        return this.employeeRepository.existsByPhone(phone);
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
