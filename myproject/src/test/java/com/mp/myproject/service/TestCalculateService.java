package com.mp.myproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mp.myproject.entity.Grade;

public class TestCalculateService {

	@Test
	void testCalculateFinalScore() {
		Grade grade = new Grade();

		CalculateService cs = new CalculateService();

		Assertions.assertNull(cs.calculateFinalScore(grade));

		grade.setProject(6);

		Assertions.assertEquals(6, cs.calculateFinalScore(grade));

		grade.setFinalExam(5);
		grade.setProject(null);

		Assertions.assertEquals(5, cs.calculateFinalScore(grade));

		grade.setFinalExam(4);
		grade.setProject(8);

		Assertions.assertEquals(6, cs.calculateFinalScore(grade));

		grade.setProjectWeight(20);

		Assertions.assertEquals(4.8, cs.calculateFinalScore(grade));
	}
}
