package command;

import caretaker.Enregistreur;

public class Rejouer implements Command {
	
	private Enregistreur enregistreur;
	
	public Rejouer(Enregistreur enregistreur){
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.rejouer();
	}

}
