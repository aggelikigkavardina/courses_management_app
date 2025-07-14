package com.mp.myproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.mp.myproject.entity.Course;
import com.mp.myproject.service.CourseService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
class TestCourseController {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	CourseController courseController;

	@Autowired
	CourseService courseService;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void testCourseControllerIsNotNull() {
		Assertions.assertNotNull(courseController);
	}

	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}

	@WithMockUser(value = "admin")
	@Test
	void testListCoursesReturnsPage() throws Exception {
		mockMvc.perform(get("/courses/list")).andExpect(status().isOk()).andExpect(model().attributeExists("courses"))
				.andExpect(view().name("courses/list-courses"));
	}

	@WithMockUser(value = "admin")
	@Test
	void testSaveCourseReturnsPage() throws Exception {

		Course course = new Course();
		course.setName("Mathima");

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("id", Integer.toString(course.getId()));
		multiValueMap.add("name", course.getName());

		mockMvc.perform(post("/courses/save").params(multiValueMap)).andExpect(status().isFound())
				.andExpect(view().name("redirect:/courses/list"));
	}

	@WithMockUser(value = "admin")
	@Test
	void testDeleteReturnsPage() throws Exception {
		Course course = new Course();
		course.setName("Mathima");
		courseService.save(course);

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("courseId", Integer.toString(course.getId()));

		mockMvc.perform(post("/courses/delete").params(multiValueMap)).andExpect(status().isFound())
				.andExpect(view().name("redirect:/courses/list"));
	}

	@WithMockUser(value = "admin")
	@Test
	void testShowFormForAddReturnsPage() throws Exception {
		mockMvc.perform(get("/courses/showFormForAdd")).andExpect(status().isOk())
				.andExpect(view().name("courses/course-form"));
	}

	@WithMockUser(value = "admin")
	@Test
	void testShowFormForUpdateReturnsPage() throws Exception {
		int courseId = 1;

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("courseId", Integer.toString(courseId));

		mockMvc.perform(get("/courses/showFormForUpdate").params(multiValueMap)).andExpect(status().isOk())
				.andExpect(view().name("courses/course-form"));
	}

}
