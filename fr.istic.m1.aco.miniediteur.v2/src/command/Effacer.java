package command;

import receiver.MoteurEdition;

public class Effacer implements Command {
	
	protected MoteurEdition me;
	
	/**
	 * Constructeur par défaut de la classe Effacer.
	 * @param newem : objet MoteurEdition
	 */
	public Effacer(MoteurEdition newem){
		me = newem;
	}
	
	/**
	 * Appelle la fonction effacer() du MoteurEdition de l'application.
	 * Option: trace Console du Buffer
	 */
	public void execute() {	
		me.effacer();
		System.out.println("EFFACER : "+me.getBuffer().getContenu().toString());
	}

}
