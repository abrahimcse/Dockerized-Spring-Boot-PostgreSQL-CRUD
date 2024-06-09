package com.abrahim.ems_dockerize.service;

import com.abrahim.ems_dockerize.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Integer employeeId);

    List<EmployeeDto> getALlEmployee();

    EmployeeDto updateEmployee (Integer employeeId, EmployeeDto updateEmployee);

    void deleteEmployee(Integer employeeId);
}
