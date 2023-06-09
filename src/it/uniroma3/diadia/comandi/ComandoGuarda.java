package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando{
	
	//private String parametro;
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("CFU rimanenti: " + partita.getGiocatore().getCfu() + "\n" + partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	
	/*@Override
	public void setParametro(String parametro) {
		this.parametro = null;
	}*/
	
	@Override
	public String getNome() {
		return "guarda";
	}
	 
	/*@Override
	public String getParametro() {
		return this.parametro;
	}*/
	
}
