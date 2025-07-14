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

import com.mp.myproject.dao.StudentDAO;
import com.mp.myproject.entity.Student;

//@SpringBootTest 
//@TestPropertySource(
//locations = "classpath:application.properties")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class TestStudentServiceWithMocks {

	@TestConfiguration
	static class StudentServiceImplTestContextConfiguration {

		@Bean
		public StudentService studentService() {
			return new StudentServiceImpl();
		}
	}

	@Autowired
	StudentService studentService;

	@MockBean
	StudentDAO studentDAO;

	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}

	@Test
	void testFindByIdReturnsStudent() {
		Mockito.when(studentDAO.findById(1)).thenReturn(new Student(301, "Kitsos", 2040, 11));
		Student storedStudent = studentService.findById(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Kitsos", storedStudent.getName());
		Assertions.assertEquals(2040, storedStudent.getRegistrationYear());
		Assertions.assertEquals(11, storedStudent.getSemester());
	}
}
