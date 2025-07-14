package com.mp.myproject.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import com.mp.myproject.entity.Grade;

@Component("calculateService")
public class CalculateService {

	public Double calculateFinalScore(Grade grade) {
		Integer project = grade.getProject();
		Integer finalExam = grade.getFinalExam();
		Integer projectWeight = grade.getProjectWeight();

		if (project == null && finalExam == null) {
			return null;
		} else if (project == null) {
			return finalExam / 1.0;
		} else if (finalExam == null) {
			return project / 1.0;
		} else if (projectWeight == null) {
			return Precision.round(project * 0.5 + finalExam * 0.5, 2);
		} else {
			return Precision.round(project * projectWeight * 0.01 + finalExam * (1 - projectWeight * 0.01), 2);
		}
	}
}
