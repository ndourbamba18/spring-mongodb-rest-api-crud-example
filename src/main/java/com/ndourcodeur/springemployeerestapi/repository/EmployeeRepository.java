package com.ndourcodeur.springemployeerestapi.repository;

import com.ndourcodeur.springemployeerestapi.entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Optional<Employee> findByEmailContaining(String email);
    Optional<Employee> findByPhoneContaining(String phone);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    List<Employee> findByDepartment(Department department);
    List<Employee> findByGender(Gender gender);
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee> findByAddress(Address address);

}
