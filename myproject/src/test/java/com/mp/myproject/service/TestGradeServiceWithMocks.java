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

import com.mp.myproject.dao.GradeDAO;
import com.mp.myproject.entity.Course;
import com.mp.myproject.entity.Grade;
import com.mp.myproject.entity.Student;

//@SpringBootTest 
//@TestPropertySource(
//locations = "classpath:application.properties")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class TestGradeServiceWithMocks {

	@TestConfiguration
	static class GradeServiceImplTestContextConfiguration {

		@Bean
		public GradeService gradeService() {
			return new GradeServiceImpl();
		}
	}

	@Autowired
	GradeService gradeService;

	@MockBean
	GradeDAO gradeDAO;

	@Test
	void testGradeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(gradeService);
	}

	@Test
	void testFindByIdReturnsGrade() {
		Student student = new Student();
		student.setId(312);
		Course course = new Course();
		course.setId(502);
		Mockito.when(gradeDAO.findById(1)).thenReturn(new Grade(35, 5, 6, 30, student, course));
		Grade storedGrade = gradeService.findById(1);
		Assertions.assertNotNull(storedGrade);
		Assertions.assertEquals(502, storedGrade.getCourse().getId());
		Assertions.assertEquals(312, storedGrade.getStudent().getId());
		Assertions.assertEquals(5, storedGrade.getFinalExam());
		Assertions.assertEquals(6, storedGrade.getProject());
		Assertions.assertEquals(30, storedGrade.getProjectWeight());
	}
}
