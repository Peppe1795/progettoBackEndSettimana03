package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Riviste")
@NoArgsConstructor
@Getter
@Setter
public class Riviste extends Catalogo {
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

}
