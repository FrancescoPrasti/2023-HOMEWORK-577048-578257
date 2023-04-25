package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

class ComandoPrendiTest {
	
	private ComandoPrendi prendi;
	private IO io;
	private Partita partita;

	@BeforeEach
	void setUp() {
		this.prendi = new ComandoPrendi();
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	@Test
	void testPrendiAttrezzoInStanzaVuota() {
		this.partita.setStanzaCorrente(new Stanza("s1"));
		this.prendi.setParametro("cacciavite");
		this.prendi.esegui(partita, io);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("cacciavite"));
	}
	
	@Test
	void testPrendiAttrezzoInStanzaCheLoContiene() {
		this.prendi.setParametro("osso");
		this.prendi.esegui(partita, io);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	void testPrendiAttrezzoInStanzaCheHaPiuAttrezzi() {
		this.partita.getStanzaCorrente().addAttrezzo(new Attrezzo("cacciavite",2));
		this.prendi.setParametro("cacciavite");
		this.prendi.esegui(partita, io);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("cacciavite"));
	}
	
	@Test
	void testPrendiAttrezzoRimossoDallaStanza() {
		this.prendi.setParametro("osso");
		this.prendi.esegui(partita, io);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("osso"));
	}

}
