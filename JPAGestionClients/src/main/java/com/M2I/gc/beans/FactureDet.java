package com.M2I.gc.beans;

import javax.persistence.*;

@Entity
@Table(name = "TFactureDet",schema="dbo")
public class FactureDet {

	@Id
	@Column(name="IdFactDet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idFacture")
	private Facture idFacture;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idArticle")
	private Article idArticle;
	
	@Column(name="QteFact",nullable=false)
	private int qteFact;
	
	@Column(name="txTva")
	private double tva;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Facture getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Facture idFacture) {
		this.idFacture = idFacture;
	}

	public Article getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Article idArticle) {
		this.idArticle = idArticle;
	}

	public int getQteFact() {
		return qteFact;
	}

	public void setQteFact(int qteFact) {
		this.qteFact = qteFact;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double d) {
		this.tva = d;
	}


}

