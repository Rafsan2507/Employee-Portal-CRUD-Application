package com.example.employeeportal.service;

import com.example.employeeportal.domain.EmployeeDto;
import com.example.employeeportal.entity.EmployeeEntity;
import com.example.employeeportal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepository;

    public EmployeeDto createEmployee(EmployeeDto empDto){
        //Mapping DTO to Entity
        EmployeeEntity empEntity = new EmployeeEntity();
        empEntity.setName(empDto.getName());
        empEntity.setDesignation(empDto.getDesignation());
        empEntity.setPhone(empDto.getPhone());

        empRepository.save(empEntity);

        empDto.setName(empEntity.getName());
        empDto.setDesignation(empEntity.getDesignation());
        empDto.setPhone(empEntity.getPhone());
        return empDto;
    }

    public EmployeeDto getEmployee(Long id){
        //Fetching Employee Entity
        Optional<EmployeeEntity> employeeOptional = empRepository.findById(id);
        EmployeeEntity employeeEntity = employeeOptional.get();

        //Error handling
        if(employeeEntity == null){
            throw new RuntimeException("Employee not found");
        }

        //Mapping Entity to DTO
        EmployeeDto empDto = new EmployeeDto();
        empDto.setName(employeeEntity.getName());
        empDto.setDesignation(employeeEntity.getDesignation());
        empDto.setPhone(employeeEntity.getPhone());
        return empDto;
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto){
        Optional<EmployeeEntity> employeeOptional = empRepository.findById(id);
        EmployeeEntity employeeEntity = employeeOptional.get();

        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setDesignation(employeeDto.getDesignation());
        employeeEntity.setPhone(employeeDto.getPhone());

        empRepository.save(employeeEntity);

        employeeDto.setName(employeeEntity.getName());
        employeeDto.setDesignation(employeeEntity.getDesignation());
        employeeDto.setPhone(employeeEntity.getPhone());
        return employeeDto;
    }

    public String deleteEmployee(Long id){
        Optional<EmployeeEntity> employeeOptional = empRepository.findById(id);
        EmployeeEntity employeeEntity = employeeOptional.get();

        empRepository.delete(employeeEntity);
        return "Success";
    }

    public List<EmployeeEntity> getAllEmployee(){

        return empRepository.findAll();
    }
}
