package command;

import caretaker.Enregistreur;

public class Stop implements Command {

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur par défaut de la classe Stop.
	 * @param enregistreur : objet Enregistreur
	 */
	public Stop(Enregistreur enregistreur){
		this.enregistreur = enregistreur;
	}
	/**
	 * Appelle la fonction stopperEnr().
	 */
	@Override
	public void execute() {
		enregistreur.stopperEnr();
	}

}
