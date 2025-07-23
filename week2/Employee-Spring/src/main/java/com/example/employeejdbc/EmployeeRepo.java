package com.example.employeejdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee findById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    public int save(Employee emp) {
        String sql = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getDepartment());
    }

    public int update(Employee emp) {
        String sql = "UPDATE employee SET name = ?, department = ? WHERE id = ?";
        return jdbcTemplate.update(sql, emp.getName(), emp.getDepartment(), emp.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
