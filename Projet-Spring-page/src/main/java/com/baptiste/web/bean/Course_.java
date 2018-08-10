package com.baptiste.web.bean;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Course.class)
public class Course_ {

	public static volatile SingularAttribute<Course, Integer> id;
	public static volatile SingularAttribute<Course, String> libelle;
	public static volatile SingularAttribute<Course, Integer> quantite;
	
}
