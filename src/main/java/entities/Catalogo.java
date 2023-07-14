package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "Catalogo")
@NoArgsConstructor
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
