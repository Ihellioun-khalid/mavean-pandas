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
		
       public int getSize()
	{
		int size = -1;
		
		for( Colonne c : this.getColonnes() )
		{
			if( c.getCellules().size() > size )
				size = c.getCellules().size();
		}
		
		return size;
}
         public int getSizeColonnes()
	{	
		return this.getColonnes().size();
}
	public DataFrame selectLignes( int start, int end ) throws IndiceDataFrameIncorrectException, IndiceDebutTropGrandException
	{
		DataFrame df = new DataFrame();
		if( start < 0 || end > this.getSize() )
			throw new IndiceDataFrameIncorrectException();
		else if( start > end )
			throw new IndiceDebutTropGrandException();
		else
		{
			df.setTtitre( this.getTitre() + " - lignes " + start + ", " + end );
			// Ajouter les colonnes au data frame avec les mêmes labels
			for( Colonne c : this.getColonnes() )
			{
				Colonne t = new Colonne( c.getColonneTitre(), c.getColonneType() );
				for( int i = start; i <= end; i++ )
				{
					t.getCellules().add( c.getCellules().get( i ) );
				}
				df.getColonnes().add( t );
			}
		}
		return df;
		
}
         public DataFrame selectColonnes( int start, int end ) throws IndiceDataFrameIncorrectException, IndiceDebutTropGrandException
	{
		DataFrame df = new DataFrame();
		if( start < 0 || end > this.getSize() )
			throw new IndiceDataFrameIncorrectException();
		else if( start > end )
			throw new IndiceDebutTropGrandException();
		else 
		{
			df.setTtitre( this.getTitre() + " - colonnes " + start + ", " + end );
			for( int i = start; i <= end; i++ )
			{
				Colonne c = this.getColonnes().get( i );
				df.getColonnes().add( c );
			}
		}
		return df;
}


	
}

	
}
