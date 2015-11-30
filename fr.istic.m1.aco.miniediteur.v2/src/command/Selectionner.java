package command;

import invoker.IHM;
import receiver.MoteurEdition;

public class Selectionner implements Command {

	protected MoteurEdition me;
	protected IHM ihm;
	
	public Selectionner(MoteurEdition moteure, IHM newihm){
		this.me = moteure;
		this.ihm = newihm;
	}
	
	public void execute() {
		int debut = ihm.getDebutSelection();
		int fin = ihm.getLongueurSelection();
		System.out.println("Début de Sélection : " + debut);
		me.selectionner(debut, fin);
	}

}
