package it.uniroma3.diadia.ambienti;

import java.util.Iterator;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	private Direzione direzioneBloccata;
	private String attrezzoSblocca;

	public StanzaBloccata(String nome, Direzione direzione, String attrezzoSblocca) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSblocca = attrezzoSblocca;
	}

	/**
	 * Ritorna la stanza adiacente nella direzione indicata;
	 * Se la direzione è quella bloccata, e nella stanza non c'è l'attrezzo che la sblocca,
	 * allora ritorna un riferimento alla stanza corrente.
	 */
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSblocca)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

	/**
	 * Ritorna una descrizione della stanza.
	 */
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoSblocca))
			return this.toString();
		else
			return this.toString() + "\nDirezione " + this.direzioneBloccata + " bloccata";
	}

	public boolean isBloccata() {
		return true;
	}

	public String getAttrezzoSblocca() {
		return this.attrezzoSblocca;
	}

	public Direzione getDirezioneBloccata() {
		return this.direzioneBloccata;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

}
