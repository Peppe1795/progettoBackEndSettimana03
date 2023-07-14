package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Libri")
@NoArgsConstructor
@Getter
@Setter
public class Libri extends Catalogo {
	private String autore;
	private String genere;

	public Libri(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}
}
