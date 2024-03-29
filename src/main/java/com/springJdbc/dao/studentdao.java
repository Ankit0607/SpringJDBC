package com.springJdbc.dao;

import java.util.List;

import com.springJdbc.entities.student;

public interface studentdao {
	public int insert(student student);

	public int update(student student);

	public int delete(int studentId);

	public student getStudent(int studentId);

	public List<student> getAllStudent();

}
