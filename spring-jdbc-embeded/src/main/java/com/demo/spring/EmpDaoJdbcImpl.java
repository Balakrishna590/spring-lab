package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public String saveEmp(Employee e) {
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn
						.prepareStatement("insert into emp(empno,name,address,salary) values(?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getEmpName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});
		if (count == 1)
			return "saved";
		return "Problem Occurred";
	}

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> empList = jt.query("Select * from emp", (rs, index) -> {

			return new Employee(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
					rs.getDouble("salary"));
		});
		return empList;
	}

	@Override
	public Employee findById(int empid) {
		Employee e = jt.queryForObject("Select * from emp where empno=" + empid, (rs, index) -> {

			return new Employee(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
					rs.getDouble("salary"));
		});
		return e;
	}

	@Override
	public String deleteEmp(int empId) {
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn.prepareStatement("delete from emp where empno=?");
				pst.setInt(1, empId);

				return pst;
			}
		});
		if (count == 1)
			return "deleted";
		return "Could  not delete Employee";
	}

	@Override
	public Employee updateEmp(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveAll(List<Employee> empList) {
		for (Employee e : empList) {
			this.saveEmp(e);
		}
		return "saved all";
	}

}
