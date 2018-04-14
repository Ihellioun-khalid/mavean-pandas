import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.Type;
//import exceptions.ColonneNonCalculableException;
//import exceptions.ColonneNonTrouveeException;

import Exceptions.IndiceGrandException;
import Exceptions.IndiceIncorrectException;
import Exceptions.NonCalculableException;
import Exceptions.colonnePasTrouveException;

public class DataFrame {
	///////////////////////////////////////////////////////////////////
	private String titre;
	public DataFrame()
	{
		this.setColonnes( new ArrayList<Colonne>() );
	}
	
	public String getTitre() {
		return titre;
	}	
	
	public void setTtitre(String titre) {
		this.titre = titre;
	}
	////////////////////////////////////////////////////////////////////
	private ArrayList<Colonne> colonnes;
	
	public ArrayList<Colonne> getColonnes() {
		return colonnes;
	}

	public void setColonnes(ArrayList<Colonne> colonnes) {
		this.colonnes = colonnes;
	}

    /**
     * Constructeur qui prend en entrée un tableau de colonnes
     *
     * @param Tableau de colonnes
     */
	public DataFrame(String titre, ArrayList<Colonne> colonnes){
		this.titre = titre;
		this.colonnes = colonnes;
	}

	 public int getNbLignes() {
			return getColonnes().get(0).getCellules().size();		
	}
	 public Colonne getColonne(String titre) throws Exception{
			for (int i = 0; i < this.getColonnes().size(); i++){
				if (this.getColonnes().get(i).getColonneTitre().toLowerCase().equals(titre.toLowerCase())){
					return this.getColonnes().get(i);
				}
			}
			throw new colonnePasTrouveException(titre);
		}
			
		
	 
	public void afficherTab()
	{
		System.out.print( "\t\t" );
	}
	
    public void afficher(String msg, int limit){
		System.out.print(msg.substring(0, Math.min(limit, msg.length())));
		if (msg.length() > limit){
			System.out.print("..");
		}
    }
    

}




	


	

