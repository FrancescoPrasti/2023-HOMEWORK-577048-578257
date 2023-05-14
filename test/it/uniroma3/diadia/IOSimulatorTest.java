package it.uniroma3.diadia;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	private List<String> lista;
	private IOSimulator IOS;

	@BeforeEach
	void setUp() throws Exception {
		this.lista = new ArrayList<String>();
		this.lista.add("vai ovest");
		this.IOS = new IOSimulator(lista);
	}

	@Test
	void testLeggiRiga() {
		assertEquals("vai ovest", this.IOS.leggiRiga());
	}
	
	@Test
	void testLeggiRiga2() {
		this.lista.add("vai est");
		this.IOS.leggiRiga();
		assertEquals("vai est", this.IOS.leggiRiga() );
	}
	
	@Test
	void testMostraMessaggio() {
		this.IOS.mostraMessaggio("vai est");
		assertEquals("vai est", this.IOS.nextMessaggio() );
	}
	
	@Test
	void testMostraPiuMessaggi() {
		this.IOS.mostraMessaggio("vai est");
		this.IOS.mostraMessaggio("vai sud");
		this.IOS.mostraMessaggio("vai nord");
		assertEquals("vai est", this.IOS.nextMessaggio() );
		assertTrue(this.IOS.hasNextMessaggio());
		assertEquals("vai sud", this.IOS.nextMessaggio() );
		assertTrue(this.IOS.hasNextMessaggio());
		assertEquals("vai nord", this.IOS.nextMessaggio() );
		assertFalse(this.IOS.hasNextMessaggio());
	}
	
	@Test
	void testListaConUnElemento() {
		assertFalse(this.IOS.hasNextMessaggio());
	}
	
	@Test
	void testListaConPiuElementi() {
		this.lista.add("vai est");
		this.lista.add("vai sud");
		this.lista.add("vai nord");
		assertEquals("vai ovest", this.IOS.leggiRiga());
		assertEquals("vai est", this.IOS.leggiRiga());
		assertEquals("vai sud", this.IOS.leggiRiga());
		assertEquals("vai nord", this.IOS.leggiRiga());
	}
	
}
