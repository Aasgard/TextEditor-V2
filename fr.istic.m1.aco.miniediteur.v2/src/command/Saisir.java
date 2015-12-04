package command;

import invoker.IHM;
import receiver.MoteurEdition;

public class Saisir implements Command {
	
	protected MoteurEdition me;
	protected IHM ihm;

	/**
	 * Constructeur par défaut de la classe Saisir.
	 * @param moteure : objet MoteurEdition
	 * @param ihmn : objet IHM
	 */
	public Saisir(MoteurEdition moteure,IHM ihmn){
		me = moteure;
		ihm = ihmn;
	}
	
	/**
	 * Appelle la fonction saisir(String text) du MoteurEdition de l'application.
	 * Option: trace Console du Buffer, du caractère ajouté (casté en String)
	 */
	public void execute(){
		String texte = String.valueOf(ihm.getCar());
		System.out.println("Caractère ajouté : " + texte);
		System.out.println("Contenu du buffer : " + me.getBuffer().getContenu().toString());
		me.saisir(texte);
	}
	
}
