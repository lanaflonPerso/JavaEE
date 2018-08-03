package com.M2I.gc.beans;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TArticle",schema="dbo")
public class Article {

	@Id
 	@Column(name="IdArticle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="DesignationArticle", nullable=false)
    private String designation;

    @Column(name="Tarifunitaire", nullable=false)
    private double tarif;
	
    @OneToMany(mappedBy="idArticle")
    private List<FactureDet> factureDetList;
    
    public List<FactureDet> getFactureDetList(){
    	return factureDetList;
    }
    
    public double getTarif() {
    	return this.tarif;
    }
    
    public void setTarif(double tarif) {
    	this.tarif=tarif;
    }
    
    public String getDesignation() {
    	return this.designation;
    }
    
    public void setDesignation(String designation) {
    	this.designation=designation;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
