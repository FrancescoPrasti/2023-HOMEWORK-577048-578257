package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoSblocca;
	
	public StanzaBuia(String nome,String attrezzo) {
		super(nome);
		this.attrezzoSblocca = attrezzo;
	}
	
	/**
	 * Produce la descrizione usuale della stanza o la stringa "qui c'è buio pesto"
	 * a seconda che nella stanza ci sia o meno l'attrezzo richiesto per "vedere"
	 */
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoSblocca))
			return this.toString();
		else
			return "Qui c'è buio pesto";
	}
	
	public boolean isBuia() {
		return true;
	}
	
}
