package originator;
import caretaker.*;
import command.Couper;
import memento.Memento;
import memento.MementoCouper;
import receiver.MoteurEdition;

public class CouperEnregistrable extends Couper implements CommandEnregistrable {

	private Enregistreur enregistreur;
	
	public CouperEnregistrable(MoteurEdition newem, Enregistreur enregistreur) {
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
		return new MementoCouper();
	}

	@Override
	public void setMemento(Memento m) {
		super.execute();
	}

}
