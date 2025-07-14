package com.mp.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mp.myproject.entity.Course;
import com.mp.myproject.service.CourseService;

@Controller
@RequestMapping("/courses")
//@SessionAttributes("courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listCourses(Model theModel) {

		// get courses from db
		List<Course> courses = courseService.findAll();

		// add to the spring model
		theModel.addAttribute("courses", courses);

		/*
		 * Simple test this is how to get the name of the person logged in to be used
		 * for other purposes Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication(); String
		 * currentPrincipalName = authentication.getName();
		 * System.out.println(currentPrincipalName);
		 */

		return "courses/list-courses";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Course course = new Course();

		theModel.addAttribute("course", course);

		return "courses/course-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId, Model theModel) {

		// get the course from the service
		Course theCourse = courseService.findById(theId);

		// set course as a model attribute to pre-populate the form
		theModel.addAttribute("course", theCourse);

		// send over to our form
		return "courses/course-form";
	}

	@RequestMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse, Model theModel) {

		// save the course
		courseService.save(theCourse);

		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {

		// delete the course
		courseService.deleteById(theId);

		// redirect to /courses/list
		return "redirect:/courses/list";

	}
}
