package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;

public class ComandoVaiTest {

	private ComandoVai vai;
	private IO io;
	private Partita partita;
	
	@BeforeEach
	public void setUp() {
		vai = new ComandoVai();
		partita = new Partita();
		io = new IOConsole();
	}

	@Test
	public void testEsegui() {
		vai.setParametro("nord");
		vai.esegui(partita, io);
		assertEquals("Biblioteca",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiDirezioneInesistente() {
		vai.setParametro("nooord");
		vai.esegui(partita, io);
		assertEquals("Atrio",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiDirezioneSenzaStanza() {
		vai.setParametro("nord");
		vai.esegui(partita, io);
		vai.setParametro("nord");
		vai.esegui(partita, io);
		assertEquals("Biblioteca",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiRiduzioneCFU() {
		vai.setParametro("nord");
		vai.esegui(partita, io);
		assertEquals(19,this.partita.getGiocatore().getCfu());
	}

}
