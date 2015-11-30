package originator;

import caretaker.Enregistreur;
import command.Effacer;
import memento.Memento;
import memento.MementoEffacer;
import receiver.MoteurEdition;

public class EffacerEnregistrable extends Effacer implements CommandEnregistrable {

	private Enregistreur enregistreur;

	public EffacerEnregistrable(MoteurEdition newem, Enregistreur enregistreur) {
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
		return new MementoEffacer();
	}

	@Override
	public void setMemento(Memento m) {
		super.execute();
	}


}
