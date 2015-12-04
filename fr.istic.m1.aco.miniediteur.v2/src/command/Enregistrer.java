package command;

import caretaker.Enregistreur;

public class Enregistrer implements Command {
	
	private Enregistreur enregistreur;
	
	/**
	 * Constructeur par défaut de la classe Enregistrer.
	 * @param enregistreur : objet Enregistreur
	 */
	public Enregistrer(Enregistreur enregistreur){
		this.enregistreur = enregistreur;
	}
	
	/**
	 * Appel la fonction enregistrer().
	 */
	@Override
	public void execute() {
		enregistreur.enregistrer();
	}

}
