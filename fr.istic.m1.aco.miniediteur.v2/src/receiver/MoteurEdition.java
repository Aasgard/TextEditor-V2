package receiver;

import java.util.ArrayList;
import java.util.Iterator;

import observer.Observer;
import observer.Subject;

public class MoteurEdition extends Subject implements IMoteurEdition {

	private Buffer buffer;
	private Selection selection;
	private PressePapier pressePapier;
	
	public MoteurEdition() {
		observers = new ArrayList<Observer>();
		this.buffer = new Buffer();
		this.selection = new Selection(0, 0, "");
		this.pressePapier = new PressePapier("");
	}
	
	@Override
	public void coller() {
		StringBuffer newcontenu = new StringBuffer(pressePapier.getContenu());
		this.buffer.setBuffer(newcontenu, this.selection.getDebut(), this.selection.getLongueur()+this.selection.getDebut());	
		selection.setDebut(selection.getDebut()+pressePapier.getContenu().length());
		this.selection.initSelection();
		notifyObservers();
	}

	@Override
	public void copier() {
		if(selection.getLongueur() > 0 ){
			String contenuSelection = selection.getContenu();
			pressePapier.setContenu(contenuSelection);
			this.selection.initSelection();
		}
	}
	
	@Override
	public void effacer() {
		int debut = this.selection.getDebut();
		if(this.getSelection().getLongueur() == 0 && debut != 0){
			this.buffer.getContenu().delete(debut-1, debut);
			this.selection.setDebut(debut-1);		
		}
		if(this.selection.getLongueur() > 0){
			this.buffer.getContenu().delete(debut, debut+this.selection.getLongueur());
			this.selection.initSelection();
		}
		if (debut == 0 && this.selection.getLongueur() == 0){
			notifyObservers();
			return;
		}
		notifyObservers();
	}

	@Override
	public void couper() {
		if(selection.getLongueur() > 0){
			String contenuSelection = this.selection.getContenu();
			pressePapier.setContenu(contenuSelection);
			this.buffer.getContenu().delete(this.selection.getDebut(), this.selection.getDebut()+this.selection.getLongueur());
			this.selection.initSelection();
			notifyObservers();
		}
	}

	@Override
	public void saisir(String texte) {
		this.buffer.setBuffer(new StringBuffer(texte), this.selection.getDebut(), this.selection.getLongueur()+this.selection.getDebut());
		this.selection.setDebut(this.selection.getDebut()+texte.length());
		System.out.println("Buffer : "+this.buffer.getContenu().toString());
		notifyObservers();
	}

	@Override
	public void selectionner(Integer debut, Integer longueur) {
		this.selection.setDebut(debut);
		this.selection.setLongueur(longueur);
		this.selection.setContenu(this.buffer.getContenu().toString().substring(debut, debut+longueur));
	}
	
	public Buffer getBuffer(){
		return this.buffer;
	}

	public PressePapier getPressePapier(){
		return this.pressePapier;
	}

	public Selection getSelection(){
		return this.selection;
	}

	@Override
	public void notifyObservers() {
		for (Iterator<Observer> it = observers.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.notifyMe();
		}
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}

}
