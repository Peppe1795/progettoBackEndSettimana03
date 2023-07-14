package entities;

import lombok.Getter;
import lombok.Setter;

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
