package command;

import receiver.MoteurEdition;

public class Copier implements Command {
	
	protected MoteurEdition me;

	public Copier(MoteurEdition moteure){
		me = moteure;
	}
	
	public void execute(){
		me.copier();
		System.out.println("Commande COPIER : " + me.getPressePapier().getContenu().toString());
	}
	
}
