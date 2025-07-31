package com.example.employee.service_impl;

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
                .orElseThrow(() ->new NoSuchElementException("employee not found with id " + id));

    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee empUpdated) {
        Employee existing = getEmployeeById(id);
        existing.setName(empUpdated.getName());
        existing.setDepartment(empUpdated.getDepartment());
        existing.setEmail((empUpdated.getEmail()));
        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        repository.delete(existing);

    }
}
