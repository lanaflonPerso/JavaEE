package com.baptiste.web.controller;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class CreationForm {
	@NotEmpty		//Le string doit être non vide
	private String libelle;
	@NotEmpty
	@Pattern(regexp="\\d*")	//Le string doit être de la forme décimale
	private String quantite;
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(final String pLibelle) {
		libelle = pLibelle;
	}
	
	public String getQuantite() {
		return quantite;
	}
	
	public void setQuantite(final String pQuantite) {
		quantite = pQuantite;
	}
}