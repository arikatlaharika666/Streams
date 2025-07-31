package com.streams.main;

import com.streams.realtime.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class sample {
    public static void main(String[] args) {

        System.out.println("Welcome to intellij, idea");
       List<Employee>  employees= Arrays.asList(
                new Employee("Alice", 32, 70000, "Engineering"),
                new Employee("Bob", 45, 90000, "HR"),
                new Employee("Charlie", 28, 50000, "Engineering"),
                new Employee("David", 38, 60000, "Sales"),
                new Employee("Eve", 26, 55000, "HR"),
                new Employee("Frank", 40, 95000, "Engineering")
        );

        // 1. Get names of employees in Engineering
        System.out.println("Employees in Engineering: ");
        employees.stream().filter(e -> e.getDepartment().equals("Engineering"))
                 .forEach(System.out::println);

        // 2. Sort employees by salary (descending)
        System.out.println("Employees salary from lower to higher: ");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);
        // 3. Group employees by department
        System.out.println("Employees grouped by department");
        Map<String,List<Employee>> groupedByDepts = employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepts.forEach((dept,list) -> {
            System.out.println(dept);
            list.forEach(e -> System.out.println("  " + e));
                });
        //
        // 4. List employees older than 30, sorted by age
        List<Employee> olderThan30 = employees.stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparingInt(e -> e.getAge()))
                .collect(Collectors.toList());

        System.out.println("Employees older than 30: " + olderThan30);
        // 5. Find average salary per department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(),
                        Collectors.averagingDouble(e -> e.getSalary())
                ));
        System.out.println("Average Salary by Department: " + avgSalaryByDept);

        // 6. Group employees by department
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDept.forEach((dept, list) -> {
            System.out.println(dept);
            list.forEach(e -> System.out.println("  " + e));
        });

        // 7. Get names of employees who earn more than $75,000
        System.out.println("\nEmployees earning more than $75,000:");
        List<String> highEarners = employees.stream()
                .filter(e -> e.getSalary() > 75000)
                .map(Employee::getName)
                .collect(Collectors.toList());
        highEarners.forEach(System.out::println);
    }


}
