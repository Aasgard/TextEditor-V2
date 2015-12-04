package receiver;

public class Selection {

	private int debut;
	private int longueur;
	private String contenu;
	
	/**
	 * Constructeur par défaut de la classe Sélection.
	 * @param debut : début de la Sélection
	 * @param longueur : longueur de la Sélection
	 * @param contenu : contenu de la Sélection
	 */
	public Selection(int debut, int longueur, String contenu) {
		this.debut = debut;
		this.longueur = longueur;
		this.contenu = contenu;
	}
	
	/**
	 * Changement des paramètres de la Sélection courante
	 * @param debut : nouveau début de la Sélection
	 * @param longueur : nouvelle longueur de la Sélection
	 */
	public void setSelection(int debut, int longueur){
		this.debut = debut;
		this.longueur = longueur;
	}
	
	/**
	 * Retourne le début de la Sélection
	 * @return : début de la Sélection
	 */
	public int getDebut() {
		return debut;
	}
	
	/**
	 * Change la valeur de début de la Sélection
	 * @param debut : int, début de la Sélection
	 */
	public void setDebut(int debut) {
		this.debut = debut;
	}
	
	/**
	 * Retourne la longueur de la Sélection.
	 * @return : int, longueur de la Sélection
	 */
	public int getLongueur() {
		return longueur;
	}
	
	/**
	 * Change la valeur de longueur de la Sélection
	 * @param longueur : int, longueur de la Sélection
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	
	/**
	 * Retourne le contenu de la Sélection
	 * @return : String, contenu de la Sélection
	 */
	public String getContenu() {
		return this.contenu;
	}
	
	/**
	 * Changement de la valeur du contenu
	 * @param contenu : nouvelle valeur pour le contenu de la Sélection.
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	/**
	 * Réinitialisation de la longueur et du contenu de la Sélection (Respectivement 0 et vide).
	 */
	public void initSelection(){
		this.longueur = 0;
		this.contenu = "";
	}
	
}