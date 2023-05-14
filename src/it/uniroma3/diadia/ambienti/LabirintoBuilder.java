package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;
import java.util.*;

public class LabirintoBuilder {
	
	private Labirinto labirinto;
	private Map<String,Stanza> mappa;
	private Stanza stanzaDaAggiungere;
	
	public LabirintoBuilder() {
		labirinto = new Labirinto();
		mappa = new TreeMap<>();
	}
	
	// Aggiunge la stanza iniziale del labirinto.
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		this.stanzaDaAggiungere = new Stanza(nomeStanza);
		this.labirinto.setStanzaIniziale(this.stanzaDaAggiungere);
		this.labirinto.setStanza(this.stanzaDaAggiungere);
		mappa.put(nomeStanza, this.stanzaDaAggiungere);
		return this;
	}
	
	// Aggiunge la stanza finale, quindi vincente, del labirinto.
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		this.stanzaDaAggiungere = new Stanza(nomeStanza);
		this.labirinto.setStanzaFinale(this.stanzaDaAggiungere);
		this.labirinto.setStanza(this.stanzaDaAggiungere);
		mappa.put(nomeStanza, this.stanzaDaAggiungere);
		return this;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	// Aggiunge un attrezzo all'ultima stanza aggiunta.
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		this.labirinto.getStanza().addAttrezzo(new Attrezzo(nome, peso));
		return this;
	}
	
	// Aggiunge una stanza al labirinto.
	public LabirintoBuilder addStanza(String nomeStanza) {
		this.stanzaDaAggiungere = new Stanza(nomeStanza);
		this.labirinto.setStanza(stanzaDaAggiungere);
		mappa.put(nomeStanza, this.stanzaDaAggiungere);
		return this;
	}
	
	// Imposta una stanza adiacente in una certa dimensione alla stanza inserita come primo parametro.
	public LabirintoBuilder addAdiacenza(String stanza, String stanzaAdiacente, String direzione) {
		Stanza stanzaCorrente = mappa.get(stanza);
		Stanza stanzaNext = mappa.get(stanzaAdiacente);
		stanzaCorrente.impostaStanzaAdiacente(direzione, stanzaNext);
		return this;
	}
	
	// Aggiunge una stanza magica al labirinto.
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int soglia) {
		StanzaMagica stanza = new StanzaMagica(nomeStanza, soglia);
		this.labirinto.setStanza(stanza);
		mappa.put(nomeStanza, stanza);
		return this;
	}
	
	// Aggiunge una stanza buia al labirinto.
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String attrezzoSblocca) {
		StanzaBuia stanza = new StanzaBuia(nomeStanza, attrezzoSblocca);
		this.labirinto.setStanza(stanza);
		mappa.put(nomeStanza, stanza);
		return this;
	}
	
	// Aggiunge una stanza bloccata al labirinto.
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzioneBloccata, String attrezzoSblocca) {
		StanzaBloccata stanza = new StanzaBloccata(nomeStanza, attrezzoSblocca, direzioneBloccata);
		this.labirinto.setStanza(stanza);
		mappa.put(nomeStanza, stanza);
		return this;
	}
	
	// Restituisce una Map delle stanze del labirinto.
	public Map<String,Stanza> getListaStanze(){
		return mappa;
	}
	
}
