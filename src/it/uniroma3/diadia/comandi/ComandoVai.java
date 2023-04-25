package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole.*;

public class ComandoVai implements Comando{
	
	private String direzione;

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita, IO io) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(this.direzione == null) {
			io.mostraMessaggio("Dove vuoi andare?");
			this.direzione = io.leggiRiga();
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getNome() {
		return "vai";
	}
	 
	@Override
	public String getParametro() {
		return this.direzione;
	}
	
}
