package com.springrest.springrest.controller;


import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class MyController {

    @Autowired
    private CourseService courseService;
    //Home
    @GetMapping("/home")
    public String home()
    {
        return "Welcome to Courses application";
    }

    //Get all courses
    @GetMapping()
    public List<Course> getCourses()
    {
        return courseService.getCourses();
    }

    //Get Single Course
    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return courseService.getCourse(Long.parseLong(courseId));
    }

    //Add Course
    @PostMapping()
    public Course addCourse(@RequestBody Course course)
    {
        return courseService.addCourse(course);
    }

    //Update Course
    @PutMapping()
    public Course updateCourse(@RequestBody Course course)
    {
        return courseService.updateCourse(course);
    }

    //Delete Course
    @DeleteMapping("/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
    {
        try{
            courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
