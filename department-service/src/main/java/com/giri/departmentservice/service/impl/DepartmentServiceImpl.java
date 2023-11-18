package com.giri.departmentservice.service.impl;

import com.giri.departmentservice.dto.DepartmentDto;
import com.giri.departmentservice.entity.Department;
import com.giri.departmentservice.repository.DepartmentRepository;
import com.giri.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
            );
        Department saveDepartment = departmentRepository.save(department);

        return new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department byDepartmentCode = departmentRepository.findByDepartmentCode(departmentCode);
        return new DepartmentDto(
                byDepartmentCode.getId(),
                byDepartmentCode.getDepartmentName(),
                byDepartmentCode.getDepartmentDescription(),
                byDepartmentCode.getDepartmentCode()
        );
    }
}