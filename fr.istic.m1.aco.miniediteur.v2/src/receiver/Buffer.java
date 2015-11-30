package receiver;


public class Buffer{
	
	private StringBuffer contenu;
	/*private MoteurEdition me;*/

	public Buffer(){
		this.contenu = new StringBuffer("");
	}
	
	public void setBuffer(StringBuffer newContenu, int debut, int fin){
		if(fin > 0){
			this.contenu.delete(debut, fin);
		}
		this.contenu.insert(debut, newContenu.toString() );
	}
	
	public StringBuffer getContenu(){
		return this.contenu;
	}

}

