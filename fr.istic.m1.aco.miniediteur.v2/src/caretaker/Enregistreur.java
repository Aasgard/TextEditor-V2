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
	
	public Enregistreur(){
		this.listCommandMemento = new ArrayList<Memento>();
		this.commandesEnregistrable = new HashMap<String, CommandEnregistrable>();
	}
	
	public void addMemento(Memento memento){
		System.out.println(memento);
		this.listCommandMemento.add(memento);
	}
	
	public Memento restoreCommand(int index){
		return this.listCommandMemento.get(index);
	}
	
	public void enregistrer(CommandEnregistrable commandEnregistrable){
		if(actif){
			addMemento(commandEnregistrable.getMemento());
		}
	}
	
	public void rejouer(){
		if(!actif){
			for(Memento commandMemento : listCommandMemento){
				System.out.println(commandMemento.getClass().toString());
				String test = commandMemento.getClass().toString().substring(21);
				test = test.substring(0, 1).toLowerCase() + test.substring(1);
				commandesEnregistrable.get(test).setMemento(commandMemento);
				System.out.println(test);
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! Je rejoue !!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
	
	public void enregistrer(){
		listCommandMemento.clear();
		actif = true;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! J'enregistre !!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(this.actif);
	}
	
	public void stopperEnr(){
		actif = false;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! J'ai stoppé l'enregistrement !!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(this.actif);
	}
	
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
