package com.akshay.javaprep.Util;

import com.akshay.javaprep.model.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {

    public static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee(1, "Alice", "IT", 60000, "Female", 30),
            new Employee(2, "Bob", "HR", 40000, "Male", 28),
            new Employee(3, "Charlie", "IT", 70000, "Male", 35),
            new Employee(4, "Diana", "Finance", 80000, "Female", 40),
            new Employee(5, "Eve", "HR", 45000, "Female", 25),
            new Employee(6, "Frank", "IT", 50000, "Male", 29)
        );
    }
}
