package main;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.Type;
//import exceptions.ColonneNonCalculableException;
//import exceptions.ColonneNonTrouveeException;

import Exceptions.ColonnePasTrouveException;
import Exceptions.IndiceGrandException;
import Exceptions.IndiceIncorrectException;
import Exceptions.NonCalculableException;


/**
 * Dataframe est un outil de gestion de données comme le Dataframe en Python
 * @author IHELLIOUN Khalid, SARRAJ Ahhmed, ABDULLAH HASIM Mohd Thaqif
 * @version 1.0
 *
 */
public class DataFrame {
	///////////////////////////////////////////////////////////////////
	
	/**
	 * Le titre pour le Dataframe
	 */
	private String titre;
	
	/**
	 * Le constructeur qui initialise un Dataframe avec une liste de colonnes vide
	 */
	public DataFrame()
	{
		this.setColonnes( new ArrayList<Colonne>() );
	}
	
	/**
	 * Le constructeur à partir d'un fichier CSV
	 * @param csv Le nom de fichier csv
	 * @throws IOException Le fichier csv doit être existé
	 */
	public DataFrame(String csv) throws IOException{
		CSVParser parsing = new CSVParser(csv);
		this.titre = parsing.getName();
		this.colonnes = parsing.getAllColumn();
	}
	
	/**
	 * Récuperer le titre du Dataframe
	 * @return titre Le titre
	 */
	public String getTitre() {
		return titre;
	}	
	
	/**
	 * Donner un titre au Dataframe
	 * @param titre Le titre
	 */
	public void setTtitre(String titre) {
		this.titre = titre;
	}
	////////////////////////////////////////////////////////////////////
	/**
	 * Une liste de colonnes stockés
	 */
	private ArrayList<Colonne> colonnes;
	
	/**
	 * Récuperer une liste de colonnes
	 * @return Une liste de colonnes
	 */
	public ArrayList<Colonne> getColonnes() {
		return colonnes;
	}

	/**
	 * Ajouter une liste de colonnes
	 * @param colonnes La liste de colonnes à ajouter
	 */
	public void setColonnes(ArrayList<Colonne> colonnes) {
		this.colonnes = colonnes;
	}
	/**
	 * Le constructeur de Dataframe
	 * @param titre Le titre de Dataframe
	 * @param colonnes Une liste de colonnes à ajouter
	 */
	public DataFrame(String titre, ArrayList<Colonne> colonnes){
		this.titre = titre;
		this.colonnes = colonnes;
	}

	/**
	 * Récupere le nombre de ligne/index du Dataframe
	 * @return Le nombre de ligne/index du Dataframe
	 */
	public int getLigneNumber() {
			return getColonnes().get(0).getUnits().size();		
	}
	
