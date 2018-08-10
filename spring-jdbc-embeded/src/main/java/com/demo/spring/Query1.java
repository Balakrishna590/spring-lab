package com.demo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Query1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");

		List<Employee> empList = jt.query("Select * from emp", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int index) throws SQLException {

				return new Employee(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
						rs.getDouble("salary"));
			}
		});

		List<Employee> empList1 = jt.query("Select * from emp", (rs, index) -> {

			return new Employee(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
					rs.getDouble("salary"));
		});

		for (Employee e : empList) {
			System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSalary());
		}

		// Query for 1 Object
		int id = 103;

		Employee e = jt.queryForObject("Select * from emp where empno=" + id, (rs, index) -> {

			return new Employee(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
					rs.getDouble("salary"));
		});
		System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getSalary());
	}

}
