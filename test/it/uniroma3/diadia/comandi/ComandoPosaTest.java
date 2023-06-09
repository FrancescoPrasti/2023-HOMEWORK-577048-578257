package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	
	private ComandoPosa posa;
	private Partita partita;
	private Labirinto labirinto;
	private IO io;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		partita = new Partita(labirinto);
		this.posa = new ComandoPosa();
		this.io = new IOConsole(new Scanner(System.in));
		this.posa.setIo(io);
	}

	@Test
	void testEseguiPosaBorsaConSoloAttrezzoCercato() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("cacciavite",2));
		this.posa.setParametro("cacciavite");
		this.posa.esegui(partita, io);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("cacciavite"));
	}
	
	@Test
	void testEseguiPosaBorsaConpiuAttrezzi() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("chitarra",5));
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("cacciavite",2));
		this.posa.setParametro("cacciavite");
		this.posa.esegui(partita, io);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("cacciavite"));
	}
	
	@Test
	void testEseguiPosaBorsaVuota() {
		this.posa.setParametro("cacciavite");
		this.posa.esegui(partita, io);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("cacciavite"));
	}
	
	@Test
	void testEseguiPosaAttrezzoNonPresenteInBorsa() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("chitarra",5));
		this.posa.setParametro("cacciavite");
		this.posa.esegui(partita, io);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("cacciavite"));
	}
	
	@Test
	void testPosaAttrezzoRimossoDallaBorsa() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("chitarra",5));
		this.posa.setParametro("chitarra");
		this.posa.esegui(partita, io);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("chitarra"));
	}

}
