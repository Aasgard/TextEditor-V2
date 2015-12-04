package command;

import caretaker.Enregistreur;

public class Rejouer implements Command {
	
	private Enregistreur enregistreur;
	
	/**
	 * Constructeur par d�faut de la classe Rejouer.
	 * @param enregistreur : objet Enregistreur
	 */
	public Rejouer(Enregistreur enregistreur){
		this.enregistreur = enregistreur;
	}
	
	
	/**
	 * Appel la fonction rejouer().
	 */
	@Override
	public void execute() {
		enregistreur.rejouer();
	}

}
