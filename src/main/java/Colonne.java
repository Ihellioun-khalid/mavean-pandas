import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.Type;

public class Colonne {
	
	private String colonneTitre;
	private Type colonneType;
	private ArrayList<Cellule> cellules;
	
	public Colonne() {
		this.colonneTitre = "";
		this.colonneType = null;
		this.cellules = null;
	}

	public Colonne(String colonneTitre, Type colonneType, ArrayList<Cellule> cellules){
		this.colonneTitre = colonneTitre;
		this.colonneType = colonneType;
		this.cellules = cellules;
	}

	public String getColonneTitre() {
		return colonneTitre;
	}

	public void setColonneTitre(String colonneTitre) {
		this.colonneTitre = colonneTitre;
	}

	public Type getColonneType() {
		return colonneType;
	}

	public void setColonneType(Type colonneType) {
		this.colonneType = colonneType;
	}

	public ArrayList<Cellule> getCellules() {
		return cellules;
	}

	public void setCellules(ArrayList<Cellule> cellules) {
		this.cellules = cellules;
	}
	
	public boolean equals(Object obj){
		if (obj == null || getClass() != obj.getClass()){
			return false;
		}
		Colonne cellule2 = (Colonne)obj;
		if (!this.getColonneTitre().equals(cellule2.getColonneTitre())){
			return false;
		}
		if (!this.getColonneType().equals(cellule2.getColonneType())){
			return false;
		}
		if (!this.getCellules().equals(cellule2.getCellules())){
			return false;
		}
		return true;
	}
	
	public void afficheColonne() {
		if(getColonneTitre()==null || getColonneTitre()=="" ) {
			System.out.println("Cette colonne n'a pas de titre!");
		}
		else {
			System.out.println("titre:"+getColonneTitre());
		}
		
		if(getColonneType()==null) {
			System.out.println("Cette colonne n'a pas de type!");
		}
		else {
			System.out.println("type:"+getColonneType());
		}
		
		if(this.getCellules()==null) System.out.println("La colonne est vide!");
		else {
			 for(Cellule  c : this.cellules )
	         {
				 System.out.println("test:");
	         }		
		}

	}
	public int getSizeColonne()
	{	
		if(this.getCellules()==null) {
			return -1;
		}
		return this.getCellules().size();
	}
	
}
