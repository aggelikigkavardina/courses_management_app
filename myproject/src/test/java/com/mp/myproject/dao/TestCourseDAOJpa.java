package com.mp.myproject.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mp.myproject.entity.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class TestCourseDAOJpa {
	@Autowired
	CourseDAO courseDAO;

	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseDAO);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Course storedCourse = courseDAO.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Discrete Mathematics", storedCourse.getName());
		Assertions.assertEquals("syl1", storedCourse.getSyllabus());
		Assertions.assertEquals(2021, storedCourse.getYear());
		Assertions.assertEquals(2, storedCourse.getSemester());
	}
}
