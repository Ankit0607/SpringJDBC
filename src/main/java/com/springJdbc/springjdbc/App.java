package com.springJdbc.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hey It's started now ..... :) :)");

		ApplicationContext context = new ClassPathXmlApplicationContext("com/springJdbc/springjdbc/config.xml");
		JdbcTemplate t1 = context.getBean("jdbcTemplate", JdbcTemplate.class);

		// ------- insert query -----
		String query = "insert into student(id, name, city) values (?,?,?)";
		// --- fire query ---
		int result = t1.update(query, 011, "Krishna", "Mathura");

		System.out.println("Number of record inserted: " + result);

	}
}
