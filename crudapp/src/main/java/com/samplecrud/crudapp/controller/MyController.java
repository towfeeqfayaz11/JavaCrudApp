package com.samplecrud.crudapp.controller;

import java.util.List;

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

import com.samplecrud.crudapp.entities.Course;
import com.samplecrud.crudapp.services.CourseService;

@RestController
public class MyController {
	
	@GetMapping("/healthcheck")
	public String home() {
		return "The app is up and running";
	}
	
	@Autowired
	private CourseService courseService;
	
	
	//get all the courses
	//@RequestMapping(path="courses", method=RequestMethod.GET)     ->  old way
	@GetMapping("/courses") 
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
	
	
	// get course by Id
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	// add a course and return same
    // @PostMapping(path="/courses", consumes="application/json")
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		
	}
	
	// updating a given course which is identified using its id
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	// delete a course by course id
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}