package com.mp.myproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mp.myproject.dao.CourseDAO;
import com.mp.myproject.entity.Course;

//@SpringBootTest 
//@TestPropertySource(
//  locations = "classpath:application.properties")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class TestCourseServiceWithMocks {

	@TestConfiguration
	static class CourseServiceImplTestContextConfiguration {

		@Bean
		public CourseService courseService() {
			return new CourseServiceImpl();
		}
	}

	@Autowired
	CourseService courseService;

	@MockBean
	CourseDAO courseDAO;

	@Test
	void testCourseDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}

	@Test
	void testFindByIdReturnsCourse() {
		Mockito.when(courseDAO.findById(1)).thenReturn(new Course(52, "Mathima", "s", 1990, 2));
		Course storedCourse = courseService.findById(1);
		Assertions.assertNotNull(storedCourse);
		Assertions.assertEquals("Mathima", storedCourse.getName());
		Assertions.assertEquals("s", storedCourse.getSyllabus());
		Assertions.assertEquals(1990, storedCourse.getYear());
		Assertions.assertEquals(2, storedCourse.getSemester());
	}
}
