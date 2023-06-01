package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.*;



class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	
	@BeforeEach
	void setUp() {
		this.stanzaBloccata = new StanzaBloccata("s1", "chiave", "nord");
		this.stanzaBloccata.impostaStanzaAdiacente("nord", new Stanza("s2"));
	}

	@Test
	void testStanzaSenzaChiaveGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(this.stanzaBloccata,this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testStanzaSenzaChiaveGetStanzaAdiacenteAltraDirezione() {
		this.stanzaBloccata.impostaStanzaAdiacente("est", new Stanza("s2"));
		assertEquals("s2",this.stanzaBloccata.getStanzaAdiacente("est").getNome());
	}
	
	@Test
	void testStanzaConChiaveGetStanzaAdiacenteDirezioneBloccata() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo("chiave",2));
		assertEquals("s2",this.stanzaBloccata.getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	void testStanzaSenzaChiaveGetDescrizione() {
		assertEquals("s1\nUscite:  nord\nAttrezzi nella stanza: nessuno!\nDirezione nord bloccata",this.stanzaBloccata.getDescrizione());
	}
	
	@Test
	void testStanzaConChiaveGetDescrizione() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo("chiave",2));
		assertEquals("s1\nUscite:  nord\nAttrezzi nella stanza: chiave (2kg) ", this.stanzaBloccata.getDescrizione());
	}

}
