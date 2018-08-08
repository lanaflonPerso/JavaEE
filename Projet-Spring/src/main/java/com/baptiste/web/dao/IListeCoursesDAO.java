package com.baptiste.web.dao;

import java.util.List;

import com.baptiste.web.bean.Course;

public interface IListeCoursesDAO {
	List<Course> rechercherCourses();

	void creerCourse(final Course pCourse);
	void supprimerCourse(final Course pCourse);
	void modifierCourse(final Course pCourse);
}