package com.M2I.gc.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Tclients",schema="dbo")
public class Clients {
	 	@Id
	 	@Column(name="IdClient")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	
	 	@Column(name="NomClient",nullable=true)
	    private String nom;

	    @Column(name="AdresseClient")
	    private String adresse;

	    @Column(name="VilleClient")
	    private String ville;

	    @Column(name="CdpClient")
	    private String cdp;
	    
	    @Column(name="DateCreationClient")
	    @Temporal(TemporalType.DATE)
	    private Date datecreation;

	    @OneToMany(mappedBy="idClient")
	    private List<Facture> factureList;
	    
	    public List<Facture> getFactureList(){
	    	return factureList;
	    }
	    
	    
		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getCdp() {
			return cdp;
		}

		public void setCdp(String cdp) {
			this.cdp = cdp;
		}

		public Date getDatecreation() {
			return datecreation;
		}

		public void setDatecreation(Date datecreation) {
			this.datecreation = datecreation;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


}
