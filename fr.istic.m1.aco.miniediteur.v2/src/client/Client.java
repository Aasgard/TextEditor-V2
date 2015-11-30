package client;

import java.util.HashMap;

import caretaker.Enregistreur;
import command.*;
import observer.IHMObserver;
import originator.*;
import receiver.MoteurEdition;

public class Client {

	private static MoteurEdition me;
	private static IHMObserver ihmo;
	private static HashMap<String, Command> commandes;
	private static Enregistreur enregistreur;
	private static HashMap<String, CommandEnregistrable> commandesEnregistrables;
	
	public static void main(String[] args) throws Exception {
		me = new MoteurEdition();
		ihmo = new IHMObserver(me);
		
		enregistreur = new Enregistreur();
		
		CouperEnregistrable couper = new CouperEnregistrable(me, enregistreur);
		CopierEnregistrable copier = new CopierEnregistrable(me, enregistreur);
		CollerEnregistrable coller = new CollerEnregistrable(me, enregistreur);
		SaisirEnregistrable saisir = new SaisirEnregistrable(me, ihmo, enregistreur);
		SelectionnerEnregistrable selectionner =  new SelectionnerEnregistrable(me, ihmo, enregistreur);
		EffacerEnregistrable effacer = new EffacerEnregistrable(me, enregistreur);
		
		commandes = new HashMap<String, Command>();
		commandes.put("couper", couper);
		commandes.put("saisir", saisir);
		commandes.put("coller", coller);
		commandes.put("copier", copier);
		commandes.put("effacer", effacer);
		commandes.put("selectionner", selectionner);
		commandes.put("enregistrer", new Enregistrer(enregistreur));
		commandes.put("stop", new Stop(enregistreur));
		commandes.put("rejouer", new Rejouer(enregistreur));
		
		commandesEnregistrables = new HashMap<String, CommandEnregistrable>();
		commandesEnregistrables.put("couper", couper);
		commandesEnregistrables.put("copier", copier);
		commandesEnregistrables.put("coller", coller);
		commandesEnregistrables.put("saisir", saisir);
		commandesEnregistrables.put("selectionner", selectionner);
		commandesEnregistrables.put("effacer", effacer);
		
		enregistreur.setCommandesEnregistrable(commandesEnregistrables);
		ihmo.setCommands(commandes);
		me.registerObserver(ihmo);
		
		/* Finalisation de l'IHM */
		ihmo.createTextArea();
		ihmo.loadButtons();
		ihmo.launch();
		
	}
	
}
