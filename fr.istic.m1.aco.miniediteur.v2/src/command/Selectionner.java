package command;

import invoker.IHM;
import receiver.MoteurEdition;

public class Selectionner implements Command {

	protected MoteurEdition me;
	protected IHM ihm;
	
	/**
	 * Constructeur par défaut de la classe Selectionner.
	 * @param moteure : objet MoteurEdition
	 * @param newihm : objet IHM
	 */
	public Selectionner(MoteurEdition moteure, IHM newihm){
		this.me = moteure;
		this.ihm = newihm;
	}
	
	/**
	 * Appelle la fonction selectionner(int debut, int fin).
	 * Récupération du début et fin de la sélection auprès de l'IHM.
	 * Option: trace de la Sélection
	 */
	public void execute() {
		int debut = ihm.getDebutSelection();
		int fin = ihm.getLongueurSelection();
		System.out.println("Début de Sélection : " + debut);
		me.selectionner(debut, fin);
	}

}

