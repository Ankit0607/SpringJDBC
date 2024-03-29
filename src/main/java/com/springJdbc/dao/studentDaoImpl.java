package com.springJdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springJdbc.entities.student;

public class studentDaoImpl implements studentdao {

	// generate getter & settet method of this variable to write the object
	private JdbcTemplate jdbctmpl;

	public JdbcTemplate getJdbctmpl() {
		return jdbctmpl;
	}

	public void setJdbctmpl(JdbcTemplate jdbctmpl) {
		this.jdbctmpl = jdbctmpl;
	}

	@Override
	public int insert(student student) {
		String query = "insert into student(id, name, city) values (?,?,?)";
		int r = this.jdbctmpl.update(query, student.getId(), student.getName(), student.getCity());

		return r;
	}

	@Override
	public int update(student student) {
		String query = "update student set name = ? ,city = ? where id = ?";
		int r = this.jdbctmpl.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	@Override
	public int delete(int studentId) {
		String query = "delete from student where id = ?";
		int r = this.jdbctmpl.update(query, studentId);
		return r;
	}

}
