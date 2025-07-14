package com.mp.myproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.mp.myproject.service.GradeService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
class TestStudentController {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	StudentController studentController;

	@Autowired
	GradeService gradeService;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void testStudentControllerIsNotNull() {
		Assertions.assertNotNull(studentController);
	}

	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}

	@WithMockUser(value = "admin")
	@Test
	void testListStudentsReturnsPage() throws Exception {

		int courseId = 1;

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("courseId", Integer.toString(courseId));

		mockMvc.perform(get("/students/list").params(multiValueMap)).andExpect(status().isOk())
				.andExpect(view().name("students/list-students"));
	}

	@WithMockUser(value = "admin")
	@Test
	void testShowFormForAddReturnsPage() throws Exception {

		int courseId = 1;

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("courseId", Integer.toString(courseId));

		mockMvc.perform(get("/students/showFormForAdd").params(multiValueMap)).andExpect(status().isOk())
				.andExpect(model().attributeExists("grade")).andExpect(view().name("students/student-form"));
	}

	@WithMockUser(value = "admin")
	@Test
	void testShowFormForUpdateReturnsPage() throws Exception {

		int gradeId = 1;

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("gradeId", Integer.toString(gradeId));

		mockMvc.perform(get("/students/showFormForUpdate").params(multiValueMap)).andExpect(status().isOk())
				.andExpect(model().attributeExists("grade")).andExpect(view().name("students/student-form"));
	}

}
