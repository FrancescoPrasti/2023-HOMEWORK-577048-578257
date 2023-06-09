package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;


public class ComandoFabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica factory; 
	private Comando comando;
	private IO io;

	@BeforeEach
	void setUp() {
		io = new IOConsole(new Scanner(System.in));
		factory = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	void testComandoAiuto() {
		comando = this.factory.costruisciComando("aiuto");
		assertTrue(this.comando.getNome() == "aiuto" && this.comando.getParametro() == null);
	}

	@Test
	void testComandoFine() {
		comando = this.factory.costruisciComando("fine");
		assertTrue(this.comando.getNome() == "fine" && this.comando.getParametro() == null);
	}

	@Test
	void testComandoGuarda() {
		comando = this.factory.costruisciComando("guarda");
		assertTrue(this.comando.getNome() == "guarda" && this.comando.getParametro() == null);
	}

	@Test
	void testComandoNonValido() {
		comando = this.factory.costruisciComando("NONVALIDO");
		assertTrue(this.comando.getNome() == "nonValido" && this.comando.getParametro() == null);
	}

	@Test
	void testComandoPosaSenzaParametro() {
		comando = this.factory.costruisciComando("posa");
		assertTrue(this.comando.getNome() == "posa" && this.comando.getParametro() == null);
	}

	@Test
	void testComandoPosaConParametro() {
		comando = this.factory.costruisciComando("posa martello");
		assertTrue(this.comando.getNome() == "posa" && this.comando.getParametro().equals("martello"));
	}

	@Test
	void testComandoPrendiSenzaParametro() {
		comando = this.factory.costruisciComando("prendi");
		assertTrue(this.comando.getNome() == "prendi" && this.comando.getParametro() == null);
	}

	@Test
	void testComandoPrendiConParametro() {
		comando = this.factory.costruisciComando("prendi martello");
		assertTrue(this.comando.getNome() == "prendi" && this.comando.getParametro().equals("martello"));
	}

	@Test
	void testComandoVaiSenzaParametro() {
		comando = this.factory.costruisciComando("vai");
		assertTrue(this.comando.getNome() == "vai" && this.comando.getParametro() == null);
	}

	@Test
	void testComandoVaiConParametro() {
		comando = this.factory.costruisciComando("vai nord");
		assertTrue(this.comando.getNome() == "vai" && this.comando.getParametro().equals("nord"));
	}

}
