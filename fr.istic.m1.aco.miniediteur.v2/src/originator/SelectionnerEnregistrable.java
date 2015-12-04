package originator;

import caretaker.Enregistreur;
import command.Selectionner;
import invoker.IHM;
import memento.Memento;
import memento.MementoSelectionner;
import receiver.MoteurEdition;

public class SelectionnerEnregistrable extends Selectionner implements CommandEnregistrable{

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur de la commande enregistrable Selectionner.
	 * H�rite de la commande Selectionner.
	 * Initialise l'enregistreur.
	 * @param newem
	 * @param enregistreur
	 */
	public SelectionnerEnregistrable(MoteurEdition em, IHM newihm, Enregistreur enregistreur) {
		super(em, newihm);
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel � la fonction execute de la classe m�re : Selectionner.
	 * Puis appel la fonction enregistrer(CommandeEnregistrable) de l'enregistreur.
	 */
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);	
	}
	
	/**
	 * R�cup�re le memento correspondant � la commande Enregistrable.
	 * Le mementoSelectionner est cr�� � partir des valeurs de la s�lection courante de l'�tat du MoteurEdition
	 * @return MementoSelectionner
	 */
	@Override
	public Memento getMemento() {
		System.out.println("Cr�ation memento selection : "+me.getSelection().getDebut());
		return new MementoSelectionner(me.getSelection().getDebut(), me.getSelection().getLongueur());
	}

	/**
	 * Permet de rejouer la commande du Memento en appelant la fonctione selectionner(debut, longueur).
	 * Le debut et la longueur sont r�cup�rer dans le Memento avec les m�thodes getDebutSelection() et getLongueurSelection()
	 * @param Memento
	 */
	@Override
	public void setMemento(Memento memento) {
		MementoSelectionner mem = (MementoSelectionner) memento;
		System.out.println("R�cup�ration de la selection : "+mem.getDebutSelection());
		me.selectionner(mem.getDebutSelection(), mem.getLongueurSelection());
	}

}
