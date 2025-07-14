package com.mp.myproject.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mp.myproject.entity.Grade;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class TestGradeDAOJpa {
	@Autowired
	GradeDAO gradeDAO;

	@Test
	void testGradeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(gradeDAO);
	}

	@Test
	void testFindByIdReturnsGrade() {
		Grade storedGrade = gradeDAO.findById(1);
		Assertions.assertNotNull(storedGrade);
		Assertions.assertEquals(1, storedGrade.getCourse().getId());
		Assertions.assertEquals(1, storedGrade.getStudent().getId());
		Assertions.assertEquals(6, storedGrade.getFinalExam());
		Assertions.assertEquals(9, storedGrade.getProject());
		Assertions.assertEquals(20, storedGrade.getProjectWeight());
	}
}
