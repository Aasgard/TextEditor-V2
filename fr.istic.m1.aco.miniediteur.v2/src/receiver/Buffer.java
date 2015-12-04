package receiver;


public class Buffer{
	
	private StringBuffer contenu;

	/**
	 * Constructeur par d�faut de la classe Buffer
	 * Initialisation de son contenu � vide
	 */
	public Buffer(){
		this.contenu = new StringBuffer("");
	}
	
	/**
	 * Changement des informations du Buffer.
	 * @param newContenu : Nouveau contenu � donner au Buffer
	 * @param debut : D�but de l'insertion dans le Buffer
	 * @param fin : Fin de l'insertion dans le Buffer
	 */
	public void setBuffer(StringBuffer newContenu, int debut, int fin){
		if(fin > 0){
			this.contenu.delete(debut, fin);
		}
		this.contenu.insert(debut, newContenu.toString() );
	}
	
	/**
	 * Retourne le contenu du Buffer
	 * @return : StringBuffer, contenu du Buffer
	 */
	public StringBuffer getContenu(){
		return this.contenu;
	}

}

