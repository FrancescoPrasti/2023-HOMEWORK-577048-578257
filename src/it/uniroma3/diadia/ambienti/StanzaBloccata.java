package it.uniroma3.diadia.ambienti;



public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String attrezzoSblocca;

	public StanzaBloccata(String nome, String attrezzoSblocca, String direzione) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSblocca = attrezzoSblocca;
	}

	/**
	 * Ritorna la stanza adiacente nella direzione indicata;
	 * Se la direzione è quella bloccata, e nella stanza non c'è l'attrezzo che la sblocca,
	 * allora ritorna un riferimento alla stanza corrente.
	 */
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {

		if(dir.equals(this.direzioneBloccata)) {
			if(this.hasAttrezzo(attrezzoSblocca) == false)
				return this;
		}
		return super.getStanzaAdiacente(dir);
		
	}
	
	/**
	 * Ritorna una descrizione della stanza.
	 */
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoSblocca))
			return super.toString();
		else
			return super.toString() + "\nDirezione " + this.direzioneBloccata + " bloccata";
	}
	
	public boolean isBloccata() {
		return true;
	}
	
	public String getAttrezzoSblocca() {
		return this.attrezzoSblocca;
	}
	
	public String getDirezioneBloccata() {
		return this.direzioneBloccata;
	}
	
	@Override
	public boolean equals(Object o) {
		//StanzaBloccata that = (StanzaBloccata)o;
		//return this.getNome().equals(that.getNome()) && this.getAttrezzoSblocca().equals(that.getAttrezzoSblocca()) && this.getDirezioneBloccata().equals(that.getDirezioneBloccata());
		return super.equals(o);
	}
	 
	
	
	@Override
	public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.getNome());
    	return risultato.toString();
	}
}
