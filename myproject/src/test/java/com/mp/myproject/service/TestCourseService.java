package com.mp.myproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mp.myproject.entity.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class TestCourseService {

	@Autowired
	CourseService courseService;

	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}

	@Test
	void testFindByIdReturnsEmployee() {
		Course storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Discrete Mathematics", storedCourse.getName());
		Assertions.assertEquals("syl1", storedCourse.getSyllabus());
		Assertions.assertEquals(2021, storedCourse.getYear());
		Assertions.assertEquals(2, storedCourse.getSemester());
	}
}
