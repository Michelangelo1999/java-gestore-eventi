package jana60.gestoreEventi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Benvenuto alla pagina di pubblicazione dei nuovi eventi.");
		System.out.println("Quanti eventi vuoi indire?");
		int numeroEventi = Integer.parseInt(scan.nextLine());
		
		Evento[] catalogoEventi = new Evento[numeroEventi];
		
		for(int i = 0; i < numeroEventi; i++) {
			Evento newEvent;
			boolean keepPlanning = false;
			
			do {
				//int numero = i+1;
				System.out.println("titolo dell'evento: ");
				String titolo = scan.nextLine();
				System.out.println("data dell'evento (yyyy-mm-dd): ");
				String data = scan.nextLine();
				System.out.println("capienza totale: ");
				int postiTotali = Integer.parseInt(scan.nextLine());
				System.out.println("ci sono già dei posti riservati? yes | no");
				String answer = scan.nextLine();
				int postiPrenotati = 0;
				if (answer.equalsIgnoreCase("yes")) {
					System.out.println("numero posti riservati: ");
					postiPrenotati = Integer.parseInt(scan.nextLine());
				}
				newEvent = new Evento();
				try {
					if (answer.equalsIgnoreCase("yes")) {
						newEvent = new Evento(titolo, data, postiTotali, postiPrenotati);
					} else {
						newEvent = new Evento(titolo, data, postiTotali);
					}
				} catch (NullPointerException npe) {
					System.out.println("Errore: " + npe.getMessage());
					keepPlanning = true;
				} catch (IllegalArgumentException iae) {
					System.out.println("Errore: " + iae.getMessage());
					keepPlanning = true;
				} 
			} while (keepPlanning);
			System.out.println("Vuoi effettuare delle prenotazioni? Yes | no");
			String answer2 = scan.nextLine();
			int numeroPrenotazioni = 0;
			if(answer2.equalsIgnoreCase("yes")) {
				System.out.println("quante prenotazioni vuoi effettuare?");
				numeroPrenotazioni = Integer.parseInt(scan.nextLine());
			
			try {
				for(int j = 0; j < numeroPrenotazioni; j++) {
					newEvent.prenota();
				}
			} catch(Exception e) {
				System.out.println("Errore: " + e.getMessage());
			}
			}
			
			System.out.println();
			System.out.println("Posti disponibili: " + (newEvent.getPostiTotali() - newEvent.getPostiPrenotati()));
			System.out.println("Posti prenotati: " + newEvent.getPostiPrenotati());
			
			System.out.println("vuoi disdire delle prenotazioni? yes | no");
			String answer3 = scan.nextLine();
			int numeroCancellazioni = 0;
			
			if(answer3.equalsIgnoreCase("yes")) {
				System.out.println("quante prenotazioni vuoi cancellare?");
				numeroCancellazioni = Integer.parseInt(scan.nextLine());
				
				try {
					for(int k = 0; k < numeroCancellazioni; k++) {
						newEvent.disdici();
					}
				} catch (Exception e) {
					System.out.println("Errore: " + e.getMessage());
				}
			}
			
			System.out.println();
			System.out.println("Posti disponibili: " + (newEvent.getPostiTotali() - newEvent.getPostiPrenotati()));
			System.out.println("Posti prenotati: " + newEvent.getPostiPrenotati());
			
			catalogoEventi[i] = newEvent;
			
		}
		
		System.out.println("Lista eventi: ");
		for(int i = 0; i < catalogoEventi.length; i++) {
			System.out.println(catalogoEventi[i]);
		}
		
		scan.close();
		

	}

}
