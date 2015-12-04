package command;

import receiver.MoteurEdition;

public class Coller implements Command {

	protected MoteurEdition me;
	/**
	 * Constructeur par défaut de la classe Coller.
	 * @param moteure : objet MoteurEdition
	 */
	public Coller(MoteurEdition moteure){
		me = moteure;
	}
	
	/**
	 * Appelle la fonction coller() du MoteurEdition de l'application.
	 * Option: trace Console du Buffer
	 */
	public void execute(){
		me.coller();
		System.out.println("Commande COLLER : " + me.getBuffer().getContenu().toString());
	}
	
}
