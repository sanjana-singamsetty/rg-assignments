package com.example.employeejdbc;

import org.springframework.stereotype.Service;
import com.example.employeejdbc.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repo.findById(id);
    }

    public int addEmployee(Employee emp) {
        return repo.save(emp);
    }

    public int updateEmployee(Employee emp) {
        return repo.update(emp);
    }

    public int deleteEmployee(int id) {
        return repo.delete(id);
    }
}
