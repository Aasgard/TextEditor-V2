package originator;

import caretaker.Enregistreur;
import command.Coller;
import memento.Memento;
import memento.MementoColler;
import receiver.MoteurEdition;

public class CollerEnregistrable extends Coller implements CommandEnregistrable  {

	private Enregistreur enregistreur;
	
	public CollerEnregistrable(MoteurEdition newem, Enregistreur enregistreur){
		super(newem);
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}

	@Override
	public Memento getMemento() {
		return new MementoColler();
	}

	@Override
	public void setMemento(Memento m) {
		super.execute();
	}

}
