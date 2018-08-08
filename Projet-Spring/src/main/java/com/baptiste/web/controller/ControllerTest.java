package com.baptiste.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/control")
public class ControllerTest {

	@RequestMapping(method=RequestMethod.POST)
	public String afficherNom(
			final ModelMap pModel,
			@RequestParam("personne") final String pPersonne,
			@RequestParam("metier") final String pMetier)
	{
		pModel.addAttribute("personne", pPersonne);
		pModel.addAttribute("metier", pMetier);
		return "welcome";
	}
}
