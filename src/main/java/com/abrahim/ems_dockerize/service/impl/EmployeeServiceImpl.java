package com.abrahim.ems_dockerize.service.impl;

import com.abrahim.ems_dockerize.EmployeeMapper.EmployeeMapper;
import com.abrahim.ems_dockerize.dto.EmployeeDto;
import com.abrahim.ems_dockerize.entity.Employee;
import com.abrahim.ems_dockerize.exception.ResourceNotFoundException;
import com.abrahim.ems_dockerize.repository.EmployeeRepository;
import com.abrahim.ems_dockerize.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer employeeId) {

        Employee employee =employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee is not exits with given id : " + employeeId) );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getALlEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }
}
