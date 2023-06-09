package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVaiTest {

	private ComandoVai vai;
	private Partita partita;
	private Labirinto labirinto;
	private IO io;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		partita = new Partita(labirinto);
		this.vai = new ComandoVai();
		this.io = new IOConsole(new Scanner(System.in));
		this.vai.setIo(io);
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
