package com.mp.myproject.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mp.myproject.entity.Course;
import com.mp.myproject.entity.Grade;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TestStatisticService {

	@Autowired
	StatisticService statisticService;
	
	@Test
	void testStatisticService() {
		Grade grade1 = new Grade();
		grade1.setProject(4);
		Grade grade2 = new Grade();
		grade2.setProject(6);
		Grade grade3 = new Grade();
		grade3.setProject(8);
		
		Set<Grade> grades = new HashSet<Grade>();
		grades.add(grade1);
		grades.add(grade2);
		grades.add(grade3);
		
		Course course = new Course();
		course.setGrades(grades);
		
		Assertions.assertEquals(4, statisticService.min(course));
		Assertions.assertEquals(8, statisticService.max(course));
		Assertions.assertEquals(6, statisticService.mean(course));
	}
}
