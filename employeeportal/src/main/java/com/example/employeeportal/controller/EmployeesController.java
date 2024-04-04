package com.example.employeeportal.controller;

import com.example.employeeportal.domain.EmployeeDto;
import com.example.employeeportal.entity.EmployeeEntity;
import com.example.employeeportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class EmployeesController {

    @Autowired
    private EmployeeService empservice;

    @PostMapping("/employee")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        return empservice.createEmployee(employeeDto);
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployee(@PathVariable Long  id){
        return empservice.getEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return empservice.updateEmployee(id,employeeDto);
    }

    @DeleteMapping("/employee/{id}/delete")
    public String deleteEmployee(@PathVariable Long id){
        return empservice.deleteEmployee(id);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        return empservice.getAllEmployee();
    }
}
