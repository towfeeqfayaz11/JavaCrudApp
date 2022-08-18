package com.samplecrud.crudapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samplecrud.crudapp.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
