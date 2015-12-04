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
	 * H�rite de la commande Copier.
	 * Initialise l'enregistreur.
	 * @param newem
	 * @param enregistreur
	 */
	public CopierEnregistrable(MoteurEdition newem, Enregistreur enregistreur) {
		super(newem);
		this.enregistreur = enregistreur;
	}

	/**
	 * Appel � la fonction execute de la classe m�re : Copier.
	 * Puis appel la fonction enregistrer(CommandeEnregistrable) de l'enregistreur.
	 */
	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}

	/**
	 * R�cup�re le memento correspondant � la commande Enregistrable.
	 * @return MementoCopier
	 */
	@Override
	public Memento getMemento() {
		//System.out.println(em.getSelection().getContenu()+" est COPIER dans le pressepapier Memento");
		return new MementoCopier();
	}

	/**
	 * Permet de rejouer la commande du Memento en appelant la fonctione execute de la classe m�re : Copier.
	 * @param Memento
	 */
	@Override
	public void setMemento(Memento m) {
		/*MementoCopier mem = (MementoCopier) m;
		Selection se = new Selection(0 , 0 ,mem.getContenuSelection());*/
		super.execute();
	}

}
