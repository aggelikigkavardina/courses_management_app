package com.mp.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mp.myproject.dao.GradeDAO;
import com.mp.myproject.entity.Grade;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDAO gradeRepository;

	public GradeServiceImpl() {
		super();
	}

	@Autowired
	public GradeServiceImpl(GradeDAO theGradeRepository) {
		gradeRepository = theGradeRepository;
	}

	@Override
	@Transactional
	public List<Grade> findAll() {
		return gradeRepository.findAll();
	}

	@Override
	@Transactional
	public Grade findById(int theId) {
		Grade result = gradeRepository.findById(theId);

		if (result != null) {
			return result;
		} else {
			// we didn't find the grade
			throw new RuntimeException("Did not find grade id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Grade theGrade) {
		gradeRepository.save(theGrade);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		gradeRepository.deleteById(theId);
	}
}
