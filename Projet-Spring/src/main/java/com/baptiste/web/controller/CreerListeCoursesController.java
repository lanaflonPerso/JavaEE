package com.baptiste.web.controller;

import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.baptiste.web.bean.Course;
import com.baptiste.web.services.IServiceListeCourses;


@Controller
public class CreerListeCoursesController {
	@Autowired
	private IServiceListeCourses service;
	@RequestMapping(value="/afficherCreationListeCourses", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Course> lListeCourses = service.rechercherCourses();
		pModel.addAttribute("listeCourses", lListeCourses);
		if (pModel.get("modification") == null) {
			final ModificationForm lModificationForm = new ModificationForm();
			final List<ModificationCourse> lListe = new LinkedList<ModificationCourse>();
			for (final Course lCourse : lListeCourses) {
				final ModificationCourse lModificationCourse = new ModificationCourse();
				lModificationCourse.setId(lCourse.getId());
				lModificationCourse.setLibelle(lCourse.getLibelle());
				lModificationCourse.setQuantite(lCourse.getQuantite().toString());
				lListe.add(lModificationCourse);
			}
			lModificationForm.setListeCourses(lListe);
			pModel.addAttribute("modification", lModificationForm);
		}
		if (pModel.get("creation") == null) {
			pModel.addAttribute("creation", new CreationForm());
		}
		return "modification";
	}
	@RequestMapping(value="/creerCreationListeCourses", method = RequestMethod.POST)
	public String creer(
			@Valid @ModelAttribute(value="creation") final CreationForm pCreation,
			final BindingResult pBindingResult,
			final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			final Integer lIntQuantite = Integer.valueOf(pCreation.getQuantite());
			service.creerCourse(pCreation.getLibelle(), lIntQuantite);
		}
		return afficher(pModel);
	}
}