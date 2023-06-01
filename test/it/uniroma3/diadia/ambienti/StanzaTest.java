package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StanzaTest {

	private Stanza s1;
	private Attrezzo martello;
	
	@BeforeEach
	public void setUp() {
		s1 = new Stanza("s1");
		martello = new Attrezzo("martello", 5);
		s1.addAttrezzo(martello);
	}

	@Test
	public void testGetAttrezzoMartelloInStanzaCheLoContiene() {
		assertEquals(martello, s1.getAttrezzo("martello"));
	}
	
	@Test
	public void testGetAttrezzoInStanzaSenzaAttrezzi(){
		assertNull(new Stanza("s2").getAttrezzo("martello"));
	}
	
	@Test
	public void testGetAttrezzoInStanzaCheNonLoContiene() {
		assertNull(s1.getAttrezzo("chiave"));
	}
	
	@Test
	public void testHasAttrezzoStanzaCheLoContiene() {
		assertTrue(s1.hasAttrezzo("martello"));
	}
	
	@Test
	public void testHasAttrezzoStanzaCheNonLoContiene() {
		assertFalse(s1.hasAttrezzo("chiave"));
	}
	
	@Test
	public void testHasAttrezzoStanzaCheNonContieneAttrezzi() {
		assertFalse(new Stanza("s2").hasAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoStanzaCheNonContieneAttrezzi(){
		assertFalse(new Stanza("s2").removeAttrezzo(martello));
	}
	
	@Test
	public void testRemoveAttrezzoStanzaCheNonContieneAttrezzoDaRimuovere(){
		assertFalse(s1.removeAttrezzo(new Attrezzo("chiave", 2)));
	}
	
	@Test
	public void testRemoveAttrezzoStanzaCheContieneAttrezzo(){
		assertTrue(s1.removeAttrezzo(martello));
	}
	
	@Test
	public void testAddAttrezzo(){
		assertTrue(s1.addAttrezzo(new Attrezzo("chiave", 2)));
	}
	
	/*@Test
	public void testAddAttrezzoInStanzaCon10Attrezzi(){
		for(int i=0;i<10; i++)
			this.s1.getListaAttrezzi().add(new Attrezzo("martello", 3));
		assertFalse(s1.addAttrezzo(new Attrezzo("chiave", 2)));
	}*/
	
	@Test
	public void testStanzaAdiacente(){
		Stanza s2 = new Stanza("s2");
		s1.impostaStanzaAdiacente("nord", s2);
		assertEquals(s2, s1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaAdiacenteNull() {
		assertNull(new Stanza("s2").getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testStanzaAdiacenteDirezioneErrata() {
		s1.impostaStanzaAdiacente("nord", new Stanza("s2"));
		assertNull(s1.getStanzaAdiacente("est"));
	}



}
