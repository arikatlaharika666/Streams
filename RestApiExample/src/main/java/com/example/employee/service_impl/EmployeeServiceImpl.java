package com.example.employee.service_impl;

import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.exception.InvalidNameLengthException;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->new EmployeeNotFoundException("employee not found with id " + id));

    }

    @Override
    public Employee createEmployee(Employee employee) {
        validateNameLength(employee.getName());
        invalidNameLength(employee.getName());
        return repository.save(employee);
    }

    private void invalidNameLength(String name) {
        if(name.equals(null) || name.length() < 10){
            throw new InvalidNameLengthException("Employee not found");
        }
    }

    @Override
    public Employee updateEmployee(Long id, Employee empUpdated) {
        validateNameLength(empUpdated.getName());
        Employee existing = getEmployeeById(id);
        existing.setName(empUpdated.getName());
        existing.setDepartment(empUpdated.getDepartment());
        existing.setEmail((empUpdated.getEmail()));
        return repository.save(existing);
    }

    private void validateNameLength(String name) {
        if(name == null || name.length() > 10){
        throw new InvalidNameLengthException("Employee name must be 10 characters or less");
        }
    }



    @Override
    public void deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        repository.delete(existing);

    }
}
