package org.pkg.dao.Impl;

import org.pkg.classes.Employee;
import org.pkg.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeImpl implements EmployeeDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create(Employee employee) {
        String sql = "INSERT INTO employee value(?,?,?)";

        int res = jdbcTemplate.update(sql,employee.getId(),employee.getFirstName(),employee.getLastName());
        return res;
    }

    @Override
    public int update(Employee employee) {
        String sql = "UPDATE employee SET firstName = ?, lastName = ? WHERE id = ?";
        int res = jdbcTemplate.update(sql,employee.getFirstName(),employee.getLastName(),employee.getId());
        return res;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Employee read(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public List<Employee> read() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }
}
