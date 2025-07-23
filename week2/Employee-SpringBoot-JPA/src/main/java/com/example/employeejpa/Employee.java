package com.example.employeejpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee{

    @Id
    private long id;
    private String name;
    private String department;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee(long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
