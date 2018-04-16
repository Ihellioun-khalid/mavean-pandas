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

	public DataFrame(String titre, ArrayList<Colonne> colonnes){
		this.titre = titre;
		this.colonnes = colonnes;
	}

	 public int getLigneNumber() {
			return getColonnes().get(0).getUnits().size();		
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
  
    public void afficherTitres(int debut, int fin ){
		System.out.println("DataFrame : "+this.getTitre());
		System.out.print("Ligne\t\t");
		for( int i = debut; i < fin; i++  )
		{
			afficher( this.getColonnes().get( i ).getColonneTitre() + "", 7 );
			afficherTab();
		}
		System.out.print( "\n" );
		System.out.print( "----------------------------------------------------------------------\n" );
    }
    
    public void afficherTitres( String... arg ) throws Exception{
		System.out.println("DataFrame : "+this.getTitre());
		System.out.print("Ligne\t\t");
		for( String c : arg )
		{
			Colonne col = this.getColonne(c);
			if( col != null )
			{
				afficher( col.getColonneTitre() + "", 7 );
				afficherTab();
			}
		}
		System.out.print( "\n" );
		System.out.print( "----------------------------------------------------------------------\n" );
    }
    
	public void afficherDataframe(){
      afficherTitres();
      // Affichage des données
      for (int numLigne = 0; numLigne < this.getLigneNumber(); numLigne++){
          // Affichage des lignes
          System.out.print(numLigne+"\t\t");
          for( Colonne c : this.getColonnes() )
          {
              afficher( c.getUnits().get( numLigne ).getData() + "", 6 );
              afficherTab();
          }
          System.out.println();
      }}
		
    	public int getSize()
	{
		int size = -1;
		
		for( Colonne c : this.getColonnes() )
		{
			if( c.getUnits().size() > size )
				size = c.getUnits().size();
		}
		
		return size;
}
       public int getSizeColonnes()
		{	
		return this.getColonnes().size();
	}
  
	public DataFrame selectLignes( int debut, int fin ) throws IndiceIncorrectException, IndiceGrandException
	{
		DataFrame df = new DataFrame();
		if( debut < 0 || fin > this.getSize() )
			throw new IndiceIncorrectException();
		else if( debut > fin )
			throw new IndiceGrandException();
		else
		{
			df.setTtitre( this.getTitre() + " - lignes " + debut + ", " + fin );
			// Ajouter les colonnes au data frame avec les mêmes labels
			for( Colonne c : this.getColonnes() )
			{
				Colonne t = new Colonne( c.getColonneTitre(), c.getColonneType() );
				for( int i = debut; i <= fin; i++ )
				{
					t.getUnits().add( c.getUnits().get( i ) );
				}
				df.getColonnes().add( t );
			}
		}
		return df;
		
	}
  
	public DataFrame selectColonnes( int debut, int fin ) throws IndiceIncorrectException, IndiceGrandException{
		DataFrame df = new DataFrame();
		if( debut < 0 || fin > this.getSize() )
			throw new IndiceIncorrectException();
		else if( debut > fin )
			throw new IndiceGrandException();
		else 
		{
			df.setTtitre( this.getTitre() + " - colonnes " + debut + ", " + fin );
			for( int i = debut; i <= fin; i++ )
			{
				Colonne c = this.getColonnes().get( i );
				df.getColonnes().add( c );
			}
		}
		return df;
	}
  
	public void afficherLignes( int debut, int fin ) throws IndiceIncorrectException, IndiceGrandException
	{
		// On vérifie que les indices existent dans le DataFrame
		if( debut < 0 || fin > this.getSize() )
			throw new IndiceIncorrectException();
		else if( debut > fin )
			throw new IndiceGrandException();
		else
		{
			afficherTitres();
			for( int i = debut; i <= fin; i++ )
			{
				System.out.print( i + "\t\t" );
				for( Colonne c : this.getColonnes() )
				{
					afficher( c.getUnits().get( i ).getData() + "", 5 );
					afficherTab();
				}
				System.out.print("\n");
			}
		}
	}
	
	public void afficherColonnes( int debut, int fin ) throws IndiceIncorrectException, IndiceGrandException
	{
		if( debut < 0 || fin > this.getSizeColonnes() )
			throw new IndiceIncorrectException();
		else if( debut > fin )
			throw new IndiceGrandException();
		else
		{
			afficherTitres( debut, fin );
			for( int i = 0; i < this.getSize(); i++ )
			{
				System.out.print( i + "\t\t" );
				for( int j = debut; j < fin; j++ )
				{
					afficher( this.getColonnes().get(j).getUnits().get(i).getData() + "", 7);
					afficherTab();
				}
				System.out.print("\n");
			}
		}
	}
	public float calculateAverge(String colonneLabel) throws Exception {
		Colonne colonne = this.getColonne(colonneLabel);
		
		Type type = colonne.getColonneType();
		if (type != Type.FLOAT && type != Type.INT){
			throw new NonCalculableException(colonneLabel, type);
		}

		Float somme = 0f;
		int nbElements = 0;
		
		for (int i = 0; i < colonne.getUnits().size(); i++){
			if (colonne.getUnits().get(i).getData() != null){
				somme += Float.valueOf(colonne.getUnits().get(i).getData().toString());
				nbElements++;
			}
		}
		return somme/nbElements;
	}
	
  
	public float calculateMinimum(String colonneLabel) throws Exception {
		Colonne colonne = this.getColonne(colonneLabel);
		
		Type type = colonne.getColonneType();
		if (type != Type.FLOAT && type != Type.INT){
			throw new NonCalculableException(colonneLabel, type);
		}

		Float min = Float.MAX_VALUE;
		
		for (int i = 0; i < colonne.getUnits().size(); i++){
			if (colonne.getUnits().get(i).getData() != null && min > Float.valueOf(colonne.getUnits().get(i).getData().toString())){
				min = Float.valueOf(colonne.getUnits().get(i).getData().toString());
			}
		}
		return min;
	}
	
  
	public float calculateMaximum(String colonneLabel) throws Exception {
		Colonne colonne = this.getColonne(colonneLabel);
		
		Type type = colonne.getColonneType();
		if (type != Type.FLOAT && type != Type.INT){
			throw new NonCalculableException(colonneLabel, type);
		}

		Float max = 0f;
		
		for (int i = 0; i < colonne.getUnits().size(); i++){
			if (colonne.getUnits().get(i).getData() != null && max < Float.valueOf(colonne.getUnits().get(i).getData().toString())){
				max = Float.valueOf(colonne.getUnits().get(i).getData().toString());
			}
		}
		return max;
	}
}




	


	

