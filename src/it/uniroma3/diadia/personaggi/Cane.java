package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private static final String MESSAGGIO_MORSO = "Il cane ti ha morso! " +
			"Hai perso 1 CFU!";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg = this.MESSAGGIO_MORSO;
		
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		if(attrezzo.getNome().equals("osso")) {
			partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("spada", 1));
			msg = "Il cane adora l'osso! Ti ha donato una spada di peso 1!";
		}else {
			msg = this.agisci(partita) + "Prova a dargli il suo cibo preferito!";
		}
		return msg;
	}

}
