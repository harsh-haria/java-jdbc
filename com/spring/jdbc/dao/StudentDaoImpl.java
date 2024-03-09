package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		// TODO Auto-generated method stub
		int id = student.getId();
		String name = student.getName();
		String city = student.getCity();
		
		String query = "insert into student values (?,?,?)";
        int rowsAffected = jdbcTemplate.update(query, id, name, city);
        return rowsAffected;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int update(Student student) {
		int studentId = student.getId();
		String studentName = student.getName();
		String studentCity = student.getCity();
				
		String query = "UPDATE student set name = ?, city = ? WHERE id = ?";
		int rowsAffected = jdbcTemplate.update(query,studentName, studentCity, studentId);
		return rowsAffected;
	}

	@Override
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM student WHERE id = ?";
		int rowsAffected = jdbcTemplate.update(query, studentId);
		return rowsAffected;
	}
	
}
