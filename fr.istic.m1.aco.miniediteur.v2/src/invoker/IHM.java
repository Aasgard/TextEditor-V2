package invoker;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import command.Command;

public class IHM extends JFrame{

	private static final long serialVersionUID = 1L;

	private ArrayList<Bouton> lesBoutons;
	
	protected TextArea texteA;
	
	private Command copier;
	private Command couper;
	private Command selectionner;
	private Command saisir;
	private Command coller;
	private Command effacer;
	
	public IHM(){
		this.setTitle("Editeur de texte - V1");
		this.setSize(new Dimension(800, 500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		lesBoutons = new ArrayList<Bouton>();
	}
	
	public void createTextArea(){
		HashMap<String, Command> h = new HashMap<String, Command>();
		h.put("selectionner", selectionner);
		h.put("saisir", saisir);
		h.put("effacer", effacer);
		
		System.out.println("Commandes du TextArea : " + h);
		this.texteA = new TextArea(h);
		this.texteA.setBounds(10, 50, 775, 415);
		
		this.add(texteA);
	}
	
	public void loadButtons(){
		Bouton bCouper = new Bouton("Couper", couper);
		bCouper.setBounds(10, 10, 90, 30);
		lesBoutons.add(bCouper);
		Bouton bCopier = new Bouton("Copier", copier);
		bCopier.setBounds(110, 10, 90, 30);
		lesBoutons.add(bCopier);
		Bouton bColler = new Bouton("Coller", coller);
		bColler.setBounds(210, 10, 90, 30);
		lesBoutons.add(bColler);
		
		Bouton bEnregistrer = new Bouton("Enregistrer", enregistrer);
		bEnregistrer.setBounds(10, 10, 90, 30);
		lesBoutons.add(bEnregistrer);
		Bouton bStop = new Bouton("Stop", stop);
		bStop.setBounds(10, 10, 90, 30);
		lesBoutons.add(bStop);
		Bouton bRejouer = new Bouton("Rejouer", rejouer);
		bRejouer.setBounds(10, 10, 90, 30);
		lesBoutons.add(bRejouer);
		
		this.add(bCopier);
		this.add(bColler);
		this.add(bCouper);
	}
	
	public void launch(){
		this.setVisible(true);
	}
	
	public char getCar() {
		return this.texteA.getDernierCar();
	}
	
	public int getDebutSelection() {
		return this.texteA.getDebutSelection();
	}

	public int getLongueurSelection() {
		return this.texteA.getLongueurSelection();
	}
	
	public void setCommands(HashMap<String, Command> h) throws Exception {
		System.out.println("Commandes venant de Client : " + h);
		this.couper = h.get("couper");
		if (this.couper == null) throw new Exception("commande \"couper\" manquante");
		this.copier = h.get("copier");
		if (this.copier == null) throw new Exception("commande \"copier\" manquante");
		this.coller = h.get("coller");
		if (this.coller == null) throw new Exception("commande \"coller\" manquante");
		this.selectionner = h.get("selectionner");
		if (this.selectionner == null) throw new Exception("commande \"selectionner\" manquante");
		this.saisir = h.get("saisir");
		if (this.saisir == null) throw new Exception("commande \"saisir\" manquante");
		this.effacer = h.get("effacer");
		if (this.effacer == null) throw new Exception("commande \"effacer\" manquante");
	}
	
}
