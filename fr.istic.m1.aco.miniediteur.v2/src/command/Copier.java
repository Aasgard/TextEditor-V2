package command;

import receiver.MoteurEdition;

public class Copier implements Command {
	
	protected MoteurEdition me;

	/**
	 * Constructeur par défaut de la classe Copier.
	 * @param moteure : objet MoteurEdition
	 */
	public Copier(MoteurEdition moteure){
		me = moteure;
	}
	
	/**
	 * Appelle la fonction copier() du MoteurEdition de l'application.
	 * Option: trace Console du PressePapier
	 */
	public void execute(){
		me.copier();
		System.out.println("Commande COPIER : " + me.getPressePapier().getContenu().toString());
	}
	
}