package com.example.service;

import java.util.List;

import com.example.model.Course;

public interface CourseService {
	
	public Course addCourse(Course course);
	public List<Course> getCourses();
   public Course getCourse(Integer courseId);
   
   public void deleteCourse(Integer courseId);
   
   public Course updateCourse(Course course);
	   
	   
	   
	   
   }
