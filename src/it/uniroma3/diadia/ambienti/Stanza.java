//package it.uniroma3.diadia.ambienti;

//import it.uniroma3.diadia.attrezzi.*; 
//import it.uniroma3.diadia.personaggi.*;
//import java.util.*;
//
///**
// * Classe Stanza - una stanza in un gioco di ruolo.
// * Una stanza e' un luogo fisico nel gioco.
// * E' collegata ad altre stanze attraverso delle uscite.
// * Ogni uscita e' associata ad una direzione.
// * 
// * @author docente di POO 
// * @see Attrezzo
// * @version base
//*/
//
//public class Stanza {
//		
//	private String nome;
//	private Set<Attrezzo> attrezzi;
//	private Map<String,Stanza> stanzeAdiacenti;
//	private AbstractPersonaggio personaggio;
//    
//    /**
//     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
//     * @param nome il nome della stanza
//     */
//    public Stanza(String nome) {
//        this.nome = nome;
//        this.stanzeAdiacenti = new HashMap<>();
//        this.attrezzi = new TreeSet<Attrezzo>(new ComparatoreAttrezzoPerNome());
//    }
//
//    public void setPersonaggio(AbstractPersonaggio personaggio) {
//    	this.personaggio = personaggio;
//    }
//    
//    public AbstractPersonaggio getPersonaggio() {
//    	return this.personaggio;
//    }
//    
//    /**
//     * Imposta una stanza adiacente.
//     *
//     * @param direzione in cui sara' posta la stanza adiacente.
//     * @param stanza adiacente nella direzione indicata dal primo parametro.
//     */
//    public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
//    	if(this.getDirezioni().size() != 4)
//    		this.stanzeAdiacenti.put(direzione, stanzaAdiacente);
//    }
//
//    /**
//     * Restituisce la stanza adiacente nella direzione specificata
//     * @param direzione
//     */
//	public Stanza getStanzaAdiacente(Direzione direzione) {
//		return this.stanzeAdiacenti.get(direzione);
//	}
//
//    /**
//     * Restituisce la nome della stanza.
//     * @return il nome della stanza
//     */
//    public String getNome() {
//        return this.nome;
//    }
//
//    /**
//     * Restituisce la descrizione della stanza.
//     * @return la descrizione della stanza
//     */
//    public String getDescrizione() {
//        return this.toString();
//    }
//
//    /**
//     * Mette un attrezzo nella stanza.
//     * @param attrezzo l'attrezzo da mettere nella stanza.
//     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
//     */
//    public boolean addAttrezzo(Attrezzo attrezzo) {
//    		return this.attrezzi.add(attrezzo);
//    }
//
//   /**
//	* Restituisce una rappresentazione stringa di questa stanza,
//	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
//	* @return la rappresentazione stringa
//	*/
//    public String toString() {
//    	StringBuilder risultato = new StringBuilder();
//    	risultato.append(this.nome);
//    	risultato.append("\nUscite: ");
//    	Set<String> direzioni = this.stanzeAdiacenti.keySet();
//    	Iterator<String> iteratore = direzioni.iterator();
//    	while(iteratore.hasNext()) {
//			risultato.append(" " + iteratore.next());
//    	}
//    	risultato.append("\nAttrezzi nella stanza: ");
//		boolean esiste = false;
//    	for (Attrezzo attrezzo : this.attrezzi) {
//    		if (attrezzo!=null) {
//    			risultato.append(attrezzo.toString()+" ");
//    			esiste = true;
//    		}
//    	}
//    	if(esiste == false)
//        	risultato.append("nessuno!");
//    	return risultato.toString();
//    }
//
//    /**
//	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
//	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
//	*/
//	public boolean hasAttrezzo(String nomeAttrezzo) {
//		return this.getAttrezzo(nomeAttrezzo)!=null;
//	}
//
//	
//	/**
//     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
//	 * @param nomeAttrezzo
//	 * @return l'attrezzo presente nella stanza.
//     * 		   null se l'attrezzo non e' presente.
//	 */
//	public Attrezzo getAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
//		while(iteratore.hasNext()) {
//			a = iteratore.next();
//			if(a.getNome().equals(nomeAttrezzo)) {
//				return a;
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
//	 * @param nomeAttrezzo
//	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
//	 */
//	public boolean removeAttrezzo(Attrezzo attrezzo) {
//		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
//		while(iteratore.hasNext()) {
//			if(iteratore.next().getNome().equals(attrezzo.getNome())) {
//				iteratore.remove();
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	/**
//     * Restituisce la collezione di attrezzi presenti nella stanza.
//     * @return la collezione di attrezzi nella stanza.
//     */
//	public List<Attrezzo> getListaAttrezzi(){
//		List<Attrezzo> lista = new ArrayList<Attrezzo>();
//		lista.addAll(this.attrezzi);
//		return lista;
//	}
//
//	// Restituisce un Set con tutte le direzioni delle stanze adiacenti a questa
//	public Set<String> getDirezioni() {
//		return this.stanzeAdiacenti.keySet();
//    }
//	
//	// Restituisce una Map delle stanze adiacenti a questa
//	public Map<String,Stanza> getMapStanzeAdiacenti() {
//		return this.stanzeAdiacenti;
//    }
//	
//	@Override
//	public boolean equals(Object o) {
//		Stanza that = (Stanza)o;
//		return this.getNome().equals(that.getNome());
//	}
//	
//	/*public boolean getMagica() {
//		return this.magica;
//	}*/
//
//}

package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

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

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String, Attrezzo> nome2attrezzi;
	private int numeroAttrezzi;

	private Map<Direzione, Stanza> direzioni2stanze;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio personaggio;
	
	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni2stanze = new HashMap<>();
		this.nome2attrezzi = new HashMap<>();
	}

	public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : direzioni2stanze.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
	}

	public void setStanzeAdiacenti(Map<Direzione, Stanza> stanzeAdiacenti) {
		this.direzioni2stanze = stanzeAdiacenti;
	}

	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean aggiornato = false;
		if (direzioni2stanze.containsKey(direzione)) {
			this.direzioni2stanze.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni2stanze.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
		if (this.direzioni2stanze.containsKey(direzione))
			stanza = this.direzioni2stanze.get(direzione);
		return stanza;
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
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.nome2attrezzi.values();
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null && this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.nome2attrezzi.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
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
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {	
		return this.nome2attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.nome2attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.nome2attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null){
			return this.nome2attrezzi.remove(attrezzo.getNome(), attrezzo);

			
		}
		else
			return false;
	}


	public Set<Direzione> getDirezioni() {

		return direzioni2stanze.keySet();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}

	public void setPersonaggio(AbstractPersonaggio ap) {
		this.personaggio = ap;
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}


}