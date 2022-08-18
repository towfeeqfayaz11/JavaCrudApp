package com.samplecrud.crudapp.services;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samplecrud.crudapp.dao.CourseDao;
import com.samplecrud.crudapp.entities.Course;

@Service
public class CourseServiceImplementation implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
//	List<Course> list;
	
	//constructor
	public CourseServiceImplementation() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Core Course", "This Course Contains Basice Of Java"));
//		list.add(new Course(8143, "Spring Boot Course", "creating restapi using springboot"));
//		list.add(new Course(3888, "Python Course", "Course for Novice Coders"));
		
	}
	
	@Override
	public List<Course> getCourses() {
		
//		return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
//		
//		return c;
		return courseDao.getReferenceById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course; 
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		list = this.list.stream().filter(e->e.getId() != courseId).collect(Collectors.toList());
		
		
//		Course entity = courseDao.getOne(courseId);
//		courseDao.delete(entity);
		courseDao.deleteById(courseId);
	}

}