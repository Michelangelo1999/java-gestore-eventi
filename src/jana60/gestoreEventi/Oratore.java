package jana60.gestoreEventi;

public class Oratore {
	
	private String nome;
	private String cognome;
	private String titolo;
	
	public Oratore(Oratore oratore) {
		this.nome = oratore.getNome();
		this.cognome = oratore.getCognome();
		this.titolo = oratore.getTitolo();
	}
	
	public Oratore(String nome, String cognome, String titolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
	}
	
	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTitolo() {
		return titolo;
	}

	public String toString() {
		return nome + " " + cognome + " - " + titolo; 
	}

}
