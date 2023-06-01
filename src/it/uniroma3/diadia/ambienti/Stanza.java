package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*; 
import java.util.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
		
	private String nome;
	private Set<Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new TreeSet<Attrezzo>(new ComparatoreAttrezzoPerNome());
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione in cui sara' posta la stanza adiacente.
     * @param stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
    	if(this.getDirezioni().size() != 4)
    		this.stanzeAdiacenti.put(direzione, stanzaAdiacente);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    		return this.attrezzi.add(attrezzo);
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	Set<String> direzioni = this.stanzeAdiacenti.keySet();
    	Iterator<String> iteratore = direzioni.iterator();
    	while(iteratore.hasNext()) {
			risultato.append(" " + iteratore.next());
    	}
    	risultato.append("\nAttrezzi nella stanza: ");
		boolean esiste = false;
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if (attrezzo!=null) {
    			risultato.append(attrezzo.toString()+" ");
    			esiste = true;
    		}
    	}
    	if(esiste == false)
        	risultato.append("nessuno!");
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	
	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
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

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			if(iteratore.next().getNome().equals(attrezzo.getNome())) {
				iteratore.remove();
				return true;
			}
		}
		return false;
	}
	
	/**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
	public List<Attrezzo> getListaAttrezzi(){
		List<Attrezzo> lista = new ArrayList<Attrezzo>();
		lista.addAll(this.attrezzi);
		return lista;
	}

	// Restituisce un Set con tutte le direzioni delle stanze adiacenti a questa
	public List<String> getDirezioni() {
		List<String> direzioni = new ArrayList<String>();
		direzioni.addAll(this.stanzeAdiacenti.keySet());
		return direzioni;
    }
	
	// Restituisce una Map delle stanze adiacenti a questa
	public Map<String,Stanza> getMapStanzeAdiacenti() {
		return this.stanzeAdiacenti;
    }
	
	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza)o;
		return this.getNome().equals(that.getNome());
	}
	
	/*public boolean getMagica() {
		return this.magica;
	}*/

}