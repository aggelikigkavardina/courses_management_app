package com.mp.myproject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "registration_year")
	private Integer registrationYear;

	@Column(name = "semester")
	private Integer semester;

	@ManyToMany(mappedBy = "students", cascade = { CascadeType.ALL })
	private Set<Course> courses = new HashSet<Course>();

	public Student() {

	}

	public Student(int id, String name, Integer registrationYear, Integer semester) {
		super();
		this.id = id;
		this.name = name;
		this.registrationYear = registrationYear;
		this.semester = semester;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(Integer registrationYear) {
		this.registrationYear = registrationYear;
	}

	public Integer getSemester() {
		return semester;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

}
