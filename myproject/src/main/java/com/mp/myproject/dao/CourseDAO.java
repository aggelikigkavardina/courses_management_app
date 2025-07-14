package com.mp.myproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.myproject.entity.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {

	public Course findById(int theId);

}
