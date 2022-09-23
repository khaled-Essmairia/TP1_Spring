package com.khaled.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.khaled.models.Student;
import com.khaled.rowmapper.StudentRowMapper;

public class StudentDAOImpl implements StudentDAO {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public StudentDAOImpl(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student";
		List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		return null;
	}

	@Override
	public Student getStudentById(int id) {
		String sql = "SELECT `id`, `student_id`, `name`, `city`, `age` FROM `student` WHERE `id`=?";
		//.query to bring data; forObject to get single data
		return jdbcTemplate.queryForObject(sql,new Object[]{id},new StudentRowMapper());	
	}

	@Override
	public void SaveStudent(Student student) {
		Object[] sudentInfo = {
			student.getStudent_id(),student.getName(),student.getAge(),student.getCity()};

		String sql = "INSERT INTO `student`(`student_id`, `name`, `city`, `age`) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,sudentInfo);
	}

	@Override
	public int update(Student student) {
		
		String sql = "UPDATE `student` SET `student_id`='"+student.getStudent_id()
		             +"',`name`='"+student.getName()+"',`city`='"+student.getCity()
		             +"',`age`='"+student.getAge()+"' WHERE  `id`="+student.getId();
				
		return jdbcTemplate.update(sql);
	}

	@Override
	public int delete(int id) {
		
		String sql = "DELETE FROM `student` WHERE `id`="+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

}
