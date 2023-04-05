package it.uniroma3.diadia;


import it.uniroma3.diadia.IOConsole.IOConsole;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole IO;

	//Costruttore classe DiaDia
	public DiaDia(IOConsole IO) {
		this.partita = new Partita();
		this.IO = IO;
	}

	public void gioca() {
		
		String istruzione; 
		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);  //Stampa il messaggio di benvenuto appena eseguito diadia
		
		do		
			istruzione = IO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		String nomeIstruzione = comandoDaEseguire.getNome();
		
		if("fine".equals(nomeIstruzione)) { 
			this.fine(); 
			return true;
		} else {
			
			String parametroIstruzione = comandoDaEseguire.getParametro();
			
			if ("vai".equals(nomeIstruzione))
				this.vai(parametroIstruzione);
			
			else if ("aiuto".equals(nomeIstruzione))
				this.aiuto();
			
			else if ("prendi".equals(nomeIstruzione))
				this.prendiAttrezzo(parametroIstruzione);
			
			else if ("posa".equals(nomeIstruzione))
				this.posaAttrezzo(parametroIstruzione);
			
			else
				IO.mostraMessaggio("Comando sconosciuto");  //Stampa se l'utente mette qualche comando diverso dagli ammissibili (compreso il semplice tasto invio).
		}
		if (this.partita.vinta()) {  //Se true stampa il messaggio di vittoria e termina la partita.
			IO.mostraMessaggio("Hai vinto!");
			return true;
			
		}else if(this.partita.getGiocatore().getCfu() == 0) {
			IO.mostraMessaggio("CFU terminati...mi dispiace, hai perso!");
			return true;
		} else  //Altrimenti continua.
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	// Meetodo che permette al giocatore di rimuovere un attrezzo dalla stanza in cui si trova e di inserirlo nella borsa.
	private void prendiAttrezzo(String nomeAttrezzo) {
		
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		if(stanzaCorrente.getNumeroAttrezzi() == 0)
			IO.mostraMessaggio("Questa stanza non contiene attrezzi!");
		else {
			if(nomeAttrezzo == null) {  //Entro nell'if se l'utente inserisce solo "prendi" senza specificare il nome dell'attrezzo.
				IO.mostraMessaggio("Quale attrezzo vuoi prendere dalla stanza?");
				nomeAttrezzo = IO.leggiRiga();
			}
			
			if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
				Attrezzo attrezzo = null;
				attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
				
				if(this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo) == true) {  //Se l'inserimento dell'attrezzo nella borsa va a buon fine entro.
				
					if(stanzaCorrente.removeAttrezzo(attrezzo) == true) {
						IO.mostraMessaggio("L'attrezzo è stato rimosso dalla stanza!");
						IO.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());  //Stampo a schermo il contenuto della borsa.
					}else
						IO.mostraMessaggio("L'attrezzo non è stato rimosso dalla stanza!");
				}else
					IO.mostraMessaggio("Non c'è spazio nella borsa o possiedi già 10 attrezzi!");
			}else
				IO.mostraMessaggio("La stanza non contiene l'attrezzo che cerchi!");
		}
	}
	
	
	// Metodo che permette al giocatore di rimuovere un attrezzo dalla borsa e di posarlo nella stanza in cui si trova.
	private void posaAttrezzo(String nomeAttrezzo) {
		
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		if(borsa.getNumeroAttrezzi()== 0)
			IO.mostraMessaggio("La borsa non contiene attrezzi!");
		else {
			Stanza stanzaCorrente = this.partita.getStanzaCorrente();
			if(stanzaCorrente.getNumeroAttrezzi() > 9)  //Ho raggiunto la capienza massima della stanza, cioè 10 attrezzi.
				IO.mostraMessaggio("La stanza dove ti trovi non può contenere ulteriori attrezzi!");
			else {
				if(nomeAttrezzo == null) {  //Entro nell'if se l'utente inserisce solo "prendi" senza specificare il nome dell'attrezzo.
					IO.mostraMessaggio("Quale attrezzo vuoi posare nella stanza?");
					nomeAttrezzo = IO.leggiRiga();
				}
				if(borsa.hasAttrezzo(nomeAttrezzo)) {
					
					if(stanzaCorrente.addAttrezzo(borsa.removeAttrezzo(nomeAttrezzo)) == true) {  //L'attrezzo viene rimosso dalla borsa e inserito nella stanza.
						IO.mostraMessaggio("L'attrezzo è stato posato nella stanza!");
					}else
						IO.mostraMessaggio("L'attrezzo NON è stato posato nella stanza!");
				}else
					IO.mostraMessaggio("Nella borsa non hai questo attrezzo!");
			}
		}
		
	}
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		
		if(direzione==null) {  //Entro nell'if se l'utente inserisce solo "vai" senza specificare la direzione.
			IO.mostraMessaggio("Dove vuoi andare ?");
			direzione = IO.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		
		Giocatore giocatore = this.partita.getGiocatore();
		if (prossimaStanza == null)
			IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = giocatore.getCfu();
			giocatore.setCfu(--cfu);  //Aggiorno i cfu del giocatore, diminuendoli di 1.				
		}
		IO.mostraMessaggio("CFU rimanenti: " + giocatore.getCfu() + "\n" + this.partita.getStanzaCorrente().getDescrizione() + "Attrezzi contenuti nella stanza: " + this.partita.getStanzaCorrente().getNumeroAttrezzi()); //Stampo descrizione della situazione della partita.
		if(!this.partita.vinta() && this.partita.isFinita())
			IO.mostraMessaggio("CFU terminati...mi dispiace, hai perso!");
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		
		IOConsole IO = new IOConsole();
		
		DiaDia gioco = new DiaDia(IO);
		gioco.gioca();
	}
}
