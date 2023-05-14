package it.uniroma3.diadia.attrezzi;

import java.util.*;

public class ComparatoreAttrezzoPerPesoNome implements Comparator<Attrezzo>{
	
	public int compare(Attrezzo a1, Attrezzo a2) {
		if(a1.getPeso() - a2.getPeso() == 0)
			return a1.getNome().compareTo(a2.getNome());
		else
			return a1.getPeso() - a2.getPeso();
	}
}
