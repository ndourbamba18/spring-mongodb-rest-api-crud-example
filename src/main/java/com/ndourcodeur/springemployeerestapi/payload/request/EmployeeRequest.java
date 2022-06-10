package com.ndourcodeur.springemployeerestapi.payload.request;

import com.ndourcodeur.springemployeerestapi.entity.Address;
import com.ndourcodeur.springemployeerestapi.entity.Department;
import com.ndourcodeur.springemployeerestapi.entity.EmployeeStatus;
import com.ndourcodeur.springemployeerestapi.entity.Gender;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Data
public class EmployeeRequest {

    private String _id;

    @NotBlank(message = "First Name should not be empty")
    private String firstName;

    @NotBlank(message = "Last Name should not be empty")
    private String lastName;

    @NotBlank(message = "Phone Number should not be empty")
    private String phone;

    @NotBlank(message = "Email Address should not be empty")
    @Email(message = "Email Address should be valid")
    private String email;

    @NotBlank(message = "Job Title should not be empty")
    private String jobTitle;

    @NotBlank(message = "Image Url should not be empty")
    private String imageUrl;

    @PositiveOrZero(message = "The salary should be positive")
    private double salary;

    @Past(message = "Date of birth should be in the past")
    private Date dob;

    private Gender gender;

    private Department department;

    private EmployeeStatus status;

    private Address address;

    private Date createdAt;

    private Date updatedAt;
}
