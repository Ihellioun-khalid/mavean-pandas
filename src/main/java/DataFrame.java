import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.Type;
//import exceptions.ColonneNonCalculableException;
//import exceptions.ColonneNonTrouveeException;

public class DataFrame {
	///////////////////////////////////////////////////////////////////
	private String titre;
	
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
         public void afficherTitres()
	{
		System.out.println("DataFrame : "+this.getTitre());
		System.out.print("Ligne\t\t");
		for( Colonne c : this.getColonnes() )
		{
			afficher( c.getColonneTitre() + "", 5 );
			afficherTab();
		}
		System.out.print( "\n" );
		System.out.print( "-----------------------------------------------------------------------------\n" );
}
         public void afficherTitres(int start, int end )
	{
		System.out.println("DataFrame : "+this.getTitre());
		System.out.print("Ligne\t\t");
		for( int i = start; i < end; i++  )
		{
			afficher( this.getColonnes().get( i ).getColonneTitre() + "", 5 );
			afficherTab();
		}
		System.out.print( "\n" );
		System.out.print( "----------------------------------------------------------------------\n" );
}
         public void afficherTitres( String... arg ) throws Exception
	{
		System.out.println("DataFrame : "+this.getTitre());
		System.out.print("Ligne\t\t");
		for( String c : arg )
		{
			Colonne col = this.getColonne( c );
			if( col != null )
			{
				afficher( col.getColonneTitre() + "", 5 );
				afficherTab();
			}
		}
		System.out.print( "\n" );
		System.out.print( "----------------------------------------------------------------------\n" );
}
	public void afficherDataframe(){
        afficherTitres();
        // Affichage des données
        for (int numLigne = 0; numLigne < this.getNbLignes(); numLigne++){
            // Affichage des lignes
            System.out.print(numLigne+"\t\t");
            for( Colonne c : this.getColonnes() )
            {
                afficher( c.getCellules().get( numLigne ).getValue() + "", 5 );
                afficherTab();
            }
            System.out.println();
        }

	
}
