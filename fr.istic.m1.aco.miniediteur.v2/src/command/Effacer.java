package command;

import receiver.MoteurEdition;

public class Effacer extends Command {
	
	public Effacer(MoteurEdition newem){
		me = newem;
	}
	
	@Override
	public void execute() {	
		me.effacer();
		System.out.println("EFFACER : "+me.getBuffer().getContenu().toString());
	}

}
