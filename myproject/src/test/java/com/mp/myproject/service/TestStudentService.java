package com.mp.myproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mp.myproject.entity.Student;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class TestStudentService {

	@Autowired
	StudentService studentService;

	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentService);
	}

	@Test
	void testFindByIdReturnsEmployee() {
		Student storedStudent = studentService.findById(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Makis Tsikos", storedStudent.getName());
		Assertions.assertEquals(2002, storedStudent.getRegistrationYear());
		Assertions.assertEquals(5, storedStudent.getSemester());
	}
}
