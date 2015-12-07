package fr.istic.m1.aco.miniediteur.v2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import caretaker.Enregistreur;
import command.Rejouer;
import invoker.IHM;
import invoker.TextArea;
import originator.SaisirEnregistrable;
import receiver.MoteurEdition;

public class TestsUnitaire {

	private MoteurEdition me;
	private Enregistreur enr;
	
	@Before
	public void init(){
		me = new MoteurEdition();
		enr = new Enregistreur();
	}
	
	/**
	 * Scénario :
	 * 
	 * Création d'un MoteurEdition.
	 * Récupération du Buffer (contenu) et vérification si vide.
	 * 
	 */
	@Test
	public void testSaisir() {
		//Création du MoteurEdition
		me =  new MoteurEdition();
		//Récupération du contenu du Buffer
		String contenuBuffer = me.getBuffer().getContenu().toString();
		//On vérifie si le Buffer est bien vide (car par encore changé) --> issu du constructeur
		assertEquals(contenuBuffer,"");
		me.saisir("Chat");
		String contenuBuffer2 = me.getBuffer().getContenu().toString();
		assertEquals(contenuBuffer2,"Chat");
	}
	
	@Test
	public void testSaisirChar(){
		//Création du MoteurEdition
		me =  new MoteurEdition();
		//Récupération du contenu du Buffer
		String contenuBuffer = me.getBuffer().getContenu().toString();
		//On vérifie si le Buffer est bien vide (car par encore changé) --> issu du constructeur
		
		assertEquals(contenuBuffer,"");
		char firstcarac = 'C';
		me.saisir(String.valueOf(firstcarac));
		String contenuBuffer2 = me.getBuffer().getContenu().toString();
		assertEquals(contenuBuffer2,"C");
		
		me.saisir(String.valueOf('h'));
		me.saisir(String.valueOf('a'));
		me.saisir(String.valueOf('t'));
		String contenuBuffer3 = me.getBuffer().getContenu().toString();
		assertEquals(contenuBuffer3,"Chat");
	}
	
