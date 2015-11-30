package command;

import invoker.IHM;
import receiver.MoteurEdition;

public class Saisir implements Command {
	
	protected MoteurEdition me;
	protected IHM ihm;

	public Saisir(MoteurEdition moteure,IHM ihmn){
		me = moteure;
		ihm = ihmn;
	}
	
	public void execute(){
		String texte = String.valueOf(ihm.getCar());
		System.out.println("Caractère ajouté : " + texte);
		System.out.println("Contenu du buffer : " + me.getBuffer().getContenu().toString());
		me.saisir(texte);
	}
	
}
