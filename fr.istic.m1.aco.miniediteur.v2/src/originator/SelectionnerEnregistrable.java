package originator;

import caretaker.Enregistreur;
import command.Selectionner;
import invoker.IHM;
import memento.Memento;
import memento.MementoSelectionner;
import receiver.MoteurEdition;

public class SelectionnerEnregistrable extends Selectionner implements CommandEnregistrable{

	private Enregistreur enregistreur;
	
	public SelectionnerEnregistrable(MoteurEdition em, IHM newihm, Enregistreur enregistreur) {
		super(em, newihm);
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);	
	}
	
	@Override
	public Memento getMemento() {
		System.out.println("Création memento selection : "+me.getSelection().getDebut());
		return new MementoSelectionner(me.getSelection().getDebut(), me.getSelection().getLongueur());
	}

	@Override
	public void setMemento(Memento memento) {
		MementoSelectionner mem = (MementoSelectionner) memento;
		System.out.println("Récupération de la selection : "+mem.getDebutSelection());
		me.selectionner(mem.getDebutSelection(), mem.getLongueurSelection());
	}

}
