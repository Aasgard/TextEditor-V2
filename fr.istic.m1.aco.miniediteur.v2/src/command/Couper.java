package command;

import receiver.MoteurEdition;

public class Couper extends Command {

	public Couper(MoteurEdition moteure){
		me = moteure;
	}
	
	public void execute(){
		me.couper();
		System.out.println("Commande COUPER : " + me.getPressePapier().getContenu().toString());
	}
	
}
