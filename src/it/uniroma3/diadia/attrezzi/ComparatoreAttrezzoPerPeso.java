package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezzoPerPeso implements Comparator<Attrezzo>{

	public int compare(Attrezzo a1, Attrezzo a2) {
		return a1.getPeso() - a2.getPeso();
	}
}
