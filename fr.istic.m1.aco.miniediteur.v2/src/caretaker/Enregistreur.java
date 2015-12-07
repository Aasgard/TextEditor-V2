package caretaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import memento.*;
import originator.CommandEnregistrable;

public class Enregistreur {

	private boolean actif = false;
	private List<Memento> listCommandMemento;
	private HashMap<String, CommandEnregistrable> commandesEnregistrable;
	
	/**
	 * Constructeur de l'Enregistreur.
	 * Initialise la liste des Commandes Memento
	 * Ainsi que les commandes enregistrables.
	 */
	public Enregistreur(){
		this.listCommandMemento = new ArrayList<Memento>();
		this.commandesEnregistrable = new HashMap<String, CommandEnregistrable>();
	}
	
	/**
	 * Ajoute le Memento passé en paramètre à la liste des Commandes Memento de l'Enregistreur.
	 * @param memento : memento paramètre
	 */
	public void addMemento(Memento memento){
		System.out.println(memento);
		this.listCommandMemento.add(memento);
	}
	
	/**
	 * Enregistre la commande enregistrable si l'Enregistrement est actif.
	 * Récupere son Memento puis l'ajoute à la liste des Commandes Memento de l'Enregistreur.
	 * @param commandEnregistrable : Une commande enregistrable
	 */
	public void enregistrer(CommandEnregistrable commandEnregistrable){
		if(actif){
			addMemento(commandEnregistrable.getMemento());
		}
	}
	
	/**
	 * Permet de rejouer la listes des commandes enregistrables de l'enregistreur.
	 * Si l'enregistrement n'est plus actif : 
	 * On parcours la liste des commandes.
	 * On récupère leur nom puis on appelle le setMemento de la classe correspondante.
	 */
	public void rejouer(){
		if(!actif){
			System.out.println(listCommandMemento.size());
			for(Memento commandMemento : listCommandMemento){
				System.out.println(commandMemento.getClass().toString());
				String test = commandMemento.getClass().toString().substring(21);
				test = test.substring(0, 1).toLowerCase() + test.substring(1);
				commandesEnregistrable.get(test).setMemento(commandMemento);
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! Je rejoue !!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	/**
	 * Initialise la liste des commandes Memento.
	 * Permet de lancer l'enregistrement des commandes.
	 */
	public void enregistrer(){
		listCommandMemento.clear();
		actif = true;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! J'enregistre !!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(this.actif);
	}
	
	/**
	 * Permet de stopper l'enregistrement.
	 */
	public void stopperEnr(){
		actif = false;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! J'ai stoppé l'enregistrement !!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(this.actif);
	}
	
	
	/**
	 * Retourne l'etat de l'enregistreur : si il est activé ou non
	 * @return boolean
	 */
	public boolean getActif(){
		return this.actif;
	}
	
	/**
	 * Vérifie si les commandes enregistrables sont bien présente puis initialise les commandes enregistrables de l'Enregistreur.
	 * @param h : Un HM de commande
	 * @throws Exception : Exception lancée
	 */
	public void setCommandesEnregistrable(HashMap<String, CommandEnregistrable> h)
			throws Exception {
		if (h.get("couper") == null)
			throw new Exception("commande \"couper\" manquante");
		if (h.get("copier") == null)
			throw new Exception("commande \"copier\" manquante");
		if (h.get("coller") == null)
			throw new Exception("commande \"coller\" manquante");
		if (h.get("saisir") == null)
			throw new Exception("commande \"saisir\" manquante");
		if (h.get("selectionner") == null)
			throw new Exception("commande \"selectionner\" manquante");
		if (h.get("effacer") == null)
			throw new Exception("commande \"effacer\" manquante");
		commandesEnregistrable = h;
	}
	
}
