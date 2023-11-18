package com.giri.employeeservice.controller;

import com.giri.employeeservice.dto.APIResponseDto;
import com.giri.employeeservice.dto.EmployeeDto;
import com.giri.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Employee Endpoint")
@RestController
@RequestMapping("employee-service")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // build save employee rest api
    @Operation(summary = "Save the employee")
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployees = employeeService.saveEmployees(employeeDto);
        return new ResponseEntity<>(saveEmployees, HttpStatus.CREATED);
    }
    // build get employee by id rest api
    @Operation(summary = "Get the employee by employeeId")
    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("employeeId") Long employeeId){
        APIResponseDto serviceEmployeeById = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(serviceEmployeeById, HttpStatus.OK);
    }
}