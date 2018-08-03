package com.M2I.gc.beans;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "TFacture",schema="dbo")
@NamedQueries({
@NamedQuery( name = "Facture.findPayeAll",
query = "SELECT FACT FROM Facture AS FACT where payerFacture=1" ),
@NamedQuery( name = "Facture.findNonPayeAll",
query = "SELECT FACT FROM Facture AS FACT where payerFacture=0" )

})
public class Facture {
	
	@Id
 	@Column(name="IdFacture")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdClient")
	private Clients idClient;
	
	@OneToMany(mappedBy="idFacture")
	private List<FactureDet> factureDetList;	    
	
	@Column(name="AdresseFacture")
	private String adresse;
	
	@Column(name="MontantFacture", nullable=false)
	private double montant;
	
	@Column(name="Description", nullable=false)
	private String description;
	
	@Column(name="PayerFacture")
	private boolean payerFacture;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id= id;
	}
	
	public Clients getIdClient() {
		return this.idClient;
	}
	
	public List<FactureDet> getFacturesDet() {
		return factureDetList;
	}
	
	public void setIdClient(Clients idClient) {
		this.idClient = idClient;
	}
	
	public String getAdresseFacture() {
		return this.adresse;
	}
	
	public void setAdresseFacture(String adresse) {
		this.adresse = adresse;
	}
	
	public double getMontantFacture() {
		return this.montant;
	}
	
	public void setMontantFacture(double montant) {
		this.montant = montant;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isPayerFacture() {
		return this.payerFacture;
	}
	
	public void setPayerFacture(boolean payer) {
		this.payerFacture = payer;
	}
}
