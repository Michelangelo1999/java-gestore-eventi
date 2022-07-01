package jana60.gestoreEventi;

public class Conferenza extends Evento {
	
	private String argomento;
	private Oratore oratore;
	
	//costruttori con overload
	public Conferenza() {
		super();
		
		this.argomento = null;
		this.oratore = new Oratore(null, null, null);
	}
	
	public Conferenza(String titolo, String data, int postiTotali, int postiPrenotati, String argomento, Oratore oratore) {
		super(titolo, data, postiTotali, postiPrenotati);
		
		this.argomento = argomento;
		this.oratore = new Oratore(oratore);
	}
	public Conferenza(String titolo, String data, int postiTotali, String argomento, Oratore oratore) {
		super(titolo, data, postiTotali);
		
		this.argomento = argomento;
		this.oratore = new Oratore(oratore);
	}
	
	//override
	@Override
	public String toString() {
		return super.toString() + " - " + argomento + "; " + "\n" + oratore;
	}

}
