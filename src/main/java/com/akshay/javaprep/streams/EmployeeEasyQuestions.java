package com.akshay.javaprep.streams;

import com.akshay.javaprep.Util.EmployeeUtil;
import com.akshay.javaprep.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeEasyQuestions {

    public static List<Employee> employees = EmployeeUtil.getEmployees();

    public static void main(String[] args) {
        //1. List all employee names in a single list
        List<String> employeeNamesList = employees.stream()
                .map(Employee::getName)
                .toList();
        System.out.println("List all employee names in a single list: " + employeeNamesList);
        System.out.println("//*********************************************************//");

        //2. Count the number of employees in each department
        Map<String, Long> numberOfEmployeeInEachDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.counting())
                );
        System.out.println("Number of employees in each department: " + numberOfEmployeeInEachDepartment);
        System.out.println("//*********************************************************//");

        //3. Find the employee with the highest salary
//        Employee employeeWithHighestSalary = employees.stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
//                .findFirst().orElse(null);

        Employee employeeWithHighestSalary = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
        System.out.println("The employee with the highest salary: " + employeeWithHighestSalary);
        System.out.println("//*********************************************************//");

        //4. Partition employees based on salary > 50k
        Map<Boolean, List<Employee>> partitionEmployeesBasedOnSalaryGreaterThan50k = employees.stream()
                .collect(
                  Collectors.partitioningBy(e -> e.getSalary() > 50000)
                );
        System.out.println("Partition employees based on salary > 50k: " + partitionEmployeesBasedOnSalaryGreaterThan50k);
        System.out.println("//*********************************************************//");

        //5. Get a list of employee names in each department
        Map<String, List<String>> listOfEmployeeNamesInEachDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors.toList(),
                                        list -> list.stream().map(Employee::getName).toList()))
                );
        System.out.println("Get a list of employee names in each department: " + listOfEmployeeNamesInEachDepartment);
        System.out.println("//*********************************************************//");

        //6. List employees whose salary is above department average
        Map<String, Double> averageSalariesByDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary))
                );

        List<Employee> employeesAboveDepartmentAverage = employees.stream()
                .filter(emp -> emp.getSalary() > averageSalariesByDepartment.get(emp.getDepartment()))
                .toList();

        System.out.println("List employees whose salary is above department average: " + employeesAboveDepartmentAverage);
        System.out.println("//*********************************************************//");


    }
}
