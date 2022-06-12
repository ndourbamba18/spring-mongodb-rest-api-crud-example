package com.ndourcodeur.springemployeerestapi.web;

import com.ndourcodeur.springemployeerestapi.entity.*;
import com.ndourcodeur.springemployeerestapi.message.MessageResponse;
import com.ndourcodeur.springemployeerestapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/employees")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    @Resource
    private final EmployeeService employeeService;

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/findAll
     * Method to fetch all employees from db.
     * @return
     */
    @GetMapping(path = "/findAll")
    public ResponseEntity<List<Employee>> findAllEmployees(){
        List<Employee> employees = this.employeeService.findAllEmployees();
        if (employees.isEmpty())
            return new ResponseEntity(new MessageResponse("No Content."), HttpStatus.BAD_REQUEST);
        log.info("Getting all employees.");
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/detail/{id}
     * Method to fetch employee by id.
     * @param employeeId
     * @return
     */
    @GetMapping(path = "/detail/{employeeId}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable(value = "employeeId") String employeeId){
        Employee employee = employeeService.findEmployee(employeeId);
        log.info("Getting Employee with ID : {}.", employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/addEmployee
     * Method to save new employee.
     * @param employee
     * @return
     */
    @PostMapping(path = "/addEmployee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        if (employeeService.existsByEmail(employee.getEmail()))
            return new ResponseEntity(new MessageResponse("Error: Email Address already exist."), HttpStatus.BAD_REQUEST);
        if (employeeService.existsByPhone(employee.getPhone()))
            return new ResponseEntity(new MessageResponse("Error: Phone Number already exist."), HttpStatus.BAD_REQUEST);
        Employee addEmployee = employeeService.addEmployee(employee);
        log.info("Saving Employee : {}.", employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/update/{id}
     * Method to update employee by id.
     * @param employee
     * @param employeeId
     * @return
     */
    @PatchMapping(path = "/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "employeeId") String employeeId, @Valid @RequestBody Employee employee){
        if (this.employeeService.existsByEmail(employee.getEmail()) && this.employeeService.findByEmail(employee.getEmail()).get().get_id() != employeeId)
            return new ResponseEntity(new MessageResponse("Error: Email address already exist."), HttpStatus.BAD_REQUEST);
        if (this.employeeService.existsByPhone(employee.getPhone()) && this.employeeService.findByPhone(employee.getPhone()).get().get_id() != employeeId)
            return new ResponseEntity(new MessageResponse("Error: Phone number already exist."), HttpStatus.BAD_REQUEST);
        log.info("Updating Employee with ID : {}.", employeeId);
        Employee updateEmployee = this.employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/update/{id}
     * Method to update employee by id.
     * @param employee
     * @param employeeId
     * @return
     */
    @PutMapping(path = "/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "employeeId") String employeeId, @Valid @RequestBody Employee employee){
        log.info("Updating Employee with ID : {}.", employeeId);
        Employee updateEmployee = this.employeeService.updateEmployeeById(employeeId, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/delete/{id}
     * Method to delete employee by id.
     * @param employeeId
     * @return
     */
    @DeleteMapping(path = "/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable(value = "employeeId") String employeeId){
        employeeService.deleteEmployee(employeeId);
        log.info("Deleting Employee with ID : {}.", employeeId);
        return new ResponseEntity<>(new MessageResponse("Employee with ID:"+employeeId+" is deleted successfully."), HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/employee-account
     * Method to count the number of employees that exist in the database.
     * @return
     */
    @GetMapping(path = "/employee-account")
    public ResponseEntity<?> getNumberOfEmployees(){
        long totalEmployees = this.employeeService.employeeAccount();
        return new ResponseEntity<>(totalEmployees, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/by-department/{department}
     * Method to fetch all employees by department.
     * @param department
     * @return
     */
    @GetMapping(path = "/by-department/{department}")
    public ResponseEntity<List<Employee>> fetchAllEmployeesByDepartment(@PathVariable Department department){
        List<Employee> employees = employeeService.fetchEmployeesByDepartment(department);
        if (employees.isEmpty())
            return new ResponseEntity(new MessageResponse("No Content."), HttpStatus.BAD_REQUEST);
        log.info("Getting all employees by department {}.", department);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/by-gender/{gender}
     * Method to fetch all employees by gender.
     * @param gender
     * @return
     */
    @GetMapping(path = "/by-gender/{gender}")
    public ResponseEntity<List<Employee>> fetchAllEmployeesByGender(@PathVariable Gender gender){
        List<Employee> employees = employeeService.fetchEmployeesByGender(gender);
        if (employees.isEmpty())
            return new ResponseEntity(new MessageResponse("No Content."), HttpStatus.BAD_REQUEST);
        log.info("Getting all employees by department {}.", gender);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/by-gender/{status}
     * Method to fetch all employees by status.
     * @param status
     * @return
     */
    @GetMapping(path = "/by-status/{status}")
    public ResponseEntity<List<Employee>> fetchAllEmployeesByStatus(@PathVariable EmployeeStatus status){
        List<Employee> employees = employeeService.fetchEmployeesByStatus(status);
        if (employees.isEmpty())
            return new ResponseEntity(new MessageResponse("No Content."), HttpStatus.BAD_REQUEST);
        log.info("Getting all employees by department {}.", status);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/by-address/{address}
     * Method to fetch all employees by address.
     * @param address
     * @return
     */
    @GetMapping(path = "/by-address/{address}")
    public ResponseEntity<List<Employee>> fetchAllEmployeesByAddress(@PathVariable Address address){
        List<Employee> employees = employeeService.fetchEmployeesByAddress(address);
        if (employees.isEmpty())
            return new ResponseEntity(new MessageResponse("No Content."), HttpStatus.BAD_REQUEST);
        log.info("Getting all employees by department {}.", address);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
