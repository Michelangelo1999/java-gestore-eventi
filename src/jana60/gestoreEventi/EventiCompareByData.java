package jana60.gestoreEventi;

import java.util.Comparator;

public class EventiCompareByData implements Comparator<Evento> {

	@Override
	public int compare(Evento e1, Evento e2) {
		
		if (!e1.getData().equalsIgnoreCase(e2.getData())) {
			return e1.convertiData(e1.getData()).compareTo(e2.convertiData(e2.getData()));
		} else {
			return e1.getTitolo().compareTo(e2.getTitolo());
		}
	}

}
