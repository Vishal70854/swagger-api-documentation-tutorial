package com.springrest.springrest.service;

import com.springrest.springrest.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    public Course getCourseById(long courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(long courseId);
}