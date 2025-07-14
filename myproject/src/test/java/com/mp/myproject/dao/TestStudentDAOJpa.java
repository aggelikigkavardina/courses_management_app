package com.mp.myproject.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mp.myproject.entity.Student;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class TestStudentDAOJpa {
	@Autowired
	StudentDAO studentDAO;

	@Test
	void testStudentDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentDAO);
	}

	@Test
	void testFindByIdReturnsStudent() {
		Student storedStudent = studentDAO.findById(1);
		Assertions.assertNotNull(storedStudent);
		Assertions.assertEquals("Makis Tsikos", storedStudent.getName());
		Assertions.assertEquals(2002, storedStudent.getRegistrationYear());
		Assertions.assertEquals(5, storedStudent.getSemester());
	}
}
