package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
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

	@Override
	public Student getStudentData(int studentId) {
		//option 1
		RowMapper<Student> rowMapperImpl = new rowMapperImpl();		
		String query = "SELECT * FROM student where id = ?";
		Student studentData = this.jdbcTemplate.queryForObject(query, rowMapperImpl, studentId);
		
		//option 2. avoid this
//		String sql = "SELECT * FROM student where id = ?";
//		Student studentData = (Student) this.jdbcTemplate.queryForObject(sql, new RowMapper() {
//
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setId(rs.getInt(1));
//				student.setName(rs.getString(2));
//				student.setCity(rs.getString(3));
//				return student;
//			}
//		} , studentId);
		
		return studentData;
	}

	@Override
	public List<Student> getListOfStudents() {
		String query = "SELECT * FROM student";
		List<Student> students = this.jdbcTemplate.query(query, new rowMapperImpl());
		return students;
	}
	
}
