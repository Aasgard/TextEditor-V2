package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import command.Command;

public class Bouton extends JButton {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur principale d'un Bouton de l'IHM.
	 * On lui ajoute un ActionListener pour écouter le clic, et lancer la fonction de la Command associée.
	 * 
	 * @param n : texte du bouton (String)
	 * @param c : Command associée au bouton
	 */
	
	public Bouton(String n, final Command c){
		this.setText(n);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.execute();
			}
		});
	}
	
}
