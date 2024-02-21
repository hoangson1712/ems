package com.demo.ems.service;

import com.demo.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(int employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(int employeeId, EmployeeDto updateEmployee);
    void deleteEmployee(int employeeId);
}
