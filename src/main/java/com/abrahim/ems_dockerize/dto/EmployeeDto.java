package com.abrahim.ems_dockerize.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
