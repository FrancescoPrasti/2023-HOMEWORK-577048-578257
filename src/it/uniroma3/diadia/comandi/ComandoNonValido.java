package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{

	//private String parametro;
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando sconosciuto");  //Stampa se l'utente mette qualche comando diverso dagli ammissibili (compreso il semplice tasto invio).
	}
	
	/*@Override
	public void setParametro(String parametro) {
		this.parametro = null;
	}*/
	
	@Override
	public String getNome() {
		return "nonValido";
	}
	 
	/*@Override
	public String getParametro() {
		return this.parametro;
	}*/
	
}
