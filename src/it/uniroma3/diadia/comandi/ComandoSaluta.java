package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{
	
	//private String parametro;
	
	@Override
	public void esegui(Partita partita, IO io) {
		partita.getStanzaCorrente().getPersonaggio().saluta();
	}
	
	/*@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}*/
	
	@Override
	public String getNome() {
		return "saluta";
	}
	 
	/*@Override
	public String getParametro() {
		return this.parametro;
	}*/
	
}
