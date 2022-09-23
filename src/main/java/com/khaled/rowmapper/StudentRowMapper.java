package com.khaled.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import com.khaled.models.Student;

@Controller
public class StudentRowMapper implements RowMapper<Student> {

	@Override
	//bring users from database 
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setName(rs.getString("name"));
		student.setId(rs.getInt("name"));
		student.setAge(rs.getString("age"));
		student.setStudent_id(rs.getString("student_id"));
		student.setCity(rs.getString("city"));
		return student;
	}

}
