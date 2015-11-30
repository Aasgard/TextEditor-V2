package command;

import caretaker.Enregistreur;

public class Stop implements Command {

	private Enregistreur enregistreur;
	
	public Stop(Enregistreur enregistreur){
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		enregistreur.stopperEnr();
	}

}
