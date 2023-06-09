package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.personaggi.*;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	private Stanza stanza;
	
	private Labirinto(String nomeFile, LabirintoBuilder lab) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile, lab);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaFinale = c.getStanzaVincente();
	}
	
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
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Map<String,Stanza> mappa;
		private Stanza stanzaDaAggiungere;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			mappa = new TreeMap<>();
			this.labirinto = new Labirinto(labirinto, this);
		}
		
		public LabirintoBuilder get() {
			return this;
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
		public LabirintoBuilder addAdiacenza(String stanza, String stanzaAdiacente, Direzione direzione) {
			Stanza stanzaCorrente = mappa.get(stanza);
			Stanza stanzaNext = mappa.get(stanzaAdiacente);
			stanzaCorrente.impostaStanzaAdiacente(direzione, stanzaNext);
			return this;
		}
		
		// Aggiunge una stanza magica al labirinto.
		public LabirintoBuilder addStanzaMagica(String nomeStanza, int soglia) {
			Stanza stanza = new StanzaMagica(nomeStanza, soglia);
			this.labirinto.setStanza(stanza);
			mappa.put(nomeStanza, stanza);
			return this;
		}
		
		// Aggiunge una stanza buia al labirinto.
		public LabirintoBuilder addStanzaBuia(String nomeStanza, String attrezzoSblocca) {
			Stanza stanza = new StanzaBuia(nomeStanza, attrezzoSblocca);
			this.labirinto.setStanza(stanza);
			mappa.put(nomeStanza, stanza);
			return this;
		}
		
		// Aggiunge una stanza bloccata al labirinto.
		public LabirintoBuilder addStanzaBloccata(String nomeStanza, String attrezzoSblocca, Direzione direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nomeStanza, direzioneBloccata, attrezzoSblocca);
			this.labirinto.setStanza(stanza);
			mappa.put(nomeStanza, stanza);
			return this;
		}
		
		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			this.labirinto.getStanza().setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			this.labirinto.getStanza().setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			this.labirinto.getStanza().setPersonaggio(s);
			return this;
		}
		
		// Restituisce una Map delle stanze del labirinto.
		public Map<String,Stanza> getListaStanze(){
			return mappa;
		}
		
	}
}
