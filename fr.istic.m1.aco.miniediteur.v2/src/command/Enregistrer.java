package command;

import caretaker.Enregistreur;

public class Enregistrer implements Command {
	
	private Enregistreur enregistreur;
	
	public Enregistrer(Enregistreur enregistreur){
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.enregistrer();
	}

}
