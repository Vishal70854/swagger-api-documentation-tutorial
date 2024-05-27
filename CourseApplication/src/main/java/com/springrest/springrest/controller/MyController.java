package com.springrest.springrest.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.service.CourseService;

@RestController
@Tag(name = "MyController", description = "To perform operations on fetching course application details")
public class MyController {
    @Autowired // create the object of CourseService implementing class on our behalf as per dependency injection rule
    private CourseService courseService;

    @Operation(
            summary = "GET operation for welcome message",
            description = "This api is used to get a welcome message for our course application"
    )
    @GetMapping("/home")
    public String home() {
        return "Welcome to Courses Application";
    }


    // get all courses
    @Operation(
            summary = "GET operation on course application",
            description = "This api is used to get list of courses from database for our course application"
    )
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    // get course by id
    @Operation(
            summary = "GET operation on course application",
            description = "This api is used to get a course details from database from our course application"
    )
    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(Long.parseLong(courseId));
    }

    // add a course
    @Operation(
            summary = "POST operation on course application",
            description = "This api is used to create a new course in database for our course application"
    )
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    // update a course
    @Operation(
            summary = "PUT operation on course application",
            description = "This api is used to update a course from database for our course application"
    )
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    // delete a course
    @Operation(
            summary = "DELETE operation on course application",
            description = "This api is used to delete a course from database in our course application"
    )
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

