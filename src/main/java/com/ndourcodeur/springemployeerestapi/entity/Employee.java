package com.ndourcodeur.springemployeerestapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "Employees")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee implements Serializable {

    @Id
    private String id;

    @Field(value = "First_Name")
    private String firstName;

    @Field(value = "Last_Name")
    private String lastName;

    @Field(value = "Phone_Number")
    @Indexed(unique = true)
    private String phone;

    @Field(value = "Email_Id")
    @Indexed(unique = true)
    private String email;

    @Field(value = "Employee_Code")
    private String employeeCode;

    @Field(value = "Image_Url")
    private String imageUrl;

    @Field(value = "Salary")
    private double salary;

    @Field(value = "Date_of_Birth")
    private Date dob;

    @Field(value = "Gender")
    private Gender gender;

    @Field(value = "Department")
    private Department department;

    @Field(value = "Employee_Status")
    private EmployeeStatus status;

    @Field(value = "Address")
    private Address address;

    @Field(value = "Created_At")
    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    @Field(value = "Updated_At")
    private Date updatedAt;
}
