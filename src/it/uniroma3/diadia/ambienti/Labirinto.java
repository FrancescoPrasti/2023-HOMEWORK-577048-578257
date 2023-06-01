package it.uniroma3.diadia.ambienti;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	private Stanza stanza;
	
	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}
	
	//Restituisce la stanza iniziale.
	public Stanza getStanza() {
		return this.stanza;
	}
	
	public void setStanzaIniziale(Stanza stanza) {
		this.stanzaIniziale = stanza;
	}
	
	public void setStanzaFinale(Stanza stanza) {
		this.stanzaFinale = stanza;
	}
	
	//Restituisce la stanza iniziale.
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	//Restituisce la stanza finale, ovvero quella vincente.
	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}	
}
