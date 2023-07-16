package App;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.CatalogoDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;
import entities.Catalogo;
import entities.Libri;
import entities.Periodicita;
import entities.Prestito;
import entities.Riviste;
import entities.Utente;
import util.JpaUtil;

public class App {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();

		CatalogoDAO cd = new CatalogoDAO(em);

		Set<Catalogo> catalogo = new HashSet<>();

		Libri libro1 = new Libri(11111L, "Harry Potter", LocalDate.of(1925, 8, 2), 328, "Autore1", "Fantasy");
		Libri libro2 = new Libri(22222L, "Il Signore degli Anelli: La Compagnia dell'Anello", LocalDate.of(2008, 5, 13),
				850, "J.R.R. Tolkien", "Fantasy");
		Libri libro3 = new Libri(33333L, "Orgoglio e pregiudizio", LocalDate.of(1925, 6, 25), 416, "Jane Austen",
				"Romanzo romantico");

		Riviste rivista1 = new Riviste(44444L, "National Geographic", LocalDate.of(1888, 10, 1), 150,
				Periodicita.MENSILE);
		Riviste rivista2 = new Riviste(55555L, "Vanity Fair", LocalDate.of(1913, 9, 1), 100, Periodicita.SEMESTRALE);
		Riviste rivista3 = new Riviste(66666L, "Focus", LocalDate.of(1992, 1, 1), 80, Periodicita.MENSILE);

		catalogo.add(libro1);
		catalogo.add(libro2);
		catalogo.add(libro3);
		catalogo.add(rivista1);
		catalogo.add(rivista2);
		catalogo.add(rivista3);

		catalogo.forEach(el -> {
			cd.save(el);
		});

		cd.removeItem(11111L);

		Catalogo findIsbn = cd.findByIsbn(55555L);
		if (findIsbn != null) {
			System.out.println("Elemento trovato: \n" + findIsbn);
		} else {
			System.out.println("Elemento non trovato");
		}

		List<Catalogo> findAnno = cd.findByYear(2008);
		if (!findAnno.isEmpty()) {
			System.out.println("Elementi trovati:");
			for (Catalogo elementi : findAnno) {
				System.out.println(elementi);
			}
		} else {
			System.out.println("Nessun elemento trovato");
		}

		List<Catalogo> findAutore = cd.findByAuthor("J.R.R. Tolkien");
		if (!findAutore.isEmpty()) {
			System.out.println("Elementi trovati:");
			for (Catalogo elementi : findAutore) {
				System.out.println(elementi);
			}
		} else {
			System.out.println("Nessun elemento trovato");
		}

		List<Catalogo> findTitolo = cd.findByTitle("Orgoglio e pregiudizio");
		if (!findTitolo.isEmpty()) {
			System.out.println("Elementi trovati:");
			for (Catalogo elementi : findTitolo) {
				System.out.println(elementi);
			}
		} else {
			System.out.println("Nessun elemento trovato");
		}

		UtenteDAO ud = new UtenteDAO(em);
		Utente utente1 = new Utente("Giuseppe", "Petrucci", LocalDate.of(1995, 2, 20), "65516");
		Utente utente2 = new Utente("Antonio", "Abate", LocalDate.of(1998, 10, 7), "65151");

		ud.save(utente1);
		ud.save(utente2);

		PrestitoDAO pd = new PrestitoDAO(em);
		Prestito prestito1 = new Prestito(utente1, LocalDate.now(), LocalDate.now().plusDays(14), null);
		Prestito prestito2 = new Prestito(utente1, LocalDate.now(), LocalDate.now().plusDays(14), null);

		pd.save(prestito1);
		pd.save(prestito2);

		Set<Prestito> prestitiByNumeroTessera = pd.findPrestitiByNumeroTessera("65151");
		if (!prestitiByNumeroTessera.isEmpty()) {
			System.out.println("Prestiti trovati per il numero di tessera 65151:");
			for (Prestito prestito : prestitiByNumeroTessera) {
				System.out.println(prestito);
			}
		} else {
			System.out.println("Nessun prestito trovato per il numero di tessera 65151.");
		}

		Set<Prestito> prestitiScaduti = pd.findPrestitiScaduti();

		if (!prestitiScaduti.isEmpty()) {
			System.out.println("Prestiti scaduti e non restituiti:");
			for (Prestito prestito : prestitiScaduti) {
				System.out.println(prestito);
			}
		} else {
			System.out.println("Nessun prestito scaduto e non restituito.");
		}

	}

}