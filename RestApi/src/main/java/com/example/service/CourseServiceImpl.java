package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
		
	}

	@Override
	public Course getCourse(Integer courseId) {
		
		return courseRepository.findById(courseId).get();
	}

	@Override
	public void deleteCourse(Integer courseId) {
		Course entity=courseRepository.getOne(courseId);
		 courseRepository.delete(entity);
		
	}

	@Override
	public Course updateCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	
	
	
	


	

}
