package com.example.courses_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses_api.model.CourseInstance;
import com.example.courses_api.services.CourseInstanceService;

@RestController
@RequestMapping("/api")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping("/instances")
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        CourseInstance createdInstance = courseInstanceService.createCourseInstance(courseInstance);
        return new ResponseEntity<>(createdInstance, HttpStatus.CREATED);
    }

    @GetMapping("/instances/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCoursesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        List<CourseInstance> courseInstances = courseInstanceService.getCoursesByYearAndSemester(year, semester);
        return ResponseEntity.ok(courseInstances);
    }
    @GetMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstance> getCourseInstanceDetails(
            @PathVariable int year,
            @PathVariable int semester,
            @PathVariable Long courseId) {
    	//List<CourseInstance> courseInstance = courseInstanceService.getCourseInstanceDetails(year, semester, courseId);
        CourseInstance courseInstance = courseInstanceService.getCourseInstanceDetails(year, semester, courseId);
        if (courseInstance != null) {
            return ResponseEntity.ok(courseInstance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public ResponseEntity<String> deleteCourseInstance(
            @PathVariable int year,
            @PathVariable int semester,
            @PathVariable Long courseId) {
        courseInstanceService.deleteCourseInstance(year, semester, courseId);
        return ResponseEntity.ok("Instance deleted successfully");
    }

}