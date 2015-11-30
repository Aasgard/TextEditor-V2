package memento;

public class MementoSelectionner implements Memento {
	private int debutSelection;
	private int longueurSelection;
	
	public MementoSelectionner(int debutSelection, int longueurSelection){
		this.debutSelection = debutSelection;
		this.longueurSelection = longueurSelection;
	}
	
	public int getDebutSelection() {
		return debutSelection;
	}
	public void setDebutSelection(int debutSelection) {
		this.debutSelection = debutSelection;
	}
	public int getLongueurSelection() {
		return longueurSelection;
	}
	public void setLongueurSelection(int longueurSelection) {
		this.longueurSelection = longueurSelection;
	}
}
