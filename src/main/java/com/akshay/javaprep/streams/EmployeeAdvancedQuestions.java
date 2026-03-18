package com.akshay.javaprep.streams;

import com.akshay.javaprep.Util.EmployeeUtil;
import com.akshay.javaprep.model.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAdvancedQuestions {
    public static List<Employee> employees = EmployeeUtil.getEmployees();

    public static void main(String[] args) {

        //12. Second-highest salary employee per department
        Map<String, Employee> secondHighestSalaryEmployeePerDepartment = employees.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getDepartment,
                                        Collectors.collectingAndThen(Collectors.toList(),
                                                list -> list.stream()
                                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                                        .skip(1)
                                                        .findFirst()
                                                        .orElse(null)
                                        ))
                        );
        System.out.println("Second-highest salary employee per department: " + secondHighestSalaryEmployeePerDepartment);
        System.out.println("//*********************************************************//");

        //13. Top 3 highest-paid employees per department
        Map<String, List<Employee>> top3HighestPaidEmployeesPerDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .limit(3).toList()
                        ))
                );
        System.out.println("Top 3 highest-paid employees per department: " + top3HighestPaidEmployeesPerDepartment);
        System.out.println("//*********************************************************//");

        //14. Group employees by department and get names concatenated as comma-separated strings
        Map<String, String> groupEmployeesByDepartmentAndGetNamesConcatenatedAsCommaSeparatedStrings = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors.toList(),
                                        emp -> emp.stream()
                                                .map(Employee::getName).collect(Collectors.joining(", "))))
                );
        System.out.println("Group employees by department and get names concatenated as comma-separated strings: " + groupEmployeesByDepartmentAndGetNamesConcatenatedAsCommaSeparatedStrings);
        System.out.println("//*********************************************************//");

        //15. Find employees who share the same salary
        Map<Double, List<Employee>> employeesWhoShareTheSameSalary = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getSalary)
                ).entrySet()
                .stream()
                        .filter(emp -> emp.getValue().size() > 1)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue
                                ));
        System.out.println("Employees who share the same salary: " + employeesWhoShareTheSameSalary);
        System.out.println("//*********************************************************//");

        //16. Count number of employees per department per gender
        Map<String, Map<String, Long>> numberOfEmployeesPerDepartmentPerGender = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.groupingBy(Employee::getGender,
                                        Collectors.counting()))
                );
        System.out.println("Number of employees per department per gender: " + numberOfEmployeesPerDepartmentPerGender);
        System.out.println("//*********************************************************//");

        //17. Find department with maximum average salary
        Map<String, Double> departmentWiseAverageSalary = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );

        Map.Entry<String, Double> departmentWithMaxAverageSalary = departmentWiseAverageSalary.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println("Department with maximum average salary: " + departmentWithMaxAverageSalary);
        System.out.println("//*********************************************************//");

        //18. Partition employees by gender, then by salary > 50k
        Map<String, Map<Boolean, List<Employee>>> partitionEmployeesByGenderThenBySalaryGreaterThan50k = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getGender,
                                Collectors.partitioningBy(emp -> emp.getSalary()> 50000))
                );
        System.out.println("Partition employees by gender, then by salary > 50k: " + partitionEmployeesByGenderThenBySalaryGreaterThan50k);
        System.out.println("//*********************************************************//");

        //19. Group employees by decade of age (20s, 30s, 40s)
        Map<String, List<Employee>> groupEmployeesByDecadeOfAgeList = employees.stream()
                .collect(
                        Collectors.groupingBy(emp -> (emp.getAge() / 10) * 10 +"s")
                );

        Map<String, List<Employee>> groupEmployeesByDecadeOfAge = employees.stream()
                .collect(
                  Collectors.groupingBy(
                          emp -> {
                              if(emp.getAge() < 30)
                                  return "20s";
                              else if (emp.getAge() < 40) return "30s";
                              else if(emp.getAge() < 50) return "40s";
                              else return "50s";
                          }
                  )
                );
        System.out.println("Group employees by decade of age (20s, 30s, 40s): " + groupEmployeesByDecadeOfAgeList);
        System.out.println("//*********************************************************//");

        //20. Find the median salary per department





    }
}
