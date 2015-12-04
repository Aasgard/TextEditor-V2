package receiver;


public class PressePapier{
	
	public String contenu;
	
	/**
	 * Constructeur par défaut de la classe PressPapier.
	 * @param contenu : texte paramètre pour créé une nouvelle Sélection.
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
	 * Changement de la valeur de la Sélection
	 * @param contenu : nouveau contenu pour la Sélection courante
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}

