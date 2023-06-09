package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Configuratore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = Configuratore.getCFU();
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	//Ritorna i cfu del giocatore.
	public int getCfu() {
		return this.cfu;
	}
	
	//Imposta i cfu del giocatore.
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public Borsa getBorsa() {
		return this.borsa;
	}
}
