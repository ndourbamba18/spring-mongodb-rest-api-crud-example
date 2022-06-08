package com.ndourcodeur.springemployeerestapi.web;

import com.ndourcodeur.springemployeerestapi.entity.Employee;
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
     */
    @GetMapping(path = "/detail/{idEmployee}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable String idEmployee){
        Employee employee = employeeService.findEmployee(idEmployee);
        log.info("Getting Employee with ID : {}", idEmployee+".");
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/addEmployee
     */
    @PostMapping(path = "/addEmployee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest request){
        if (employeeService.existsByEmail(request.getEmail()))
            return new ResponseEntity(new MessageResponse("Error: Email Address already exist."), HttpStatus.BAD_REQUEST);
        if (employeeService.existsByPhone(request.getPhone()))
            return new ResponseEntity(new MessageResponse("Error: Phone Number already exist."), HttpStatus.BAD_REQUEST);
        log.info("Saving Employee : {}", request);
        return new ResponseEntity<>(employeeService.addEmployee(request), HttpStatus.CREATED);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/update/{id}
     */
    @PutMapping(path = "/update/{idEmployee}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "idEmployee") String idEmployee, @Valid @RequestBody EmployeeRequest request){
        if (employeeService.existsByEmail(request.getEmail()) && employeeService.findByEmail(request.getEmail()).get().getId() != idEmployee)
            return new ResponseEntity(new MessageResponse("Error: Email address already exist."), HttpStatus.BAD_REQUEST);
        /*if (employeeService.existsByPhone(request.getPhone()) && employeeService.findByPhone(request.getPhone()).get().getId() != idEmployee)
            return new ResponseEntity(new MessageResponse("Error: Phone number already exist."), HttpStatus.BAD_REQUEST);*/
        Employee employee = employeeService.updateEmployee(idEmployee, request);
        log.info("Updating Employee with ID : {}", idEmployee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    /**
     * @NdourCodeur
     * URL ====> http://localhost:8080/api/v1/employees/delete/{id}
     */
    @DeleteMapping(path = "/delete/{idEmployee}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable String idEmployee){
        employeeService.deleteEmployee(idEmployee);
        log.info("Deleting Employee with ID : {}", idEmployee);
        return new ResponseEntity<>(new MessageResponse("Employee with ID:"+idEmployee+" is deleted successfully."), HttpStatus.OK);
    }

}
