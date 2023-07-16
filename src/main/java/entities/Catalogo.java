package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Catalogo")
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Catalogo {
	@Id
	protected long isbn;

	private String titolo;
	private LocalDate annoPubblicazione;
	private int numeroPagine;

	public Catalogo(Long isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

}
