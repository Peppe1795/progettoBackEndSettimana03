package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Catalogo")
@NoArgsConstructor
@Getter
@Setter
public class Prestito {
	@Id
	@GeneratedValue
	private UUID idPrestito;
	private String utente;
	private Catalogo elementoPrestato;
	private LocalDate inizioPrestito;
	private LocalDate dataRestituzionePrevista; // (calcolata automaticamente a 30 gg dalla data inizio prestito)
	private LocalDate restituzioneEffettiva;

	public Prestito(String utente, Catalogo elementoPrestato, LocalDate inizioPrestito,
			LocalDate dataRestituzionePrevista, LocalDate restituzioneEffettiva) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.inizioPrestito = inizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

}
