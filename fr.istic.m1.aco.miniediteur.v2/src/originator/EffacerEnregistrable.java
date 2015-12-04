package originator;

import caretaker.Enregistreur;
import command.Effacer;
import memento.Memento;
import memento.MementoEffacer;
import receiver.MoteurEdition;

public class EffacerEnregistrable extends Effacer implements CommandEnregistrable {

	private Enregistreur enregistreur;

	/**
	 * Constructeur de la commande enregistrable Effacer.
	 * H�rite de la commande Effacer.
	 * Initialise l'enregistreur.
	 * @param newem
	 * @param enregistreur
	 */
	public EffacerEnregistrable(MoteurEdition newem, Enregistreur enregistreur) {
		super(newem);
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel � la fonction execute de la classe m�re : Effacer.
	 * Puis appel la fonction enregistrer(CommandeEnregistrable) de l'enregistreur.
	 */
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}

	/**
	 * R�cup�re le memento correspondant � la commande Enregistrable.
	 * @return MementoEffacer
	 */
	@Override
	public Memento getMemento() {
		return new MementoEffacer();
	}

	/**
	 * Permet de rejouer la commande du Memento en appelant la fonctione execute de la classe m�re : Effacer.
	 * @param Memento
	 */
	@Override
	public void setMemento(Memento m) {
		super.execute();
	}


}
