package receiver;


public class PressePapier{
	
	public String contenu;
	
	/**
	 * Constructeur par d�faut de la classe PressPapier.
	 * @param contenu : texte param�tre pour cr�� une nouvelle S�lection.
	 */
	public PressePapier(String contenu){
		this.contenu = contenu;
	}

	/**
	 * Retourne le contenu du PressePapier
	 * @return : contenu du PP
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Changement de la valeur de la S�lection
	 * @param contenu : nouveau contenu pour la S�lection courante
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}

