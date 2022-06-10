package com.ndourcodeur.springemployeerestapi.web;

import com.ndourcodeur.springemployeerestapi.entity.*;
import com.ndourcodeur.springemployeerestapi.payload.request.EmployeeRequest;
import com.ndourcodeur.springemployeerestapi.payload.response.MessageResponse;
import com.ndourcodeur.springemployeerestapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/employees")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {
    
    private final EmployeeService employeeService;

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/findAll
     * Method to fetch all employees from db.
     * @return
     */
    @GetMapping(path = "/findAll")
    public ResponseEntity<List<Employee>> findAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        if (employees.isEmpty())
            return new ResponseEntity(new MessageResponse("No Content."), HttpStatus.BAD_REQUEST);
        log.info("Getting all employees.");
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/detail/{id}
     * Method to fetch employee by id.
     * @param _id
     * @return
     */
    @GetMapping(path = "/detail/{_id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable String _id){
        Employee employee = employeeService.findEmployee(_id);
        log.info("Getting Employee with ID : {}.", _id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/addEmployee
     * Method to save new employee.
     * @param request
     * @return
     */
    @PostMapping(path = "/addEmployee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest request){
        if (employeeService.existsByEmail(request.getEmail()))
            return new ResponseEntity(new MessageResponse("Error: Email Address already exist."), HttpStatus.BAD_REQUEST);
        if (employeeService.existsByPhone(request.getPhone()))
            return new ResponseEntity(new MessageResponse("Error: Phone Number already exist."), HttpStatus.BAD_REQUEST);
        log.info("Saving Employee : {}.", request);
        return new ResponseEntity<>(employeeService.addEmployee(request), HttpStatus.CREATED);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/update/{id}
     * Method to update employee by id.
     * @param request
     * @param _id
     * @return
     */
    @PutMapping(path = "/update/{_id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "_id") String _id, @Valid @RequestBody EmployeeRequest request){
        if (employeeService.existsByEmail(request.getEmail()) && employeeService.findByEmail(request.getEmail()).get().get_id() != _id)
            return new ResponseEntity(new MessageResponse("Error: Email address already exist."), HttpStatus.BAD_REQUEST);
        /*if (employeeService.existsByPhone(request.getPhone()) && employeeService.findByPhone(request.getPhone()).get().getId() != idEmployee)
            return new ResponseEntity(new MessageResponse("Error: Phone number already exist."), HttpStatus.BAD_REQUEST);*/
        Employee employee = employeeService.updateEmployee(_id, request);
        log.info("Updating Employee with ID : {}", _id);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/delete/{id}
     * Method to delete employee by id.
     * @param _id
     * @return
     */
    @DeleteMapping(path = "/delete/{_id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable(value = "_id") String _id){
        employeeService.deleteEmployee(_id);
        log.info("Deleting Employee with ID : {}.", _id);
        return new ResponseEntity<>(new MessageResponse("Employee with ID:"+_id+" is deleted successfully."), HttpStatus.OK);
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
