package com.akshay.javaprep.model;

public class Employee {
    int id;
    String name;
    String department;
    double salary;
    String gender;
    int age;

    public Employee(int id, String name, String department, double salary, String gender, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
        this.age = age;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}