package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.*;

public class ComandoInteragisci extends AbstractComando{

	//private String parametro;
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";
	private String messaggio;

	/*@Override
	public void esegui(Partita partita, IO io) {
		partita.getStanzaCorrente().GetPersonaggio().agisci(partita);
	}*/

	@Override
	public void esegui(Partita partita, IO io) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);

		} else 
			io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}

	/*@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}*/

	@Override
	public String getNome() {
		return "interagisci";
	}

	/*@Override
	public String getParametro() {
		return this.parametro;
	}*/

}
