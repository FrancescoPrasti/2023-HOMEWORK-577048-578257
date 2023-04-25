package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.*;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String attrezzoSblocca;

	public StanzaBloccata(String nome, String attrezzoSblocca, String direzione) {
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
	public Stanza getStanzaAdiacente(String dir) {

		if(dir.equals(this.direzioneBloccata)) {
			if(this.hasAttrezzo(attrezzoSblocca) == false)
				return this;
		}
		return super.getStanzaAdiacente(dir);
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

}
