package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Riviste extends Catalogo {
	private Periodicita periodicita;

	public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

}
