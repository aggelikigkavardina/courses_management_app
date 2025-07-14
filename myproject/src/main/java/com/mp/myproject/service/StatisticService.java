package com.mp.myproject.service;

import java.util.Set;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mp.myproject.entity.Course;
import com.mp.myproject.entity.Grade;

@Component("statisticService")
public class StatisticService {

	@Autowired
	private CalculateService calculateService;

	public double min(Course course) {
		Set<Grade> grades = course.getGrades();

		if (grades.isEmpty()) {
			return 0;
		}
		Double minScore = calculateService.calculateFinalScore(grades.iterator().next());

		for (Grade grade : grades) {
			Double gradeScore = calculateService.calculateFinalScore(grade);
			if (minScore == null) {
				minScore = gradeScore;
			} else if (gradeScore != null) {
				if (minScore > gradeScore) {
					minScore = gradeScore;
				}
			}
		}
		return minScore;
	}

	public double max(Course course) {
		Set<Grade> grades = course.getGrades();

		if (grades.isEmpty()) {
			return 0;
		}

		Double maxScore = calculateService.calculateFinalScore(grades.iterator().next());

		for (Grade grade : grades) {
			Double gradeScore = calculateService.calculateFinalScore(grade);
			if (maxScore == null) {
				maxScore = gradeScore;
			} else if (gradeScore != null) {
				if (maxScore < gradeScore) {
					maxScore = gradeScore;
				}
			}
		}
		return maxScore;
	}

	public double mean(Course course) {
		Set<Grade> grades = course.getGrades();

		if (grades.isEmpty()) {
			return 0;
		}

		Double meanScore = 0.0;

		for (Grade grade : grades) {
			Double gradeScore = calculateService.calculateFinalScore(grade);
			if (gradeScore != null) {
				meanScore += gradeScore;
			}
		}
		meanScore = meanScore / grades.size();

		return Precision.round(meanScore, 2);
	}
}
