package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoRegala extends AbstractComando{

	private String nomeAttrezzo;

	/*@Override
	public void esegui(Partita partita, IO io) {
		partita.getStanzaCorrente().getPersonaggio().riceviRegalo(partita.getGiocatore().getBorsa().removeAttrezzo(parametro), partita);
	}*/

	@Override
	public void esegui(Partita partita, IO io) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		if(borsa.getListaAttrezzi().size()== 0)
			io.mostraMessaggio("La borsa non contiene attrezzi!");
		else {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			if(nomeAttrezzo == null) {
				io.mostraMessaggio("Quale attrezzo vuoi posare nella stanza?");
				nomeAttrezzo = io.leggiRiga();
			}
			if(borsa.hasAttrezzo(nomeAttrezzo)) {
				stanzaCorrente.getPersonaggio().riceviRegalo(borsa.removeAttrezzo(this.nomeAttrezzo), partita);
			}else
				io.mostraMessaggio("Nella borsa non hai questo attrezzo!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "interagisci";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
