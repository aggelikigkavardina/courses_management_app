package com.mp.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mp.myproject.entity.Course;
import com.mp.myproject.entity.Grade;
import com.mp.myproject.entity.Student;
import com.mp.myproject.service.CourseService;
import com.mp.myproject.service.GradeService;
import com.mp.myproject.service.StudentService;

@Controller
@RequestMapping("/students")
//@SessionAttributes("students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private GradeService gradeService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(@RequestParam("courseId") int courseId, Model theModel) {

		Course course = courseService.findById(courseId);

		theModel.addAttribute("course", course);

		return "students/list-students";
	}

	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("grade") Grade grade, Model theModel) {

		Course course = grade.getCourse();
		Student student = grade.getStudent();

		studentService.save(student);
		gradeService.save(grade);

		theModel.addAttribute("course", course);

		return "students/list-students";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("gradeId") int gradeId, Model theModel) {

		Grade grade = gradeService.findById(gradeId);
		Student student = grade.getStudent();
		Course course = grade.getCourse();

		gradeService.deleteById(gradeId);
		studentService.deleteById(student.getId());

		theModel.addAttribute("course", course);

		return "students/list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("courseId") int courseId, Model theModel) {

		Grade grade = new Grade();
		Student student = new Student();
		Course course = courseService.findById(courseId);
		grade.setStudent(student);
		grade.setCourse(course);

		theModel.addAttribute("grade", grade);

		return "students/student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("gradeId") int gradeId, Model theModel) {

		Grade grade = gradeService.findById(gradeId);

		theModel.addAttribute("grade", grade);

		return "students/student-form";
	}

	@RequestMapping("/showStatistics")
	public String showStatistics(@RequestParam("courseId") int courseId, Model theModel) {

		Course course = courseService.findById(courseId);

		theModel.addAttribute("course", course);

		return "students/course-statistics";
	}

}
