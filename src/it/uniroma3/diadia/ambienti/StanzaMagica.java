package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagica extends Stanza{

	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	
	 private int contatoreAttrezziPosati;  //memorizza il numero di attrezzi aggiunti
	 private int sogliaMagica;  // memorizza il numero di attrezzi da posare prima che si attivi il comportamento «magico» della stanza

	 
	 public StanzaMagica(String nome) {
	 this(nome, SOGLIA_MAGICA_DEFAULT);
	 }
	 
	 public StanzaMagica(String nome, int soglia) {
	 super(nome);
	 this.contatoreAttrezziPosati = 0;
	 this.sogliaMagica = soglia;
	 }
	
	/**
	 * Restituisce un attrezzo a partire dall'attrezzo passato come parametro;
	 * Modifica l'attrezzo passato come parametro invertendo il nome e raddoppiandone il peso.
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		 StringBuilder nomeInvertito;
		 int pesoX2 = attrezzo.getPeso() * 2;
		 nomeInvertito = new StringBuilder(attrezzo.getNome());
		 nomeInvertito = nomeInvertito.reverse();
		 attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		 return attrezzo;
		 }
	
	/**
	 * Se il numero di attrezzi nella stanza è maggiore della soglia,
	 * allora viene attivato l'effetto magicom della stanza.
	 */
	@Override
	 public boolean addAttrezzo(Attrezzo attrezzo) {
	 this.contatoreAttrezziPosati++;
	 if (this.contatoreAttrezziPosati>this.sogliaMagica)
	 attrezzo = this.modificaAttrezzo(attrezzo);
	 return super.addAttrezzo(attrezzo);
	 }

}
