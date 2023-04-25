package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.*;

class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	
	@BeforeEach
	void setUp() {
		this.stanzaBuia = new StanzaBuia("s1", "chiave");
	}

	@Test
	void testStanzaSenzaChiaveGetDescrizione() {
		assertEquals("Qui c'è buio pesto",this.stanzaBuia.getDescrizione());
	}
	
	@Test
	void testStanzaConChiaveGetDescrizione() {
		this.stanzaBuia.addAttrezzo(new Attrezzo("chiave",2));
		assertEquals("s1\nUscite: \nAttrezzi nella stanza: chiave (2kg) ",this.stanzaBuia.getDescrizione());
	}

}
