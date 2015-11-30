package command;

import receiver.MoteurEdition;

public class Coller implements Command {
	
	protected MoteurEdition me;

	public Coller(MoteurEdition moteure){
		me = moteure;
	}
	
	public void execute(){
		me.coller();
		System.out.println("Commande COLLER : " + me.getBuffer().getContenu().toString());
	}
	
}
