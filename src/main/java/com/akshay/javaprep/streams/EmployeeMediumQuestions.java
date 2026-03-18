package com.akshay.javaprep.streams;

import com.akshay.javaprep.Util.EmployeeUtil;
import com.akshay.javaprep.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeMediumQuestions {
    public static List<Employee> employees = EmployeeUtil.getEmployees();

    public static void main(String[] args) {

        //6. Average salary per department
        Map<String, Double> averageSalaryPerDepartment = employees.stream()
                                .collect(
                                        Collectors.groupingBy(Employee::getDepartment,
                                                Collectors.averagingDouble(Employee::getSalary))
                                );
        System.out.println("Average salary per department: " + averageSalaryPerDepartment);
        System.out.println("//*********************************************************//");

        //7. Highest salary employee per department
        Map<String, Optional<Employee>> highestSalaryEmployeePerDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))
                );
        System.out.println("Highest salary employee per department: " + highestSalaryEmployeePerDepartment);
        System.out.println("//*********************************************************//");

        //8. Group employees by department and gender (nested grouping)
        Map<String, Map<String, List<Employee>>> groupEmployeesByDepartmentAndGender = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.groupingBy(Employee::getGender))
                );
        System.out.println("Group employees by department and gender (nested grouping): " + groupEmployeesByDepartmentAndGender);
        System.out.println("//*********************************************************//");

        //9. Sum of salaries by department
        Map<String, Double> sumOfSalariesByDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary))
                );
        System.out.println("Sum of salaries by department: " + sumOfSalariesByDepartment);
        System.out.println("//*********************************************************//");

        //10. Employees in each age range (Young: <30, Mid: 30–40, Senior: >40)
        Map<String, List<Employee>> employeesInEachAgeRange = employees.stream()
                .collect(
                        Collectors.groupingBy(emp -> {
                            if(emp.getAge() < 30) return "Young";
                            else if (emp.getAge() > 40) return "Senior";
                            else return "Mid";
                        })
                );
        System.out.println("Employees in each age range (Young: <30, Mid: 30–40, Senior: >40): " + employeesInEachAgeRange);
        System.out.println("//*********************************************************//");

    }
}
