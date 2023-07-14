package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Catalogo;

public class CatalogoDAO {

	private final EntityManager em;

	public CatalogoDAO(EntityManager em) {

		this.em = em;
	}

	public void removeItem(long isbn) {
		Catalogo found = em.find(Catalogo.class, isbn);

		if (found != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(found);
			t.commit();

			System.out.println("Elemnto del catalogo eliminato correttamente");
		} else {
			System.out.println("Il codice IBSN che hai inserito non corrisponde a nessun elemento dell'archivio");
		}

	}

	public Catalogo findByIsbn(long isbn) {
		Catalogo found = em.find(Catalogo.class, isbn);
		return found;
	}

	public Catalogo findByYear(int annoDiPubblicazione) {

	}

	public Catalogo findByAuthor(String autore) {

	}
}
