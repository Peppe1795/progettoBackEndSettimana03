package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Catalogo;

public class CatalogoDAO {

	private final EntityManager em;

	public CatalogoDAO(EntityManager em) {

		this.em = em;
	}

	public void save(Catalogo s) {

		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Elemento Salvato correttamente!!!!!");
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

	public Catalogo findByIsbn(Long isbn) {
		TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.isbn = :isbn", Catalogo.class);
		query.setParameter("isbn", isbn);
		List<Catalogo> result = query.getResultList();

		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public List<Catalogo> findByYear(int annoPubblicazione) {
		TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE YEAR(c.annoPubblicazione) = :anno",
				Catalogo.class);
		query.setParameter("anno", annoPubblicazione);
		return query.getResultList();

	}

	public List<Catalogo> findByAuthor(String autore) {
		String queryString = "SELECT c FROM Catalogo c WHERE TYPE(c) = Libri AND c.autore = :autore";
		TypedQuery<Catalogo> query = em.createQuery(queryString, Catalogo.class);
		query.setParameter("autore", autore);
		return query.getResultList();
	}

	public List<Catalogo> findByTitle(String titolo) {
		TypedQuery<Catalogo> query = em
				.createQuery("SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE LOWER(:titolo)", Catalogo.class);
		query.setParameter("titolo", "%" + titolo + "%");
		return query.getResultList();
	}
}
