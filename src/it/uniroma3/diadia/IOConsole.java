package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO{

	Scanner scannerDiLinee;

	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
		}

	//Metodo che serve per stampare un messaggio a schermo.
	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	//Metodo che serve a prendere in imput qualcosa dall'utente.
	@Override
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;

	}
}
