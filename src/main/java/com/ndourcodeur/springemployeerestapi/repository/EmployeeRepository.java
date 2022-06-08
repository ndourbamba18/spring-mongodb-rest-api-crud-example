package com.ndourcodeur.springemployeerestapi.repository;

import com.ndourcodeur.springemployeerestapi.entity.Department;
import com.ndourcodeur.springemployeerestapi.entity.Employee;
import com.ndourcodeur.springemployeerestapi.entity.EmployeeStatus;
import com.ndourcodeur.springemployeerestapi.entity.Gender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    /*Employee findByEmailContaining(String email);
    Employee findByPhoneContaining(String phone);*/

    Optional<Employee> findByEmailContaining(String email);
    Optional<Employee> findByPhoneContaining(String phone);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    /*List<Employee> findByDepartment(Department department);
    List<Employee> findByGender(Gender gender);
    List<Employee> findByEmployeeStatus(EmployeeStatus status);*/

}
