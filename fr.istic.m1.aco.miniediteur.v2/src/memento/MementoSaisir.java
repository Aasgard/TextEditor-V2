package memento;

public class MementoSaisir implements Memento {

	private String texte;
	
	
	/**
	 * Constructeur du mementoSaisir.
	 * @param texte
	 */
	public MementoSaisir(String texte){
		this.setTexte(texte);
	}

	/**
	 * Retourne le texte du MementoSaisir.
	 * @return texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * Modifie le texte du mementoSaisir.
	 * @param texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
}
