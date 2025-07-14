package com.mp.myproject.service;

import java.util.List;

import com.mp.myproject.entity.Grade;

public interface GradeService {

	public List<Grade> findAll();

	public Grade findById(int theId);

	public void save(Grade theCourse);

	public void deleteById(int theId);

}
