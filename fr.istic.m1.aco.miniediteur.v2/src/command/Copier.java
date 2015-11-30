package command;

import receiver.MoteurEdition;

public class Copier extends Command {

	public Copier(MoteurEdition moteure){
		me = moteure;
	}
	
	public void execute(){
		me.copier();
		System.out.println("Commande COPIER : " + me.getPressePapier().getContenu().toString());
	}
	
}
