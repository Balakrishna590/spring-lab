package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		JdbcTemplate jt=(JdbcTemplate)ctx.getBean("jdbcTemplate");
		
	
	int count=	jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst= conn.prepareStatement(
						"insert into emp(empno,name,address,salary) values(?,?,?,?)");
				pst.setInt(1, 105);
				pst.setString(2, "Tarak");
				pst.setString(3, "Hyderabad");
				pst.setDouble(4, 76000);
				return pst;
			}
		});
		
	System.out.println("rows updated : "+count);
		

	}

}
