package observer;

import invoker.IHM;
import invoker.TextArea;
import receiver.MoteurEdition;

public class IHMObserver extends IHM implements Observer {

	private static final long serialVersionUID = 1L;
	protected Subject sub;
	
	/**
	 * Constructeur par défaut.
	 * @param subject : sujet de l'observation. (Moteur d'édition).
	 */
	public IHMObserver(Subject subject){
		this.sub = subject;
	}
	
	/**
	 * Refresh des Observés avec les nouveaux paramètres.
	 */
	@Override
	public void notifyMe() {
		MoteurEdition m = (MoteurEdition) sub;
		texteA.rafraichir(m.getBuffer().getContenu().toString(), m.getSelection().getDebut(), m.getSelection().getLongueur());
	}

}
