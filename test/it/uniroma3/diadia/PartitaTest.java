package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.ambienti.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	
	private Partita partita;
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 5)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		partita = new Partita(labirinto);
	}
	
	@Test
	public void testSetEGetStanzaCorrente() {
		partita.setStanzaCorrente(new Stanza("s1"));
		assertEquals("s1", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVinta() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaFinale());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testNonVinta() {
		assertFalse(partita.vinta());
	}
	
	@Test
	public void testIsFinitaFunzioneVintaUnicaTrue() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaTutteFalse() {
		assertFalse(partita.isFinita());
	}
	
	@Test
	public void testIsFinitaTutteTrue() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaFinale());
		partita.setFinita();
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}

}
