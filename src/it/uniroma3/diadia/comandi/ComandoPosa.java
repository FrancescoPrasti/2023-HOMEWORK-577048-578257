package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	
	// Metodo che permette al giocatore di rimuovere un attrezzo dalla borsa e di posarlo nella stanza in cui si trova.
	public void esegui(Partita partita, IO io) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		if(borsa.getNumeroAttrezzi()== 0)
			io.mostraMessaggio("La borsa non contiene attrezzi!");
		else {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			if(stanzaCorrente.getNumeroAttrezzi() > 9)  //Ho raggiunto la capienza massima della stanza, cioè 10 attrezzi.
				io.mostraMessaggio("La stanza dove ti trovi non può contenere ulteriori attrezzi!");
			else {
				if(nomeAttrezzo == null) {  //Entro nell'if se l'utente inserisce solo "prendi" senza specificare il nome dell'attrezzo.
					io.mostraMessaggio("Quale attrezzo vuoi posare nella stanza?");
					nomeAttrezzo = io.leggiRiga();
				}
				if(borsa.hasAttrezzo(nomeAttrezzo)) {

					if(stanzaCorrente.addAttrezzo(borsa.removeAttrezzo(nomeAttrezzo)) == true) {  //L'attrezzo viene rimosso dalla borsa e inserito nella stanza.
						io.mostraMessaggio("L'attrezzo è stato posato nella stanza!");
					}else
						io.mostraMessaggio("L'attrezzo NON è stato posato nella stanza!");
				}else
					io.mostraMessaggio("Nella borsa non hai questo attrezzo!");
			}
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "posa";
	}
	 
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
}
