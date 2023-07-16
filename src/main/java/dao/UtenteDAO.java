package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Utente;

public class UtenteDAO {

	private final EntityManager em;

	public UtenteDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Utente utente) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(utente);

		t.commit();

		System.out.println("Utente salvato");
	}

}