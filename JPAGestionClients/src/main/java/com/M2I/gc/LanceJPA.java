package com.M2I.gc;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.M2I.gc.beans.Article;
import com.M2I.gc.beans.Clients;
import com.M2I.gc.beans.Facture;
import com.M2I.gc.beans.FactureDet;

public class LanceJPA {

	public static void main(String[] args) {
		EntityTransaction tx=null;
	    try {

	    	//Création de la Factory pour la persistence
	        EntityManagerFactory emf = EntityManagerHelper.getEntityManagerFactory();
	        //Récupération à partir de la Factory d'un EntityManager
	        EntityManager em = emf.createEntityManager();

	        //Sélectionne le client dont l'id est 1
	        Clients client = (Clients) em.find(Clients.class, 5);
	        
	        if(client != null)
	        {
	        	System.out.println("Trouvé :) !");
		        System.out.println(String.format("Nom Client: %s, Adresse: %s", client.getNom(), client.getAdresse()));
		        for(Facture fact : client.getFactureList())
		        {
		        	System.out.println(fact.getAdresseFacture());
		        	for(FactureDet fd : fact.getFacturesDet())
		        	{
		        		System.out.println("QTE : "+fd.getQteFact());
		        		System.out.println("PRIX : "+fd.getIdArticle().getTarif()+" €");
		        		System.out.println("Montant HT : "+ 
		        		(fd.getIdArticle().getTarif()*fd.getQteFact()+" €"));
		        	}
		        }
	        }
	        else
	        {
	        	//Si pas trouvé alors on crée un client 
	        	//c'est le SGBDR qui gére les id !!
	        	System.out.println("Création");
	        	tx=em.getTransaction();
	        	//Récupération d'une Transaction
	        	tx.begin();//Début de la transaction
	        	
	        	//Instanciation d'une entité client
	        	client = new Clients();
	        	Article art = new Article();
	        	FactureDet fd = new FactureDet();
	        	Facture fact = new Facture();
	        	//Affectation des données du client
	        	client.setAdresse("Rue Felix Viallet");
	        	client.setCdp("38000");
	        	client.setNom("2");
	        	client.setVille("Grenoble");
	        	client.setDatecreation(new Date());	        	
	        	//bloc article
	        	art.setDesignation("Glace au chocolat");
	        	art.setTarif(8.00);
	        	//bloc factDet
	        	fd.setIdArticle(art);
	        	fd.setQteFact(20);
	        	fd.setTva(0.2);
	        	fd.setIdFacture(fact);
	        	//bloc facture
	        	fact.setIdClient(client);
	        	fact.setAdresseFacture(client.getAdresse());
	        	fact.setDescription("Facture Glace Chocolat");
	        	fact.setMontantFacture(fd.getQteFact()*fd.getIdArticle().getTarif()*(1+fd.getTva()));
	        	fact.setPayerFacture(false);
	        

	        	em.persist(client);//insert
	        	em.persist(art);
	        	em.persist(fact);
	        	em.persist(fd);
	        	
	        	tx.commit();//Valide la transaction
	        	
	        }
	        //Gestion Requêtes
	        GestionRequetes gr = new GestionRequetes(em);
	        System.out.println("Factures Non Payées : "+gr.findAllFacturePasPayees().size());
	        for(Facture fa : gr.findAllFacturePasPayees())
	        {
	        	System.out.println(fa.getId()+"-"+fa.getAdresseFacture());
	        }
	        System.out.println("Nombre des Clients : "+gr.findAllClients().size());
	        
	        for(Clients cl : gr.findAllClients())
	        {
	        	System.out.println(cl.getId()+"-"+cl.getNom());
	        }
	        
	        em.close();//ferme l'entité manager

	    } catch (Exception e) {
	        e.printStackTrace();
	        if(tx!=null) tx.rollback();
	        //s'il y a eu une transaction on fait un roolback
	        //pour annuler toutes commandes orphelines
	    }


	}

}
