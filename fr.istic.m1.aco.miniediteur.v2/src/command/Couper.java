package command;

import receiver.MoteurEdition;

public class Couper implements Command {

	protected MoteurEdition me;
	
	public Couper(MoteurEdition moteure){
		me = moteure;
	}
	
	public void execute(){
		me.couper();
		System.out.println("Commande COUPER : " + me.getPressePapier().getContenu().toString());
	}
	
}
