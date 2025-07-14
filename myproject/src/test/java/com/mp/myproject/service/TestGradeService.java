package com.mp.myproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mp.myproject.entity.Grade;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class TestGradeService {

	@Autowired
	GradeService gradeService;

	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(gradeService);
	}

	@Test
	void testFindByIdReturnsEmployee() {
		Grade storedGrade = gradeService.findById(1);
		Assertions.assertNotNull(storedGrade);
		Assertions.assertEquals(1, storedGrade.getCourse().getId());
		Assertions.assertEquals(1, storedGrade.getStudent().getId());
		Assertions.assertEquals(6, storedGrade.getFinalExam());
		Assertions.assertEquals(9, storedGrade.getProject());
		Assertions.assertEquals(20, storedGrade.getProjectWeight());
	}
}
