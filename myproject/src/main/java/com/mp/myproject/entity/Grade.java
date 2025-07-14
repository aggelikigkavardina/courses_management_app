package com.mp.myproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grade")
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "final_exam")
	private Integer finalExam;

	@Column(name = "project")
	private Integer project;

	@Column(name = "project_weight")
	private Integer projectWeight;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public Grade() {

	}

	public Grade(int id, Integer finalExam, Integer project, Integer projectWeight, Student student, Course course) {
		super();
		this.id = id;
		this.finalExam = finalExam;
		this.project = project;
		this.projectWeight = projectWeight;
		this.student = student;
		this.course = course;
	}

	public Grade(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(Integer finalExam) {
		this.finalExam = finalExam;
	}

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getProjectWeight() {
		return projectWeight;
	}

	public void setProjectWeight(Integer projectWeight) {
		this.projectWeight = projectWeight;
	}
}
