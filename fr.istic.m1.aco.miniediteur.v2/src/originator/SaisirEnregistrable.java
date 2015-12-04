package originator;

import caretaker.Enregistreur;
import command.Saisir;
import invoker.IHM;
import memento.Memento;
import memento.MementoSaisir;
import receiver.MoteurEdition;

public class SaisirEnregistrable extends Saisir implements CommandEnregistrable {

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur de la commande enregistrable Saisir.
	 * Hérite de la commande Saisir.
	 * Initialise l'enregistreur.
	 * @param newem
	 * @param enregistreur
	 */
	public SaisirEnregistrable(MoteurEdition newem, IHM newihm, Enregistreur enregistreur) {
		super(newem, newihm);
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel à la fonction execute de la classe mère : Saisir.
	 * Puis appel la fonction enregistrer(CommandeEnregistrable) de l'enregistreur.
	 */
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}
	
	/**
	 * Récupère le memento correspondant à la commande Enregistrable.
	 * Créer le Memento Saisir avec le caractère de l'ihm.
	 * @return MementoSaisir
	 */
	@Override
	public Memento getMemento() {
		System.out.println(String.valueOf(ihm.getCar()));
		Memento m = new MementoSaisir(String.valueOf(ihm.getCar()));
		return m;
	}
	/**
	 * Permet de rejouer la commande du Memento en appelant la fonctione saisir(texte).
	 * Le texte est récupérer dans le Memento avec getTexte().
	 * @param Memento
	 */
	@Override
	public void setMemento(Memento m) {
		String texte = ((MementoSaisir) m).getTexte();
		me.saisir(texte);
	}


}
