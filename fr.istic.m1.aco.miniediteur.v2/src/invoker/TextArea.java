package invoker;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import command.Command;

public class TextArea extends JTextArea {

	private static final long serialVersionUID = 1L;
	
	private int debutSelection;
	private int longueurSelection;
	private String texte;
	private char dernierCar;
	private boolean changementPosition;
	
	/**
	 * Constructeur de la classe TextArea.
	 * Récupération des commandes du paramètre.
	 * Initialisation du composant avec son comportement (CarretListener, MouseListener ...).
	 * 
	 * @param comm : HM de String,Command avec le nom de la comande et l'objet Command asssocié.
	 */
	public TextArea(HashMap<String, Command> comm) {

		final Command selectionner = comm.get("selectionner");
		final Command saisir = comm.get("saisir");
		final Command effacer = comm.get("effacer");
		final Command supprimer = comm.get("supprimer");
		
		this.setChangementPosition(false);
		
		System.out.println("Constructeur du TA : " + comm);
		
		this.setLineWrap(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		this.addMouseListener(new MouseListener(){
		   @Override
		   public void mouseClicked(MouseEvent e) {
			   setChangementPosition(true);
			   System.out.println("On a cliqué et le changement de position est à : "+getChangementPosition());
		   }
		
		   @Override
		   public void mousePressed(MouseEvent e) {
			   setChangementPosition(true);
			   System.out.println("On a cliqué et le changement de position est à : "+getChangementPosition());
		   }
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});

		this.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				int i = Math.min(e.getDot(), e.getMark());
				int j = Math.max(e.getDot(), e.getMark());
				int l = j - i;

				if (getChangementPosition()) {
					setSelection(i, l);
					selectionner.execute();
				}
			}
		});

		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				setChangementPosition(false);
				e.consume();
				char keyChar = e.getKeyChar();
				if (e.getKeyChar() != '\b' && (int)keyChar != 127){ //127 est la touche suppression
					dernierCar = e.getKeyChar();
					saisir.execute();
					setSelection(getDebutSelection()+1, 0);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				setChangementPosition(false);
				if (!e.isActionKey()) {
					e.consume();
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
						effacer.execute();
						System.out.println("On appuie sur retour arriere");
					}
					if (e.getKeyCode() == KeyEvent.VK_DELETE){
						e.consume();
						supprimer.execute();
					}
				}
			}
		});
	}
	
	/**
	 * Récupération du début de la sélection.
	 * @return : début de la sélection (int)
	 */
	public int getDebutSelection() {
		return debutSelection;
	}

	/**
	 * Récupération de la longueur de la sélection.
	 * @return : longueur de la sélection (int)
	 */
	public int getLongueurSelection() {
		return longueurSelection;
	}

	/**
	 * Change la sélection courante. Début et longueur.
	 * @param debut : nouvelle valeur début de Sélection
	 * @param longueur : nouvelle valeur longueur de Sélection
	 */
	public void setSelection(int debut, int longueur) {
		debutSelection = debut;
		longueurSelection = longueur;
	}
	
	/**
	 * Retourne le texte dans le TextArea
	 * @return  : texte, String contenue dans le TextArea
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * Change le texte contenu dans la TextArea.
	 * @param texte : Texte passé au TextArea.
	 */
	public void setTexte(String texte) {
		this.texte = texte;
		this.setText(texte);
	}

	/**
	 * Retourne le dernier caractère tapé dans le TextArea.
	 * @return : Character tapé en dernier dans le TextArea.
	 */
	public char getDernierCar() {
		return dernierCar;
	}
	
	/**
	 * Refresh des informations du TextArea.
	 * @param texte : String paramètre passé au TA
	 * @param start : début de la sélection
	 * @param lg : longueur de la sélection
	 */
	public void rafraichir(String texte, int start, int lg) {
		this.setTexte(texte);
		this.setSelectionStart(start);
		this.setSelectionEnd(start + lg);
		this.setSelection(start, lg);
	}

	/**
	 * Détecte un changement de position dans la sélection.
	 * @return : changement de position ou non dans la sélection.
	 */
	public boolean getChangementPosition() {
		return changementPosition;
	}

	/**
	 * Change le paramètre permettant de connaitre le changement de position.
	 * @param changementPosition : boolean, nouveau paramètre.
	 */
	public void setChangementPosition(boolean changementPosition) {
		this.changementPosition = changementPosition;
	}
	
}
