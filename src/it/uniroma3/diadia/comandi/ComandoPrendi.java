package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{

	private String nomeAttrezzo;

	// Metodo che permette al giocatore di rimuovere un attrezzo dalla stanza in cui si trova e di inserirlo nella borsa.
	@Override
	public void esegui(Partita partita, IO io) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		if(stanzaCorrente.getListaAttrezzi().size() == 0)
			io.mostraMessaggio("Questa stanza non contiene attrezzi!");
		else {
			if(nomeAttrezzo == null) {  //Entro nell'if se l'utente inserisce solo "prendi" senza specificare il nome dell'attrezzo.
				io.mostraMessaggio("Quale attrezzo vuoi prendere dalla stanza?");
				this.nomeAttrezzo = io.leggiRiga();
			}

			if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
				Attrezzo attrezzo = null;
				attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);

				if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo) == true) {  //Se l'inserimento dell'attrezzo nella borsa va a buon fine entro.

					if(stanzaCorrente.removeAttrezzo(attrezzo) == true) {
						io.mostraMessaggio("L'attrezzo è stato rimosso dalla stanza!");
						io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());  //Stampo a schermo il contenuto della borsa.
					}else
						io.mostraMessaggio("L'attrezzo non è stato rimosso dalla stanza!");
				}else
					io.mostraMessaggio("Non c'è spazio nella borsa o possiedi già 10 attrezzi!");
			}else
				io.mostraMessaggio("La stanza non contiene l'attrezzo che cerchi!");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}
	 
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
}
