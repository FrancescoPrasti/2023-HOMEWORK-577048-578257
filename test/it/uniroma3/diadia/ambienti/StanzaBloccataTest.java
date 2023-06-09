package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.*;

import it.uniroma3.diadia.Partita;

class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	
	@BeforeEach
	void setUp() {
		this.stanzaBloccata = new StanzaBloccata("s1", Direzione.nord ,"chiave");
		this.stanzaBloccata.impostaStanzaAdiacente(Direzione.nord, new Stanza("s2"));
	}

	@Test
	void testStanzaSenzaChiaveGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(this.stanzaBloccata,this.stanzaBloccata.getStanzaAdiacente(Direzione.nord));
	}
	
	@Test
	void testStanzaSenzaChiaveGetStanzaAdiacenteAltraDirezione() {
		this.stanzaBloccata.impostaStanzaAdiacente(Direzione.est, new Stanza("s2"));
		assertEquals("s2",this.stanzaBloccata.getStanzaAdiacente(Direzione.est).getNome());
	}
	
	@Test
	void testStanzaConChiaveGetStanzaAdiacenteDirezioneBloccata() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo("chiave",2));
		assertEquals("s2",this.stanzaBloccata.getStanzaAdiacente(Direzione.nord).getNome());
	}
	
	@Test
	void testStanzaSenzaChiaveGetDescrizione() {
		assertEquals("s1\nUscite: [nord]\nAttrezzi nella stanza: []\nDirezione nord bloccata",this.stanzaBloccata.getDescrizione());
	}
	
	@Test
	void testStanzaConChiaveGetDescrizione() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo("chiave",2));
		assertEquals("s1\nUscite: [nord]\nAttrezzi nella stanza: [chiave (2kg)]",this.stanzaBloccata.getDescrizione());
	}

}
