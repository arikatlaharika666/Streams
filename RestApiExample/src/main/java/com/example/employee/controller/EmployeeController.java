package com.example.employee.controller;

import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.employee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {

        return service.getAllEmployees();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        System.out.println("HELLO");
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Deleted employee with id " + id);
    }
}
