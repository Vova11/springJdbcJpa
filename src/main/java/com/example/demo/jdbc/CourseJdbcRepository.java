package com.example.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Course;

@Repository
public class CourseJdbcRepository {
    
    @Autowired
    private JdbcTemplate springJdbcSJdbcTemplate;

    private static String INSERT_QUERY = 
        """
        INSERT INTO course (id, name, author) VALUES
        (1, 'Introduction to Java', 'John Doe'),
        (2, 'Advanced Java Programming', 'Jane Smith'),
        (3, 'Spring Boot Basics', 'Alice Johnson'),
        (4, 'Database Design', 'Bob Brown'),
        (5, 'Data Structures and Algorithms', 'Emily Davis'),
        (6, 'Web Development with HTML & CSS', 'Michael Wilson'),
        (7, 'JavaScript Essentials', 'Sara Lee'),
        (8, 'Python for Data Science', 'David Martinez'),
        (9, 'Machine Learning with Python', 'Laura Clark'),
        (10, 'Cloud Computing Fundamentals', 'Tom Robinson');
        """;

    private static String INSERT_SECOND_QUERY =
        """
        INSERT INTO course (id, name, author) VALUES
        (?,?,?);
        """;

    private static String DELETE_FROM_SECOND_QUERY =
        """
        DELETE FROM course WHERE id = ?;
        """;
    
    private static String SELECT_QUERY =
        """
        SELECT * FROM course WHERE id = ?;
        """;
    

    public void insert() {
        springJdbcSJdbcTemplate.update(INSERT_QUERY);
    }

    public void insert(Course course) {
        springJdbcSJdbcTemplate.update(INSERT_SECOND_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcSJdbcTemplate.update(DELETE_FROM_SECOND_QUERY,id);
    }

    public Course findById(long id) {
        return springJdbcSJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class), id);
    }
}
