package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.*;

class StanzaMagicaTest {

	private StanzaMagica stanzaMagica;
	
	@BeforeEach
	void setUp() {
		this.stanzaMagica = new StanzaMagica("s1", 1);
		this.stanzaMagica.addAttrezzo(new Attrezzo("martello",3));
	}

	@Test
	void testAddAttrezzoSenzaModifica() {
		assertTrue(this.stanzaMagica.hasAttrezzo("martello") && this.stanzaMagica.getAttrezzo("martello").getPeso() == 3);
	}
	
	@Test
	void testAddAttrezzoConModifica() {
		this.stanzaMagica.addAttrezzo(new Attrezzo("chiave",1));
		assertTrue(this.stanzaMagica.hasAttrezzo("evaihc") && this.stanzaMagica.getAttrezzo("evaihc").getPeso() == 2);
	}
	
	@Test
	void testAddAttrezzoModifica() {
		this.stanzaMagica.addAttrezzo(new Attrezzo("chiave",1));
		assertFalse(this.stanzaMagica.hasAttrezzo("chiave"));
	}

}
