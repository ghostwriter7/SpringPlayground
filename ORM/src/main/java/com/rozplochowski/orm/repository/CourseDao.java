package com.rozplochowski.orm.repository;

import com.rozplochowski.orm.domain.Course;

import java.util.List;

public interface CourseDao {

    Course store(Course course);

    Course findById(Long id);

    List<Course> findAll();

    void delete(Long courseId);
}
