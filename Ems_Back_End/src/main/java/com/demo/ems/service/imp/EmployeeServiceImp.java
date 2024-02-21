package com.demo.ems.service.imp;

import com.demo.ems.dto.EmployeeDto;
import com.demo.ems.entity.EmployeeEntity;
import com.demo.ems.exception.ResourceNotFoundException;
import com.demo.ems.mapper.EmployeeMapper;
import com.demo.ems.repository.EmployeeRepository;
import com.demo.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = EmployeeMapper.mapToEmployeeEntity(employeeDto);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(int employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employeeEntity);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(int employeeId, EmployeeDto updateEmployee) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId)
        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
