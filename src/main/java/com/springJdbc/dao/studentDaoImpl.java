package com.springJdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springJdbc.entities.student;

@Component("studentDao")
public class studentDaoImpl implements studentdao {

	// generate getter & settet method of this variable to write the object
	@Autowired
	private JdbcTemplate jdbctmpl;

	public JdbcTemplate getJdbctmpl() {
		return jdbctmpl;
	}

	@Autowired
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

	@Override
	public student getStudent(int studentId) {
		String query = "select * from student where id = ?";
		RowMapper<student> rowMapper = new rowMapperImpl();
		student student = this.jdbctmpl.queryForObject(query, rowMapper, studentId);
		return student;
	}

	public List<student> getAllStudent() {
		String query = "select * from student";
		RowMapper<student> rowMapper = new rowMapperImpl();
		List<student> student = (List<student>) this.jdbctmpl.query(query, rowMapper);
		return student;
	}

}
