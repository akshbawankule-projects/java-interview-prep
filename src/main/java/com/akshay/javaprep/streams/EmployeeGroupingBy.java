package com.akshay.javaprep.streams;

import com.akshay.javaprep.Util.EmployeeUtil;
import com.akshay.javaprep.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeGroupingBy {

    public static List<Employee> employees = EmployeeUtil.getEmployees();

    public static void main(String[] args) {
        //✅ 1. Group employees by department
        Map<String, List<Employee>> groupEmployeesByDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment)
                );
        System.out.println("Group employees by department: " + groupEmployeesByDepartment);
        System.out.println("//*********************************************************//");

        //✅ 2. Count employees in each department
        Map<String, Long> countOfEmployeesInEachDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment, Collectors.counting())
                );
        System.out.println("Count employees in each department: " + countOfEmployeesInEachDepartment);
        System.out.println("//*********************************************************//");

        //✅ 3. Average salary per department
        Map<String, Double> averageSalaryPerDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary))
                );
        System.out.println("Average salary per department: " + averageSalaryPerDepartment);
        System.out.println("//*********************************************************//");

        //✅ 4. Highest salary employee in each department
        Map<String, Optional<Employee>> highestSalaryEmployeeInEachDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))
                );
        System.out.println("Highest salary employee in each department: " + highestSalaryEmployeeInEachDepartment);
        System.out.println("//*********************************************************//");

        Map<String, Employee> highestSalaryEmployeeInEachDepartmentWithoutOptional = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                        Optional::get
                                ))
                );
        System.out.println("Highest salary employee in each department without optional: " + highestSalaryEmployeeInEachDepartmentWithoutOptional);
        System.out.println("//*********************************************************//");

        //✅ 5. Group by department → list of employee names
        Map<String, List<String>> listOfEmployeeNamesGroupByDepartment = employees.stream()
                .collect(
                  Collectors.groupingBy(Employee::getDepartment,
                          Collectors.mapping(Employee::getName, Collectors.toList()))
                );
        System.out.println("Group by department → list of employee names: " + listOfEmployeeNamesGroupByDepartment);
        System.out.println("//*********************************************************//");

        //✅ 6. Partition employees based on salary (>50k)
        Map<Boolean, List<Employee>> partitionEmployeesBasedOnSalaryGreaterThan50k = employees.stream()
                .collect(
                  Collectors.partitioningBy(e -> e.getSalary() > 50000)
                );
        System.out.println("Partition employees based on salary (>50k): " + partitionEmployeesBasedOnSalaryGreaterThan50k.get(true));
        System.out.println("Partition employees based on salary (<=50k): " + partitionEmployeesBasedOnSalaryGreaterThan50k.get(false));
        System.out.println("//*********************************************************//");

        //✅ 7. Group by department and gender (multi-level grouping)
        Map<String, Map<String, List<Employee>>> groupByDepartmentAndGender = employees.stream()
                .collect(
                  Collectors.groupingBy(Employee::getDepartment,
                          Collectors.groupingBy(Employee::getGender))
                );
        System.out.println("Group by department and gender (multi-level grouping): " + groupByDepartmentAndGender);
        System.out.println("//*********************************************************//");

        //✅ 8. Sum of salaries by department
        Map<String, Double> sumOfSalariesByDepartment = employees.stream()
                .collect(
                  Collectors.groupingBy(Employee::getDepartment,
                          Collectors.summingDouble(Employee::getSalary))
                );
        System.out.println("Sum of salaries by department: " + sumOfSalariesByDepartment);
        System.out.println("//*********************************************************//");

        //✅ 9. Group employees by age range (custom grouping)
        Map<String, List<Employee>> groupEmployeesByAgeRange = employees.stream()
                .collect(
                  Collectors.groupingBy(e -> {
                      if(e.getAge() < 30) 
                          return "Young";
                      else if (e.getAge() <= 40)
                          return "Mid";
                      else
                          return "Senior";
                  })
                );
        System.out.println("Group employees by age range (custom grouping): " + groupEmployeesByAgeRange);
        System.out.println("//*********************************************************//");

        //✅ 10. Find second highest salary per department
        Map<String, Employee> secondHighestSalaryPerDepartment = employees.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                                .skip(1)
                                                .findFirst()
                                                .orElse(null)
                                ))
                        );
        System.out.println("Second highest salary per department: " + secondHighestSalaryPerDepartment);
        System.out.println("//*********************************************************//");







    }



}
