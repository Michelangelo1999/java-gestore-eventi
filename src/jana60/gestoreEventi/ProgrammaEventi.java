package jana60.gestoreEventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProgrammaEventi {

	public static void main(String[] args) {
		
		List<Evento> listaEventi = new ArrayList<Evento>();
		
		listaEventi.add(new Evento("Primo spettacolo Thor L&T", "2022-07-06", 150));
		listaEventi.add(new Evento("Conferenza calciomercato Napoli", "2022-08-01", 25));
		listaEventi.add(new Evento("Prima di campiomato", "2022-08-12", 1000));
		listaEventi.add(new Evento("Esame meccanica applicata", "2022-09-15", 100));
		listaEventi.add(new Evento("Discussione progetto basi di dati", "2022-07-27", 100));
		listaEventi.add(new Evento("Organizzazione viaggio vacanze", "2022-07-27", 4));
		listaEventi.add(new Evento("Vacanze di natale", "2022-12-20", 10));
		
		System.out.println("lista non ordinata: ");
		for(Evento e : listaEventi) {
			System.out.println(e);
		}
		
		//Collections.sort(listaEventi);
		
		System.out.println("lista ordinata: ");
		for(Evento e : listaEventi) {
			System.out.println(e);
		}
		
		Iterator<Evento> iter = listaEventi.iterator();
		
		List<Evento> eventiProssimi = new ArrayList<Evento>();
		List<Evento> eventiFuturi = new ArrayList<Evento>();
		
		LocalDate oggi = LocalDate.now();
		LocalDate monthFromToday = oggi.plusDays(30);
		
		while(iter.hasNext()) {
			Evento eventoCorrente = iter.next();
			
			if(eventoCorrente.convertiData(eventoCorrente.getData()).compareTo(monthFromToday) > 0) {
				eventiFuturi.add(eventoCorrente);
			}else {
				eventiProssimi.add(eventoCorrente);
			}
			
		}
		
		System.out.println();
		
		System.out.println("lista eventi prossimi: ");
		for(Evento e : eventiProssimi) {
			System.out.println(e);
		}
		
		System.out.println("lista eventi futuri: ");
		for(Evento e : eventiFuturi) {
			System.out.println(e);
		}

	}

}
