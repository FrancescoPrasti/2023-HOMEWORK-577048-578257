package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {

	private Partita partita;
	private Labirinto labirinto;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		partita = new Partita(labirinto);
	}

	@Test
	public void testSetEGetStanzaCorrente() {
		assertEquals("Atrio", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaFinale().getNome());
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
