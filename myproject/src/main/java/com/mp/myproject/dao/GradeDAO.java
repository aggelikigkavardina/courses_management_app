package com.mp.myproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.myproject.entity.Grade;

@Repository
public interface GradeDAO extends JpaRepository<Grade, Integer> {

	public Grade findById(int theId);
}