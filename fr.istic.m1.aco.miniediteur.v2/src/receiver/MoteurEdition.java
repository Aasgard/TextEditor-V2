package receiver;

import java.util.ArrayList;
import java.util.Iterator;

import observer.Observer;
import observer.Subject;

public class MoteurEdition extends Subject implements IMoteurEdition {

	private Buffer buffer;
	private Selection selection;
	private PressePapier pressePapier;
	
	/**
	 * Constructeur du MoteurEdition.
	 * Initialisation "neutres" des différentes classes métiers (Buffer, Sélection, PressePapier)
	 */
	public MoteurEdition() {
		observers = new ArrayList<Observer>();
		this.buffer = new Buffer();
		this.selection = new Selection(0, 0, "");
		this.pressePapier = new PressePapier("");
	}
	
	/**
	 * Reproduction de la commande Coller classique.
	 * Récupération du contenu du PressePapier.
	 * Création d'un StringBuffer contenant le contenu du PressePapier.
	 * Ajout au buffer au niveau du début de la selection.
	 * Début de la Sélection modifiée (Endroit de Collage et ajout de la longueur du texte dans le PP).
	 * Remise à 0 de la longueur et contenu de la Sélection.
	 */
	@Override
	public void coller() {
		StringBuffer newcontenu = new StringBuffer(pressePapier.getContenu());
		this.buffer.setBuffer(newcontenu, this.selection.getDebut(), this.selection.getLongueur()+this.selection.getDebut());	
		selection.setDebut(selection.getDebut()+pressePapier.getContenu().length());
		this.selection.initSelection();
		notifyObservers();
	}

	/**
	 * Reproduction de la commande Copier classique.
	 * Récupération du contenu de la Sélection que l'on stocke dans le PP.
	 * Remise à 0 de la longueur et contenu de la Sélection.
	 */
	@Override
	public void copier() {
		if(selection.getLongueur() > 0 ){
			String contenuSelection = selection.getContenu();
			pressePapier.setContenu(contenuSelection);
			this.selection.initSelection();
		}
	}
	
	/**
	 * Reproduction de la commande Effacer classique.
	 * Suppression du caractère précedent le début de la sélection.
	 * Si longueur de Sélection supérieure à 0, on supprime la longueur de la chaine texte à partir du début de la sélection.
	 */
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

	/**
	 * Reproduction de la commande Couper classique.
	 * On récupère le contenu de la Sélection, on le met dans le PP puis on retire ce contenu du Buffer.
	 */
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

	/**
	 * Saisie d'un texte dans le Buffer.
	 * Puis on modifie le debut de la selection en y rajoutant la longueur du texte
	 * @param texte : texte à saisir dans le Buffer
	 */
	@Override
	public void saisir(String texte) {
		this.buffer.setBuffer(new StringBuffer(texte), this.selection.getDebut(), this.selection.getLongueur()+this.selection.getDebut());
		this.selection.setDebut(this.selection.getDebut()+texte.length());
		System.out.println("Buffer : "+this.buffer.getContenu().toString());
		notifyObservers();
	}

	/**
	 * Sélection d'un texte dans le Buffer.
	 * Initialisation du début, de la longueur et de son contenu.
	 */
	@Override
	public void selectionner(Integer debut, Integer longueur) {
		this.selection.setDebut(debut);
		this.selection.setLongueur(longueur);
		this.selection.setContenu(this.buffer.getContenu().toString().substring(debut, debut+longueur));
	}
	
	/**
	 * Retourne le buffer.
	 * @return : le Buffer
	 */
	public Buffer getBuffer(){
		return this.buffer;
	}

	/**
	 * Retourne le PP.
	 * @return : le PP
	 */
	public PressePapier getPressePapier(){
		return this.pressePapier;
	}

	/**
	 * Retourne la Sélection.
	 * @return : le Sélection
	 */
	public Selection getSelection(){
		return this.selection;
	}

	/**
	 * Permets de notifier l'obersver (l'IHM) d'un changement
	 * @see observer.Subject#notifyObservers()
	 */
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