	 /**
	  * Récuperer un Colonne selon son titre
	  * @param titre Le titre de la colonnne à récuperer
	  * @return	Une colonne de type Colonne
	  * @throws Exception Si le titre ne correspond à aucun des titres de colonnes stockés
	  */
	 public Colonne getColonne(String titre) throws Exception{
			for (int i = 0; i < this.getColonnes().size(); i++){
				if (this.getColonnes().get(i).getColonneTitre().toLowerCase().equals(titre.toLowerCase())){
					return this.getColonnes().get(i);
				}
			}
			throw new ColonnePasTrouveException(titre);
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
    
    /**
     * Afficher le titre du Dataframe et les titres de toutes les colonnes
     */
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
  
    /**
     * Afficher le titre du Dataframe, et les titres des colonnes sélectionnés entre l'indice de debut et l'indice de fin d'une liste de colonnes
     * @param debut L'indice de debut d'une liste de colonnes
     * @param fin L'indice de fin d'une liste de colonnes
     */
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
    
    /**
     * Afficher le titre du Dataframe, et les titres des colonnes sélectionnés selon des titres passés en arguments
     * @param arg Les titres des colonnes à afficher
     * @throws Exception Si un ou plusieurs titres passés en arguments ne correspondent à aucun des titres de colonnes stockés
     */
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
    
    /**
     * Afficher tout le dataframe
     */
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
  
    /**
     * Sélectionner un sous-ensemble de lignes à partir de leur index  
     * @param debut Index de debut
     * @param fin Index de fin
     * @return Un dataframe contenant le sous-ensemble de lignes à partir de leur index
     * @throws IndiceIncorrectException Index Les indices indiquées doivent être entre 0 et la taille maximal du Dataframe
     * @throws IndiceGrandException L'indice de debut doit être inférieur à l'indice de fin
     */
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
  
	/**
	 * Sélectionner un sous-ensemble de colonnes à partir des indices données en paramètre
	 * @param debut Indice de debut
	 * @param fin Indice de fin
	 * @return Un dataframe contenant un sous-ensemble de colonnes
	 * @throws IndiceIncorrectException Les indices doivent être entre 0 et la taille maximale de nombre de colonnes
	 * @throws IndiceGrandException L'indice de debut doit être inférieur à l'indice de fin
	 */
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
  
	/**
	 * Afficher les lignes à partir de leur index
	 * @param debut L'indice de debut
	 * @param fin L'indice de fin
	 * @throws IndiceIncorrectException	Les indices doivent être entre 0 et la taille maximale de nombre de lignes
	 * @throws IndiceGrandException L'indice de debut doit être inférieur à l'indice de fin
	 */
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
	
	/**
	 * Afficher un sous ensemble de colonnes à partir de leur indices
	 * @param debut L'indice de debut
	 * @param fin L'indice de fin
	 * @throws IndiceIncorrectException	Les indices doivent être entre 0 et la taille maximale de nombre de colonnes
	 * @throws IndiceGrandException L'indice de debut doit être inférieur à l'indice de fin
	 */
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
	
	/**
	 * Calculer la moyenne des valeurs d'une colonne sélecionnée à partir de son titre
	 * @param colonneLabel Le titre de colonne
	 * @return Le moyenne des valeurs
	 * @throws Exception Les données qui ne sont pas de type FLOAT ou INT ne peuvent pas être calculées
	 */
	public float calculateAverge(String colonneLabel) throws Exception {
		Colonne colonne = this.getColonne(colonneLabel);
		
		Type type = colonne.getColonneType();
		if (type != Type.FLOAT && type != Type.INT){
			throw new NonCalculableException();
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
	
  
	/**
	 * Calculer la valeur minimum d'une colonne sélectionnée à partir de son titre
	 * @param colonneLabel Le titre de colonne
	 * @return La valeur minimum trouvée
	 * @throws Exception Les données qui ne sont pas de type FLOAT ou INT ne peuvent pas être calculées
	 */
	public float calculateMinimum(String colonneLabel) throws Exception {
		Colonne colonne = this.getColonne(colonneLabel);
		
		Type type = colonne.getColonneType();
		if (type != Type.FLOAT && type != Type.INT){
			throw new NonCalculableException();
		}

		Float min = Float.MAX_VALUE;
		
		for (int i = 0; i < colonne.getUnits().size(); i++){
			if (colonne.getUnits().get(i).getData() != null && min > Float.valueOf(colonne.getUnits().get(i).getData().toString())){
				min = Float.valueOf(colonne.getUnits().get(i).getData().toString());
			}
		}
		return min;
	}
	
  
	/**
	 * Calculer la valeur maximum d'une colonne sélectionnée à partir de son titre
	 * @param colonneLabel Le titre de colonne
	 * @return La valeur maximum trouvée
	 * @throws Exception Les données qui ne sont pas de type FLOAT ou INT ne peuvent pas être calculées
	 */
	public float calculateMaximum(String colonneLabel) throws Exception {
		Colonne colonne = this.getColonne(colonneLabel);
		
		Type type = colonne.getColonneType();
		if (type != Type.FLOAT && type != Type.INT){
			throw new NonCalculableException();
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




	


	

