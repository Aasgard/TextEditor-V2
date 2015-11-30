package originator;

import caretaker.Enregistreur;
import command.Saisir;
import invoker.IHM;
import memento.Memento;
import memento.MementoSaisir;
import receiver.MoteurEdition;

public class SaisirEnregistrable extends Saisir implements CommandEnregistrable {

	private Enregistreur enregistreur;
	
	public SaisirEnregistrable(MoteurEdition newem, IHM newihm, Enregistreur enregistreur) {
		super(newem, newihm);
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}
	
	@Override
	public Memento getMemento() {
		System.out.println(String.valueOf(ihm.getCar()));
		Memento m = new MementoSaisir(String.valueOf(ihm.getCar()));
		return m;
	}

	@Override
	public void setMemento(Memento m) {
		String texte = ((MementoSaisir) m).getTexte();
		me.saisir(texte);
	}


}
