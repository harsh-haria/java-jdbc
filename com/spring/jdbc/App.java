package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        System.out.println(jdbc);
        
        String query = "insert into student values (?,?,?)";
        int rowsAffected = jdbc.update(query, 2, "John Vells", "LA");
        System.out.println(rowsAffected);
    }
}
