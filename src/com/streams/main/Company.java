package com.streams.main;

import com.streams.realtime.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Company {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("harika", 30, 40000, "IT"));
        employees.add(new Employee("Bob", 45, 90000, "HR"));
        employees.add(new Employee("Charlie", 28, 50000, "Engineering"));
        employees.add(new Employee("David", 38, 60000, "Sales"));
        employees.add(new Employee("Eve", 26, 55000, "HR"));
        employees.add(new Employee("Frank", 40, 95000, "Engineering"));

        //Remove duplicates using set
        Set<Employee> uniqueEmployees = new HashSet<>(employees);

        // 2. Group by department
        Map<String, List<Employee>> groupByDept = uniqueEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // 3. Sort employees by salary in each department
        groupByDept.forEach((dept, empList) -> {
                    System.out.println("Department: " + dept);
                    empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).
                            forEach(e -> System.out.println("employees " + e));

                }
        );



    }
}
