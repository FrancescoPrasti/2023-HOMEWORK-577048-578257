package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

class LabirintoBuilderTest {

	private LabirintoBuilder labirinto;
	
	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = new LabirintoBuilder("labirinto.txt");
	}

	@Test
	void testAddStanzaIniziale() {
		this.labirinto.addStanzaIniziale("atrio");
		assertEquals("atrio", this.labirinto.getLabirinto().getStanzaIniziale().getNome());
	}
	
	@Test
	void testAddStanzaVincente() {
		this.labirinto.addStanzaVincente("biblioteca");
		assertEquals("biblioteca", this.labirinto.getLabirinto().getStanzaFinale().getNome());
	}
	
	@Test
	void testAddStanzaAttrezzo() {
		this.labirinto.addStanza("atrio");
		this.labirinto.addAttrezzo("martello", 5);
		assertEquals("martello", this.labirinto.getLabirinto().getStanza().getAttrezzo("martello").getNome());
	}
	
	@Test
	void testAddStanza() {
		this.labirinto.addStanza("atrio");
		assertEquals("atrio", this.labirinto.getLabirinto().getStanza().getNome());
	}
	
	@Test
	void testAddAdiacenza() {
		this.labirinto.addStanza("biblioteca");
		this.labirinto.addStanza("atrio");
		this.labirinto.addAdiacenza("atrio", "biblioteca", Direzione.nord);
		assertEquals("biblioteca", this.labirinto.getLabirinto().getStanza().getStanzaAdiacente(Direzione.nord).getNome());
	}
	
	@Test
	void testAddStanzaMagica() {
		this.labirinto.addStanzaMagica("atrio", 3);
		StanzaMagica stanzaMagica = (StanzaMagica)this.labirinto.getLabirinto().getStanza();
		assertTrue(stanzaMagica.isMagica());
	}
	
	@Test
	void testAddStanzaBuia() {
		this.labirinto.addStanzaBuia("atrio", "martello");
		StanzaBuia stanzaBuia = (StanzaBuia)this.labirinto.getLabirinto().getStanza();
		assertTrue(stanzaBuia.isBuia());
	}
	
	@Test
	void testAddStanzaBloccata() {
		this.labirinto.addStanzaBloccata("atrio", "biblioteca", Direzione.nord);
		StanzaBloccata stanzaBloccata = (StanzaBloccata)this.labirinto.getLabirinto().getStanza();
		assertTrue(stanzaBloccata.isBloccata());
	}
	
	@Test
	void testGetListaStanze() {
		this.labirinto.addStanza("atrio");
		this.labirinto.addStanza("biblioteca");
		this.labirinto.addStanza("mensa");
		assertEquals("atrio",this.labirinto.getListaStanze().get("atrio").getNome());
		assertEquals("biblioteca",this.labirinto.getListaStanze().get("biblioteca").getNome());
		assertEquals("mensa",this.labirinto.getListaStanze().get("mensa").getNome());
	}

}
