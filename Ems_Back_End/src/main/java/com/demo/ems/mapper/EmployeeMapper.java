package com.demo.ems.mapper;

import com.demo.ems.dto.EmployeeDto;
import com.demo.ems.entity.EmployeeEntity;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity){
        return new EmployeeDto(
                employeeEntity.getId(),
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getEmail()
        );
    }

    public static EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto){
        return new EmployeeEntity(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
