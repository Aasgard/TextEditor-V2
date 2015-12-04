package originator;

import caretaker.Enregistreur;
import command.Coller;
import memento.Memento;
import memento.MementoColler;
import receiver.MoteurEdition;

public class CollerEnregistrable extends Coller implements CommandEnregistrable  {

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur de la commande enregistrable Coller.
	 * H�rite de la commande Coller.
	 * Initialise l'enregistreur.
	 * @param newem
	 * @param enregistreur
	 */
	public CollerEnregistrable(MoteurEdition newem, Enregistreur enregistreur){
		super(newem);
		this.enregistreur = enregistreur;
	}
	
	/**
	 * Appel � la fonction execute de la classe m�re : Coller.
	 * Puis appel la fonction enregistrer(CommandeEnregistrable) de l'enregistreur.
	 */
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}

	/**
	 * R�cup�re le memento correspondant � la commande Enregistrable.
	 * @return MementoColler
	 */
	@Override
	public Memento getMemento() {
		return new MementoColler();
	}

	/**
	 * Permet de rejouer la commande du Memento en appelant la fonctione execute de la classe m�re : Coller.
	 * @param Memento
	 */
	@Override
	public void setMemento(Memento m) {
		super.execute();
	}

}
