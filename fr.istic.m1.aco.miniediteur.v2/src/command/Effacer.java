package command;

import receiver.MoteurEdition;

public class Effacer implements Command {
	
	protected MoteurEdition me;
	
	public Effacer(MoteurEdition newem){
		me = newem;
	}
	
	@Override
	public void execute() {	
		me.effacer();
		System.out.println("EFFACER : "+me.getBuffer().getContenu().toString());
	}

}
