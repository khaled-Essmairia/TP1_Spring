package com.khaled.dao;

import java.util.List;

import javax.sql.DataSource;

import com.khaled.models.Student;

public interface StudentDAO {

    List<Student> getAllStudent();
	Student getStudentById(int id);
	void SaveStudent(Student student);
	int delete(int id);
	int update(Student student);
	
	//every class will be able to bring data it is for web.xml
	public void setDataSource(DataSource dataSource);
}
