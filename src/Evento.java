import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Evento {
	
	//attributi
	private String titolo;
	private String data;
	private int postiTotali;
	private int postiPrenotati;
	private LocalDate oggi = LocalDate.now();
	
	
	//costruttori (con overload)
	public Evento(String titolo, String data, int postiTotali) throws NullPointerException, IllegalArgumentException {
		super();
		
		//converto la data inserita
		LocalDate dataFormatoDate = convertiData(data);
		
		//controllo la data non sia nulla e il titolo
		if(dataFormatoDate == null) {
			throw new NullPointerException("La data dell'evento non è stata specificata o non è stata specificata correttamente");
		}
		
		if(!isValidTitolo(titolo)) {
			throw new NullPointerException("L'evento deve avere un titolo");
		}
		
		//controllo posti totali e validazione data
		if(!isValidPostiTotali(postiTotali)) {
			throw new IllegalArgumentException("I posti in sala devono avere un valore positivo");
		}
		
		if(!isValidData(data)) {
			throw new IllegalArgumentException("Non puoi creare un evento in una data passata");
		}
		
		//inizializzo il costruttore
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}
	
	public Evento(String titolo, String data, int postiTotali, int postiPrenotati) {
		super();
		
		//converto la data inserita
	    LocalDate dataFormatoDate = convertiData(data);
				
		//controllo la data non sia nulla e il titolo
		if(dataFormatoDate == null) {
			throw new NullPointerException("La data dell'evento non è stata specificata o non è stata specificata correttamente");
		}
				
		if(!isValidTitolo(titolo)) {
			throw new NullPointerException("L'evento deve avere un titolo");
		}
				
		//controllo posti totali e validazione data
		if(!isValidPostiTotali(postiTotali)) {
			throw new IllegalArgumentException("I posti in sala devono avere un valore positivo");
		}
		
		if(!isValidData(data)) {
			throw new IllegalArgumentException("Non puoi creare un evento in una data passata");
		}
				
		//inizializzo il costruttore
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = postiPrenotati;
	}
    
	
	
	//getters and setters
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws NullPointerException{
		if(!isValidTitolo(titolo)) {
			throw new NullPointerException("L'evento deve avere un titolo");
		}
		this.titolo = titolo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) throws NullPointerException, IllegalArgumentException {
		LocalDate dataFormatoDate = convertiData(data);
		
		if(dataFormatoDate == null) {
			throw new NullPointerException("La data dell'evento non è stata specificata o non è stata specificata correttamente");
		}
		
		if(!isValidData(data)) {
			throw new IllegalArgumentException("Non puoi creare un evento in una data passata");
		}
		
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	
	
	//metodi di validazione
	private boolean isValidPostiTotali(int postiTotali) {
		return (postiTotali > 0);
	}
	
	private boolean isValidTitolo(String titolo) {
		return (titolo != null);
	}
	
	private boolean isValidData(String data) {
		LocalDate dataFormatoDate = convertiData(data);
		return oggi.isBefore(dataFormatoDate);
	}
	
	
	
	//other methods
	private LocalDate convertiData(String dataInserita) {
		Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
		Matcher matcher = pattern.matcher(dataInserita);
		Boolean matchFound = matcher.find();
		
		LocalDate d = null;
		
		//valido la correttezza della data inserita, se no mi restiruirà d nullo che gestirò come eccezzione
		if(matchFound) {
			DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			d = LocalDate.parse(dataInserita, formatoData);
		}
		
		return d;
	}
	
	public void prenota() throws Exception{
		LocalDate dataFormatoDate = convertiData(data);
		if(oggi.isAfter(dataFormatoDate)) {
			throw new Exception("Non è possibile prenotare un evento passato");
		}else if(this.postiPrenotati == this.postiTotali) {
			throw new Exception("I posti per l'evento sono esauriti");
		}else {
			this.postiPrenotati ++;
		}
	}
	
	public void disdici() throws Exception{
		LocalDate dataFormatoDate = convertiData(data);
		if(oggi.isAfter(dataFormatoDate)) {
			throw new Exception("Non è possibile disdire un evento passato");
		} else if(this.postiPrenotati == 0) {
			throw new Exception("Non ci sono posti da disdire");
		} else {
			this.postiPrenotati --;
		}
	}
	
	
	
	//override
	@Override
	public String toString() {
		LocalDate dataFormatoDate = convertiData(data);
		return "Evento: " + dataFormatoDate + " - '" + titolo + "' - Posti disponibili: " + (postiTotali-postiPrenotati);
	}
	
	

}
