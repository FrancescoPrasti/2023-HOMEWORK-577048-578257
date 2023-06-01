package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BorsaTest {

	private Borsa borsa;
	private Attrezzo martello;
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa();
		martello = new Attrezzo("martello", 5);
		borsa.addAttrezzo(martello);
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(new Borsa().isEmpty());
	}
	
	@Test
	public void testIsEmptyBorsaNonVuota() {
		assertFalse(borsa.isEmpty());
	}
	
	@Test
	public void getAttrezzoSeStaNellaBorsa() {
		assertEquals(martello, borsa.getAttrezzo("martello"));
	}
	
	@Test
	public void getAttrezzoSeNonNellaBorsa() {
		assertNull(borsa.getAttrezzo("chiave"));
	}
	
	@Test
	public void getAttrezzoBorsaVuota() {
		assertNull(new Borsa().getAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoSeAttrezzoCercatoStaNellaBorsa() {
		assertEquals(martello, borsa.removeAttrezzo("martello"));
	}
	
	@Test
	public void testRemoveAttrezzoSeAttrezzoCercatoNonStaNellaBorsa() {
		assertNull(borsa.removeAttrezzo("chiave"));
	}
	
	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertNull(new Borsa().removeAttrezzo("chiave"));
	}
	
	@Test
	public void testGetPesoCon1Attrezzo() {
		assertEquals(5, borsa.getPeso());
	}
	
	@Test
	public void testGetPesoCon2Attrezzi() {
		borsa.addAttrezzo(new Attrezzo("chiave", 2));
		assertEquals(7, borsa.getPeso());
	}
	
	@Test
	public void testGetPesoConBorsaVuota() {
		assertEquals(0, new Borsa().getPeso());
	}
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	@Test
	public void testHasAttrezzoNonContenutoNellaBorsa() {
		assertFalse(borsa.hasAttrezzo("chiave"));
	}
	
	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(new Borsa().hasAttrezzo("martello"));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		borsa.addAttrezzo(new Attrezzo("chiave", 3));
		borsa.addAttrezzo(new Attrezzo("scopa", 2));
		List<Attrezzo> lista = borsa.getContenutoOrdinatoPerPeso();
		assertSame("scopa", lista.get(0).getNome());
		assertSame("chiave", lista.get(1).getNome());
		assertSame("martello", lista.get(2).getNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoConPesiUguali() {
		borsa.addAttrezzo(new Attrezzo("scopa", 2));
		borsa.addAttrezzo(new Attrezzo("chiave", 2));
		List<Attrezzo> lista = borsa.getContenutoOrdinatoPerPeso();
		assertSame("chiave", lista.get(0).getNome());
		assertSame("scopa", lista.get(1).getNome());
		assertSame("martello", lista.get(2).getNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoConBorsaVuota() {
		Borsa b2 = new Borsa();
		List<Attrezzo> lista = b2.getContenutoOrdinatoPerPeso();
		assertEquals(0, lista.size());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		borsa.addAttrezzo(new Attrezzo("scopa", 3));
		borsa.addAttrezzo(new Attrezzo("chiave", 2));
		SortedSet<Attrezzo> insieme = borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iteratore = insieme.iterator();
		assertEquals("chiave", iteratore.next().getNome());
		assertEquals("martello", iteratore.next().getNome());
		assertEquals("scopa", iteratore.next().getNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomePesiUguali() {
		borsa.addAttrezzo(new Attrezzo("scopa", 2));
		borsa.addAttrezzo(new Attrezzo("chiave", 2));
		SortedSet<Attrezzo> insieme = borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iteratore = insieme.iterator();
		assertEquals("chiave", iteratore.next().getNome());
		assertEquals("martello", iteratore.next().getNome());
		assertEquals("scopa", iteratore.next().getNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeBorsaVuota() {
		Borsa b2 = new Borsa();
		SortedSet<Attrezzo> insieme = b2.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iteratore = insieme.iterator();
		assertFalse(iteratore.hasNext());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoConPesiUguali() {
		borsa.addAttrezzo(new Attrezzo("scopa", 2));
		borsa.addAttrezzo(new Attrezzo("chiave", 2));
		SortedSet<Attrezzo> insieme = borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> iteratore = insieme.iterator();
		assertEquals("chiave", iteratore.next().getNome());
		assertEquals("scopa", iteratore.next().getNome());
		assertEquals("martello", iteratore.next().getNome());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		borsa.addAttrezzo(new Attrezzo("scopa", 2));
		borsa.addAttrezzo(new Attrezzo("chiave", 3));
		SortedSet<Attrezzo> insieme = borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> iteratore = insieme.iterator();
		assertEquals("scopa", iteratore.next().getNome());
		assertEquals("chiave", iteratore.next().getNome());
		assertEquals("martello", iteratore.next().getNome());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoBorsaVuota() {
		Borsa b2 = new Borsa();
		SortedSet<Attrezzo> insieme = b2.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> iteratore = insieme.iterator();
		assertFalse(iteratore.hasNext());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoMappa() {
		borsa.addAttrezzo(new Attrezzo("scopa", 2));
		borsa.addAttrezzo(new Attrezzo("chiave", 3));
		Map<Integer, Set<Attrezzo>> mappa = borsa.getContenutoRaggruppatoPerPeso();
		assertEquals("scopa",mappa.get(2).iterator().next().getNome());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoMappConDueAttrezziInUnSet() {
		borsa.addAttrezzo(new Attrezzo("scopa", 2));
		borsa.addAttrezzo(new Attrezzo("chiave", 2));
		Map<Integer, Set<Attrezzo>> mappa = borsa.getContenutoRaggruppatoPerPeso();
		Iterator<Attrezzo> iteratore = mappa.get(2).iterator();
		assertEquals("chiave",iteratore.next().getNome());
		assertEquals("scopa",iteratore.next().getNome());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoMappConBorsaVuota() {
		Borsa b2 = new Borsa();
		Map<Integer, Set<Attrezzo>> mappa = b2.getContenutoRaggruppatoPerPeso();
		assertSame(0, mappa.size());
	}
	
}