	/**
	 * Scénario :
	 * 
	 * Création d'un MoteurEdition.
	 * Saisie d'une phrase.
	 * On sélectionne un intervalle (ici, Chat).
	 * On vérifie la selection (ici Chat, puis Cha , et puis une selection "vide"
	 * On réinitialise la Sélection, on copie et on vérifie que le PP est vide.
	 */
	@Test
	public void testSelectionner() {
		System.out.println("\n------------------Test SELECTIONNER -------------------------");

		me = new MoteurEdition();
		//Récupération du contenu du Buffer
		String contenuBuffer = me.getBuffer().getContenu().toString();
		//On vérifie si le Buffer est bien vide (car par encore changé) --> issu du constructeur
		assertEquals(contenuBuffer,"");
		me.saisir("Chat");
		String contenuBuffer2 = me.getBuffer().getContenu().toString();
		assertEquals(contenuBuffer2,"Chat");
	
		me.selectionner(0, 3);
		System.out.println("Contenu selection : " +me.getSelection().getContenu());
		assertEquals(me.getSelection().getContenu(), "Cha");
		
		me.selectionner(1,0);
		System.out.println("Contenu selection : " +me.getSelection().getContenu());
		System.out.println("Avant la selection : " +me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()));
		assertEquals(me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()), "C");
		
		me = new MoteurEdition();
		//Récupération du contenu du Buffer
		contenuBuffer = me.getBuffer().getContenu().toString();
		//On vérifie si le Buffer est bien vide (car par encore changé) --> issu du constructeur
		assertEquals(contenuBuffer,"");
		me.selectionner(0,0);
		System.out.println("Contenu selection : " +me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()));
		assertEquals(me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()), "");
	}
	
	/**
	 * Scénario :
	 * 
	 * Création d'un MoteurEdition.
	 * Récupération du Buffer (contenu) et vérification si vide.
	 * Saisie de Chat puis nouvelle saisie
	 * 
	 */
	@Test
	public void testSaisir2() {
		//Création du MoteurEdition
		me =  new MoteurEdition();
		//Récupération du contenu du Buffer
		String contenuBuffer = me.getBuffer().getContenu().toString();
		//On vérifie si le Buffer est bien vide (car par encore changé) --> issu du constructeur
		assertEquals(contenuBuffer,"");
		me.saisir("Chat");
		String contenuBuffer2 = me.getBuffer().getContenu().toString();
		assertEquals(contenuBuffer2,"Chat");
		me.saisir(" oiseau");
		String contenuBuffer3 = me.getBuffer().getContenu().toString();
		assertEquals(contenuBuffer3,"Chat oiseau");
		
		me.selectionner( 4, 0);
		me.saisir(" chien");
		String contenuBuffer4 = me.getBuffer().getContenu().toString();
		assertEquals(contenuBuffer4,"Chat chien oiseau");
		
		me.selectionner(2, 2);
		me.saisir("ienne");
		String contenuBuffer5 = me.getBuffer().getContenu().toString();
		System.out.println(contenuBuffer5);
		assertEquals(contenuBuffer5,"Chienne chien oiseau");
		
	}
	
	/**
	 * Scénario :
	 * 
	 * Création d'un MoteurEdition.
	 * Saisie d'une phrase.
	 * On sélectionne un intervalle (ici, Chat).
	 * On copie la sélection (appel de MoteurEdition.copier()).
	 * On vérifie que le contenu du PressePapier est semblable à la partie prélevée.
	 * On réinitialise la Sélection, on copie et on vérifie que le PP est vide.
	 */
	@Test
	public void testCopier() {
		System.out.println("\n------------------Test COPIER -------------------------");
		//Création du MoteurEdition
		//me = new MoteurEdition();
		//Saisie de la phrase
		me.saisir("Chat chien oiseau");

		//Vérification du contenu du  Buffer
		assertEquals(me.getBuffer().getContenu().toString(), "Chat chien oiseau");
		
		//Sélection des 5 premiers caractères (4+1) [Chat]
		me.selectionner(0, 4);
		//Vérification de la selection
		System.out.println("Contenu selection : " +me.getSelection().getContenu());
		assertEquals(me.getSelection().getContenu(), "Chat");
		
		//On copie
		me.copier();
		//On vérifie si le mot Chat est bien dans le PressePapier
		System.out.println("Contenu du presse papier après copier : "+me.getPressePapier().getContenu());
		assertEquals(me.getPressePapier().getContenu(), "Chat");
		//On réinitialise la Sélection
		me.selectionner(4, 0);
		//On copie
		me.copier();
		//On vérifie si le PressePapier n'est pas vide car on ne peut copier une selection vide
		assertEquals(me.getPressePapier().getContenu(), "Chat");
		
		me.selectionner(4, 1);
		//On copie
		me.copier();
		//On vérifie si l'espace est bien dans PressePapier
		assertEquals(me.getPressePapier().getContenu(), " ");
		
		//On vérifie que la sélection s'est bien réinitialiser avant l'espace
		System.out.println("Contenu selection : " +me.getSelection().getLongueur());
		System.out.println("Avant la selection : " +me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()));
		System.out.println("Après la selection : " +me.getBuffer().getContenu().substring(me.getSelection().getDebut() ,me.getBuffer().getContenu().length()));

		assertEquals(me.getSelection().getContenu(), "");
	}

	/**
	 * Scénario :
	 * 
	 * Création d'un MoteurEdition.
	 * Saisie d'une phrase.
	 * On sélectionne un intervalle (ici, Chat).
	 * On copie la sélection (appel de MoteurEdition.copier()).
	 * On vérifie que le contenu du PressePapier est semblable à la partie prélevée.
	 * On réinitialise la Sélection, on copie et on vérifie que le PP est vide.
	 */
	@Test
	public void testCouper() {
		System.out.println("\n------------------Test COUPER -------------------------");
		//Création du MoteurEdition
		//me = new MoteurEdition();
		//Saisie de la phrase
		me.saisir("Chat chien oiseau");

		//Vérification du contenu du  Buffer
		assertEquals(me.getBuffer().getContenu().toString(), "Chat chien oiseau");
		
		//Sélection des 5 premiers caractères (4+1) [Chat]
		me.selectionner(4, 6);
		//Vérification de la selection
		System.out.println("Contenu selection : " +me.getSelection().getContenu());
		assertEquals(me.getSelection().getContenu(), " chien");
		
		//On copie
		me.couper();
		//On vérifie si le mot Chat est bien dans le PressePapier
		System.out.println("Contenu du presse papier après copier : "+me.getPressePapier().getContenu());
		assertEquals(me.getPressePapier().getContenu(), " chien");
		
		//On vérifie que la sélection s'est bien réinitialiser avant l'espace
		System.out.println("Contenu selection : " +me.getSelection().getLongueur());
		System.out.println("Avant la selection : " +me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()));
		System.out.println("Après la selection : " +me.getBuffer().getContenu().substring(me.getSelection().getDebut() ,me.getBuffer().getContenu().length()));

		assertEquals(me.getSelection().getContenu(), "");
		
		System.out.println("Contenu du buffer après couper : "+me.getBuffer().getContenu());
		
		me.selectionner(4, 0);
		//On copie
		me.couper();
		//On vérifie si le PressePapier n'est pas vide car on ne peut copier une selection vide
		assertEquals(me.getPressePapier().getContenu(), " chien");
	}
	
	/**
	 * Scénario :
	 * 
	 * Création d'un MoteurEdition.
	 * Saisie d'une phrase.
	 * On sélectionne un intervalle (ici, Chat).
	 * On copie la sélection (appel de MoteurEdition.copier()).
	 * On vérifie que le contenu du PressePapier est semblable à la partie prélevée.
	 * On réinitialise la Sélection, on copie et on vérifie que le PP est vide.
	 */
	@Test
	public void testColler() {
		System.out.println("\n------------------Test COLLER -------------------------");
		//Création du MoteurEdition
		//me = new MoteurEdition();
		//Saisie de la phrase
		me.saisir("Chat chien oiseau");

		//Vérification du contenu du  Buffer
		assertEquals(me.getBuffer().getContenu().toString(), "Chat chien oiseau");
		
		//Sélection des 5 premiers caractères (4+1) [Chat]
		me.selectionner(4, 6);
		//Vérification de la selection
		System.out.println("Contenu selection : " +me.getSelection().getContenu());
		assertEquals(me.getSelection().getContenu(), " chien");
		
		//On copie
		me.couper();
		//On vérifie si le mot Chat est bien dans le PressePapier
		System.out.println("Contenu du presse papier après copier : "+me.getPressePapier().getContenu());
		assertEquals(me.getPressePapier().getContenu(), " chien");
		
		//On vérifie que la sélection s'est bien réinitialiser avant l'espace
		System.out.println("Contenu selection : " +me.getSelection().getLongueur());
		System.out.println("Avant la selection : " +me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()));
		System.out.println("Après la selection : " +me.getBuffer().getContenu().substring(me.getSelection().getDebut() ,me.getBuffer().getContenu().length()));

		assertEquals(me.getSelection().getContenu(), "");
		
		me.selectionner(4, 0);
		me.coller();
		System.out.println("Contenu du buffer après coller : "+me.getBuffer().getContenu());
		assertEquals(me.getBuffer().getContenu().toString(), "Chat chien oiseau");

		
		me.selectionner(0, 4);
		me.coller();
		System.out.println("Contenu du buffer après coller : "+me.getBuffer().getContenu());		
		assertEquals(me.getBuffer().getContenu().toString(), " chien chien oiseau");
	}
	
	@Test
	public void testEffacer() {
		System.out.println("\n------------------Test EFFACER -------------------------");
		//Création du MoteurEdition
		//me = new MoteurEdition();
		//Saisie de la phrase
		me.saisir("Chat chien oiseau");

		//Vérification du contenu du  Buffer
		assertEquals(me.getBuffer().getContenu().toString(), "Chat chien oiseau");
		
		//Sélection des 5 premiers caractères (4+1) [Chat]
		me.selectionner(4, 6);
		//Vérification de la selection
		System.out.println("Contenu selection : " +me.getSelection().getContenu());
		assertEquals(me.getSelection().getContenu(), " chien");
		
		//On copie
		me.couper();
		//On vérifie si le mot Chat est bien dans le PressePapier
		System.out.println("Contenu du presse papier après copier : "+me.getPressePapier().getContenu());
		assertEquals(me.getPressePapier().getContenu(), " chien");
		
		//On vérifie que la sélection s'est bien réinitialiser avant l'espace
		System.out.println("Contenu selection : " +me.getSelection().getLongueur());
		System.out.println("Avant la selection : " +me.getBuffer().getContenu().substring(0, me.getSelection().getDebut()));
		System.out.println("Après la selection : " +me.getBuffer().getContenu().substring(me.getSelection().getDebut() ,me.getBuffer().getContenu().length()));

		assertEquals(me.getSelection().getContenu(), "");
		
		me.selectionner(4, 0);
		me.coller();
		System.out.println("Contenu du buffer après coller : "+me.getBuffer().getContenu());
		assertEquals(me.getBuffer().getContenu().toString(), "Chat chien oiseau");

		
		me.selectionner(0, 4);
		me.coller();
		System.out.println("Contenu du buffer après coller : "+me.getBuffer().getContenu());		
		assertEquals(me.getBuffer().getContenu().toString(), " chien chien oiseau");
	}
	
	@Test
	public void testEnregistrer(){
		enr.enregistrer();
		assertTrue(enr.getActif());
	}
	
	@Test
	public void testStopperEnregistrement(){
		enr.stopperEnr();
		assertFalse(enr.getActif());
	}
}
