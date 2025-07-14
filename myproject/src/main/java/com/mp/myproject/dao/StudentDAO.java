package com.mp.myproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.myproject.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

	public Student findById(int theId);

}
