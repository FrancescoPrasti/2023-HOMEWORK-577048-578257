package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * 
 * Versione della stanza magica che estende la stanza con campi protetti e non privati.
 *
 */
public class StanzaMagicaProtected extends StanzaProtected{

	final static private int SOGLIA_MAGICA_DEFAULT = 3;

	private int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.attrezzi.size() > this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return this.attrezzi.add(attrezzo);
	}
}
