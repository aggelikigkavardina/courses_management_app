package com.mp.myproject.service;

import java.util.List;

import com.mp.myproject.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theStudent);

	public void deleteById(int theId);

}
