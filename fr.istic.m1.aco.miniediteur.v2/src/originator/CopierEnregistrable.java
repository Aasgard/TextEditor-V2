package originator;

import caretaker.Enregistreur;
import command.Copier;
import memento.Memento;
import memento.MementoCopier;
import receiver.MoteurEdition;

public class CopierEnregistrable extends Copier implements CommandEnregistrable {

	private Enregistreur enregistreur;
	
	public CopierEnregistrable(MoteurEdition newem, Enregistreur enregistreur) {
		super(newem);
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		super.execute();
		enregistreur.enregistrer(this);
	}

	@Override
	public Memento getMemento() {
		//System.out.println(em.getSelection().getContenu()+" est COPIER dans le pressepapier Memento");
		return new MementoCopier();
	}

	@Override
	public void setMemento(Memento m) {
		/*MementoCopier mem = (MementoCopier) m;
		Selection se = new Selection(0 , 0 ,mem.getContenuSelection());*/
		super.execute();
	}

}
