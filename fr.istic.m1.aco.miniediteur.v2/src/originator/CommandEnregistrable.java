package originator;

import command.Command;
import memento.Memento;

public interface CommandEnregistrable extends Command, Enregistrable {

	public void execute();
	public Memento getMemento();
	public void setMemento(Memento m);
	
}
