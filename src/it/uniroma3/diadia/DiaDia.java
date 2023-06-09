package it.uniroma3.diadia;


import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

import java.io.FileNotFoundException;
import java.util.*;

import it.uniroma3.diadia.ambienti.*;

/*import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;*/

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

	private Partita partita;
	private IO io;
	private Labirinto lab;

	//Costruttore classe DiaDia
	public DiaDia(IO io, Labirinto l) {
		this.lab = l;
		this.partita = new Partita(lab);
		this.io = io;
	}

	public void gioca() {

		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);  //Stampa il messaggio di benvenuto appena eseguito diadia

		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {

		Comando comandoDaEseguire;

		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita, this.io);
		
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		else if(this.partita.getGiocatore().getCfu() == 0)  //Se finiscono i CFU, la partita finisce
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();

	}

	public static void main(String[] argc) throws Exception {

		try(Scanner scanner = new Scanner(System.in)){
		IO io = new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();

		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		}
	}
}