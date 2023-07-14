package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Utente")
@NoArgsConstructor
@Getter
@Setter
public class Utente {

	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private long numeroDiTessera;

	public Utente(String nome, String cognome, LocalDate dataDiNascita, long numeroDiTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTessera = numeroDiTessera;
	}

}
