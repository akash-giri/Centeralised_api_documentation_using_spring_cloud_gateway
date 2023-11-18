package com.giri.departmentservice.controller;

import com.giri.departmentservice.dto.DepartmentDto;
import com.giri.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Department Endpoint")
@RestController
@RequestMapping("department-service")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    // build save department Rest api
    @Operation(summary = "Save the department")
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    // build get department rest api
    @Operation(summary = "get the department by department code")
    @GetMapping(value = "/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentByCode = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentByCode,HttpStatus.OK);
    }
}