package com.springJdbc.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class jdbcConfig {
	@Bean(name = {"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("secret@secret");
		return ds;
	}
	
	@Bean(name = {"dataSource"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name = {"studentDao"})
	public studentdao getStudentDao() {
		studentDaoImpl studentDao = new studentDaoImpl();
		studentDao.setJdbctmpl(getTemplate());
		return studentDao;
	}

}
