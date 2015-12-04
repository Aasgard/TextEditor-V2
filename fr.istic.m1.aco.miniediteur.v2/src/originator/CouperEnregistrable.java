package originator;
import caretaker.*;
import command.Couper;
import memento.Memento;
import memento.MementoCouper;
import receiver.MoteurEdition;

public class CouperEnregistrable extends Couper implements CommandEnregistrable {

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur de la commande enregistrable Couper.
	 * Hérite de la commande Couper.
	 * Initialise l'enregistreur.
	 * @param newem
	 * @param enregistreur
	 */
	public CouperEnregistrable(MoteurEdition newem, Enregistreur enregistreur) {
		super(newem);
		this.enregistreur = enregistreur;
	}
	
	/**
	 * Appel à la fonction execute de la classe mère : Couper.
	 * Puis appel la fonction enregistrer(CommandeEnregistrable) de l'enregistreur.
	 */
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}
	
	/**
	 * Récupère le memento correspondant à la commande Enregistrable.
	 * @return MementoCouper
	 */
	@Override
	public Memento getMemento() {
		return new MementoCouper();
	}

	/**
	 * Permet de rejouer la commande du Memento en appelant la fonctione execute de la classe mère : Couper.
	 * @param Memento
	 */
	@Override
	public void setMemento(Memento m) {
		super.execute();
	}

}
