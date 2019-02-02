package com.example.employeerestservice.controllers;

import com.example.employeerestservice.models.Employee;
import com.example.employeerestservice.services.EmployeeService;
import com.sun.research.ws.wadl.HTTPMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
    @Path("{employeeId")
    public Employee readEmployee(@PathVariable("employeeId") Integer employeeId) throws Exception {
        return employeeService.getEmployee(employeeId);
    }


    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.DELETE)
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }
}
