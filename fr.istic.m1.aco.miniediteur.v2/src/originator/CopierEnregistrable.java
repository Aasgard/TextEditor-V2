package originator;

import caretaker.Enregistreur;
import command.Copier;
import memento.Memento;
import memento.MementoCopier;
import receiver.MoteurEdition;

public class CopierEnregistrable extends Copier implements CommandEnregistrable {

	private Enregistreur enregistreur;
	
	/**
	 * Constructeur de la commande enregistrable Copier.
	 * Hérite de la commande Copier.
	 * Initialise l'enregistreur.
	 * @param newem
	 * @param enregistreur
	 */
	public CopierEnregistrable(MoteurEdition newem, Enregistreur enregistreur) {
		super(newem);
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel à la fonction execute de la classe mère : Copier.
	 * Puis appel la fonction enregistrer(CommandeEnregistrable) de l'enregistreur.
	 */
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}

	/**
	 * Récupère le memento correspondant à la commande Enregistrable.
	 * @return MementoCopier
	 */
	@Override
	public Memento getMemento() {
		//System.out.println(em.getSelection().getContenu()+" est COPIER dans le pressepapier Memento");
		return new MementoCopier();
	}

	/**
	 * Permet de rejouer la commande du Memento en appelant la fonctione execute de la classe mère : Copier.
	 * @param Memento
	 */
	@Override
	public void setMemento(Memento m) {
		/*MementoCopier mem = (MementoCopier) m;
		Selection se = new Selection(0 , 0 ,mem.getContenuSelection());*/
		super.execute();
	}

}
