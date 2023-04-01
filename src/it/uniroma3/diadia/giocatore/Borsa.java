package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	/* Ritorna false se il peso totale degli oggetti contenuti nella borsa sommato
	 * a quello dell'attrezzo che si vuole aggiungere supera il peso max della borsa;
	 * ritorna false anche se il numero degli attrezzi nella borsa è massimo, cioè 10 attrezzi.
	 * Altrimenti l'attrezzo viene aggiunto alla borsa e ritorna true.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	//Ritorna il peso massimo della borsa.
	public int getPesoMax() {
		return pesoMax;
	}
	
	//Ritorna l'attrezzo che ha il nome passato nella funzione come parametro.
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}
	
	//Ritorna il peso totale della borsa.
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		
		return peso;
	}
	
	//Ritorna true se la borsa è vuota, false altrimenti.
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
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
		if(this.numeroAttrezzi == 0)
			return null;
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				attrezzi[i] = attrezzi[this.numeroAttrezzi-1];
				attrezzi[this.numeroAttrezzi-1] = null;
				numeroAttrezzi--;
				return a;
			}
		}
		return null;
	}
	
	//Ritorna una descerizione del contenuto della borsa.
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public void setNumeroAttrezzi(int numero) {
		this.numeroAttrezzi = numero;
	}
	
	//Ritorna il numero di attrezi contenuti nella borsa.
	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	//Ritorna l'array di attrezzi.
	public Attrezzo[] getArrayAttrezzi() {
		return attrezzi;
	}
	
}
