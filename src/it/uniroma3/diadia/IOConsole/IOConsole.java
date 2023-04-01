package it.uniroma3.diadia.IOConsole;
import java.util.Scanner;

public class IOConsole {
	
	//Metodo che serve per stampare un messaggio a schermo.
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	//Metodo che serve a prendere in imput qualcosa dall'utente.
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		return riga;
		
	}
}
