package com.giri.employeeservice.service.impl;

import com.giri.employeeservice.dto.APIResponseDto;
import com.giri.employeeservice.dto.DepartmentDto;
import com.giri.employeeservice.dto.EmployeeDto;
import com.giri.employeeservice.entity.Employee;
import com.giri.employeeservice.repository.EmployeeRepository;
import com.giri.employeeservice.service.APIClient;
import com.giri.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployees(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee saveEmployee = employeeRepository.save(employee);
        return new EmployeeDto(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()
        );
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee byId = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + byId.getDepartmentCode(), DepartmentDto.class);

//        DepartmentDto departmentDto=departmentDtoResponseEntity.getBody();
//        DepartmentDto departmentDto = webClient.get()
//                                        .uri("http://localhost:8080/api/departments/" + byId.getDepartmentCode())
//                                        .retrieve()
//                                        .bodyToMono(DepartmentDto.class)
//                                        .block();

        DepartmentDto department = apiClient.getDepartment(byId.getDepartmentCode());
        EmployeeDto employeeDto = new EmployeeDto(
                byId.getId(),
                byId.getFirstName(),
                byId.getLastName(),
                byId.getEmail(),
                byId.getDepartmentCode()
        );

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(department);
        return apiResponseDto;
    }
}