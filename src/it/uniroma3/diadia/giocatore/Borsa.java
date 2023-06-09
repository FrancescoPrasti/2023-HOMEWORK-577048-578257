package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.*;

import it.uniroma3.diadia.Configuratore;
import it.uniroma3.diadia.attrezzi.*;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
	}
	
	// Restituisce la lista ordinata per peso,e in caso di ugual peso viene confrontato il nome.
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziOrdinati = new ArrayList<>();
		attrezziOrdinati.addAll(this.attrezzi);
		ComparatoreAttrezzoPerPesoNome cmp = new ComparatoreAttrezzoPerPesoNome();
		Collections.sort(attrezziOrdinati, cmp);
		return attrezziOrdinati;
	}
	
	// Restituisce un SortedSet ordinato per nome.
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatoreAttrezzoPerNome cmp = new ComparatoreAttrezzoPerNome();
		SortedSet<Attrezzo> insiemeOrdinato = new TreeSet<Attrezzo>(cmp);
		insiemeOrdinato.addAll(attrezzi);
		return insiemeOrdinato;
	}
	
	// Restituisce una Map ordinata per peso.
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappa = new TreeMap<>();
		for(Attrezzo a : this.attrezzi){
			if(mappa.containsKey(a.getPeso())) {
				mappa.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo>  s = new HashSet<Attrezzo>();
				s.add(a);
				mappa.put(a.getPeso(), s);
			}
		}
		return mappa;
	}
	
	// Restituisce una SortedSet ordinata per peso,e in caso di ugual peso viene confrontato il nome.
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatoreAttrezzoPerPesoNome cmp = new ComparatoreAttrezzoPerPesoNome();
		SortedSet<Attrezzo> insiemeOrdinato = new TreeSet<Attrezzo>(cmp);
		insiemeOrdinato.addAll(attrezzi);
		return insiemeOrdinato;
	}
	
	/*
	 *  Se il peso totale supera il peso max ritorna falso e l'attrezzo non viene aggiunto alla stanza;
	 *  Altrimenti ritorna true e aggiunge l'attrezzo alla stanza.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		else {
			return this.attrezzi.add(attrezzo);
		}
	}
	
	//Ritorna il peso massimo della borsa.
	public int getPesoMax() {
		return pesoMax;
	}
	
	//Ritorna l'attrezzo che ha il nome passato nella funzione come parametro.
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}
	
	//Ritorna il peso totale della borsa.
	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			peso += iteratore.next().getPeso();
		}
		return peso;
	}
	
	//Ritorna true se la borsa è vuota, false altrimenti.
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	//Ritorna true se la borsa contiene l'attrezzo che ha il nome della variabile nomeAttrezzo.
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/*
	 * Ritorna null se non ci sono attrezzi nella borsa o se
	 * l'attrezzo cercato non si trova nella borsa;
	 * altrimenti ritorna l'attrezzo cercato e lo rimuove dalla borsa.
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
			}
		}
		return null;
	}
	
	//Ritorna una descerizione del contenuto della borsa.
	public String toString() {
		StringBuilder s = new StringBuilder();
		List<Attrezzo> listaOrdinata = this.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> iteratore = listaOrdinata.iterator();
		
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			while(iteratore.hasNext()) {
				s.append(iteratore.next().toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	// Restituiscce la lista di attrezzi.
	public List<Attrezzo> getListaAttrezzi(){
		return this.attrezzi;
	}
	
}
