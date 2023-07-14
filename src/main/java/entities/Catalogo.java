package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class Catalogo {
	@Id
	@GeneratedValue
	protected long IBSN;
	protected String titolo;
	protected int annoPubblicazione;
	protected int numeroPagine;

	public Catalogo(String titolo, int annoPubblicazione, int numeroPagine) {
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

}
