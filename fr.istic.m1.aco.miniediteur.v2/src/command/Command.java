package command;

import invoker.IHM;
import receiver.MoteurEdition;

public abstract class Command {

	protected MoteurEdition me;
	protected IHM ihm;
	
	public abstract void execute();
	
}
