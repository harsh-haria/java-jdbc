package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
//        Student student = new Student(3, "Hue Tux", "Minisota");
//        Student student2 = new Student(2, "Mike forax", "Mexico");
//        int response1 = studentDao.insert(student);
//        int response2 = studentDao.update(student2);
//        int response3 = studentDao.delete(1);
//        System.out.println(response1 + " " + response2 + " " + response3);
        
//        Student studentData = studentDao.getStudentData(2);
        
        List<Student> listOfStudents = studentDao.getListOfStudents();
        for (Student s:listOfStudents) {
        	System.out.println(s);
        }
//        System.out.println(studentData);
    }
}
