package originator;
import memento.Memento;

public interface Enregistrable {

		Memento getMemento();
		void setMemento(Memento memento);
}
