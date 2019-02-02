package com.example.employeerestservice.services;

import com.example.employeerestservice.models.Employee;
import com.example.employeerestservice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //READ Operation
    public Employee getEmployee(int employeeId) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        return employeeOptional.get();
    }

    //CREATE Operation
    public Employee saveEmployee(Employee employee) {
         return employeeRepository.save(employee);

    }

    //DELETE Operation
    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteById(employee.getId());
    }

    //UPDATE Operation
    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            deleteEmployee(employee);
        }
        return saveEmployee(employee);
    }


}
