package com.giri.employeeservice.service;

import com.giri.employeeservice.dto.APIResponseDto;
import com.giri.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployees(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}