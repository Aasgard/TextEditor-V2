package observer;

import invoker.IHM;
import invoker.TextArea;
import receiver.MoteurEdition;

public class IHMObserver extends IHM implements Observer {

	private static final long serialVersionUID = 1L;
	protected Subject sub;
	
	public IHMObserver(Subject subject){
		this.sub = subject;
	}
	
	@Override
	public void notifyMe() {
		MoteurEdition m = (MoteurEdition) sub;
		texteA.rafraichir(m.getBuffer().getContenu().toString(), m.getSelection().getDebut(), m.getSelection().getLongueur());
	}

}
