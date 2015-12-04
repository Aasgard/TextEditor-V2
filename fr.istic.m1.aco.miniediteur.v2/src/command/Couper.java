package command;

import receiver.MoteurEdition;

public class Couper implements Command {

	protected MoteurEdition me;
	
	/**
	 * Constructeur par défaut de la classe Couper.
	 * @param moteure : objet MoteurEdition
	 */
	public Couper(MoteurEdition moteure){
		me = moteure;
	}
	
	/**
	 * Appelle la fonction couper() du MoteurEdition de l'application.
	 * Option: trace Console du PressePapier
	 */
	public void execute(){
		me.couper();
		System.out.println("Commande COUPER : " + me.getPressePapier().getContenu().toString());
	}
	
}

