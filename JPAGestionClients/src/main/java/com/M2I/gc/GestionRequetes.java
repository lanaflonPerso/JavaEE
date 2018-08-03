package com.M2I.gc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.M2I.gc.beans.Clients;
import com.M2I.gc.beans.Facture;

public class GestionRequetes {
	
	private EntityManager em =null;
	
	public GestionRequetes(EntityManager pem) {
		super();
		em = pem;
		// TODO Auto-generated constructor stub
	}

	public List<Facture> findAllFacturePayees(){
		Query query = em.createNamedQuery( "Facture.findPayeAll" );
		List<Facture> facture = query.getResultList();
		return (facture);
		}
	
	public List<Facture> findAllFacturePasPayees(){
		Query query = em.createNamedQuery( "Facture.findNonPayeAll" );
		List<Facture> facture = query.getResultList();
		return (facture);
		}

	public List<Clients> findAllClients(){
		Query query = em.createQuery( "select cl from Clients cl" );
		List<Clients> clients = query.getResultList();
		return (clients);
		}
	
}