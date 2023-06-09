package it.uniroma3.diadia.personaggi;

import java.util.Collection;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	private static final String MESSAGGIO_SALUTATO = "La strega ti premia trasferendoti in un'altra stanza " +
			"adiacente a questa, che tra l'altro è quella che contiene più attrezzi!" + 
			"\nOra ti trovi nella stanza:\n";
	
	private static final String MESSAGGIO__NON_SALUTATO = "La strega ti premia trasferendoti in un'altra stanza " +
			"adiacente a questa, ma ,dato che non l'hai salutata, è quella che contiene meno attrezzi!" + 
			"\nOra ti trovi nella stanza:\n";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();

		Stanza maggiore = stanzeAdiacenti.get(0);
		Stanza minore = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maggiore.getNumeroAttrezzi())
					maggiore = s;
				if(s.getNumeroAttrezzi() < maggiore.getNumeroAttrezzi())
					maggiore = s;
			}
		}
		
		if(this.haSalutato()) {
			partita.setStanzaCorrente(maggiore);
			msg = this.MESSAGGIO_SALUTATO + partita.getStanzaCorrente().toString();
		}else {
			partita.setStanzaCorrente(minore);
			msg = this.MESSAGGIO__NON_SALUTATO + partita.getStanzaCorrente().toString();
		}
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "La strega si è tenuta il regalo e se la ride!";
	}
	
}
