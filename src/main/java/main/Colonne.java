package main;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.sun.org.apache.bcel.internal.generic.Type;

import Exceptions.ColonneNonComparableException;
import Exceptions.ColonnePasUnitException;
import Exceptions.ColonnePasTitreException;
import Exceptions.ColonnePasTypeException;
import Exceptions.ColonneVideException;
import Exceptions.IncoherenceTypeException;
import Exceptions.Indexofbound;

/**
 * Un objet Colonne pour stocker des données de même type
 * @author IHELLIOUN Khalid, SARRAJ Ahhmed, ABDULLAH HASIM Mohd Thaqif
 * @version 1.0
 *
 */
public class Colonne {
	
	/**
	 * Le titre/label d'une colonne
	 */
	private String colonneTitre;
	/**
	 * Le type de données stockées
	 */
	private Type colonneType;
	/**
	 * Une liste des Units
	 */
	private ArrayList <Unit> units;
	
	/**
	 * Le constructeur qui initialise une colonne avec un titre vide, le type de données null, et, une liste de units null
	 */
	public Colonne() {
		this.colonneTitre = "";
		this.colonneType = null;
		this.units = null;
	}
	
	
	/**
	 * Le constructer qui crée une colonne avec un titre et son type de données stockées 
	 * @param colonneTitre Le titre/label de la colonne
	 * @param colonneType Le type de données stockées
	 */
	public Colonne(String colonneTitre, Type colonneType){
		this.colonneTitre = colonneTitre;
		this.colonneType = colonneType;
	}
	
	/**
	 * Le constructeur qui crée une colonne avec un titre, le type de données stockées et une liste de données à stocker
	 * @param colonneTitre Le titre de la colonne
	 * @param colonneType Le type de données 
	 * @param units La liste de données à stocker
	 */
	public Colonne(String colonneTitre, Type colonneType, ArrayList <Unit> units){
		this.colonneTitre = colonneTitre;
		this.colonneType = colonneType;
		this.units = units;
	}
	
	/**
	 * Le constructeur qui copier une colonne déjà crééé
	 * @param a La colonne à être copiée
	 */
	public Colonne(Colonne a){
		this.colonneTitre = a.colonneTitre;
		this.colonneType = a.colonneType;
		this.units = a.units;
	}
	
	/**
	 * Récuperer le titre de colonne
	 * @return Le titre de colonne
	 */
	public String getColonneTitre() {
		return colonneTitre;
	}

	/**
	 * Donner un titre pour une colonne
	 * @param colonneTitre Le titre de colonne
	 */
	public void setColonneTitre(String colonneTitre) {
		this.colonneTitre = colonneTitre;
	}
	
	/**
	 * Récupérer le type de données d'une colonne 
	 * @return Le type de données stockées
	 */
	public Type getColonneType() {
		return colonneType;
	}

	/**
	 * Donner le type de données stockées dans la colonne
	 * @param colonneType Le type de données
	 */
	public void setColonneType(Type colonneType) {
		this.colonneType = colonneType;
	}

	/**
	 * Récupérer la liste de données stockées dans la colonne
	 * @return La liste de données stockées
	 */
	public ArrayList<Unit> getUnits() {
		return units;
	}

	/**
	 * Ajouter une liste de données à être stockée dans la colonne
	 * @param units Une liste de données à être stockée
	 */
	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}
	
	
	public boolean compareColonne(Object obj) throws Exception{
		if(this.colonneTitre=="" && this.colonneType==null && this.units==null) throw new ColonneNonComparableException();
		if (obj==null || getClass() != obj.getClass()){
			return false;
		}
		
		Colonne unit2 = (Colonne)obj;
		if (!this.getColonneTitre().equals(unit2.getColonneTitre())){
			return false;
		}
		
		if (!this.getColonneType().equals(unit2.getColonneType())){
			return false;
		}
		
		if (!this.getUnits().equals(unit2.getUnits())){
			return false;
		}
		
		return true;
	}
	
	
	
	/**
	 * Afficher la colonne
	 * @throws Exception La colonne doit avoir un titre, le type de colonne != null,  et elle ne doit pas être vide
	 */
	public void afficheColonne() throws Exception{
		
		if(getColonneTitre()==null || getColonneTitre()=="" ) throw new ColonnePasTitreException();
		else {
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("titre:"+getColonneTitre());
			System.out.println("----------------------------------------------------------------------------------------");
		}
		
		if(getColonneType()==null) throw new ColonnePasTypeException();
		else {
			System.out.println("type:"+getColonneType());
			System.out.println("----------------------------------------------------------------------------------------");
		}	
		if(this.getUnits()==null) throw new ColonnePasUnitException();
		else {
			 System.out.println("les donnees de la Colonne "+getColonneTitre()+" sont:");
			 int size=this.units.size();
			 int j=0;
			 for(Unit u : this.units ){
				 if(j!=size-1) {
					 System.out.print(u.getData()+"; ");
					 j++;
				 }
				 else {
					 System.out.println(u.getData());
				 }
	         }	
			 System.out.println("----------------------------------------------------------------------------------------");
		}
	}
	
	/**
	 * Récupérer la taille de colonne
	 * @return La taille de colonne
	 */
	public int getSizeColonne(){	
		if(this.getUnits()==null) {
			return -1;
		}
		return this.getUnits().size();
	}

	/**
	 * Ajouter une donnée dans la colonne. La donnée sera stockée à la première ligne
	 * @param a La donnée
	 * @return Une colonne
	 * @throws Exception La donnée à être ajoutée doit être de même type que celui de la colonne
	 */
	public Colonne addDebutUnit(Unit a) throws Exception{ 
		if((a.getData().getClass().getSimpleName()==this.getColonneType().toString()) || (this.getColonneType().toString()=="short" && a.getData().getClass().getSimpleName().trim().toString().equals("String"))) {
				Colonne resultat = new Colonne();
				ArrayList <Unit> units=new ArrayList <Unit>();
				units.add(a);
				for (Unit u : this.units) {
					units.add(u);
				}
				resultat.colonneTitre=this.colonneTitre;
				resultat.colonneType=this.colonneType;
				resultat.units=units;
				return resultat;
			}else {
				throw new IncoherenceTypeException();
			}
	}

	/**
	 * Ajouter un donnée dans la colonne. Elle sara stockée à la dernière ligne
	 * @param a La donnée à être ajoutée
	 * @return Une colonne
	 * @throws Exception La donnée à être ajoutée doit être de même type que celui de la colonne
	 */
	public Colonne addFinUnit(Unit a)throws Exception{
		if((a.getData().getClass().getSimpleName()==this.getColonneType().toString()) || (this.getColonneType().toString()=="short" && a.getData().getClass().getSimpleName().trim().toString().equals("String"))) {
			Colonne resultat = new Colonne();
			ArrayList <Unit> units=new ArrayList <Unit>();
			for (Unit u : this.units) {
				units.add(u);
			}
			units.add(a);
			resultat.colonneTitre=this.colonneTitre;
			resultat.colonneType=this.colonneType;
			resultat.units=units;
			return resultat;
		}else {
			throw new IncoherenceTypeException();
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Ajouter une donnée dans la colonne. Elle sera stockée dans la ligne passée en paramètre
	 * @param a La donnée
	 * @param i L'indice/index 
	 * @return Une colonne
	 * @throws Exception L'indice donée doit être entre 0 ou la taille maximale de la colonne
	 */
	public Colonne addUnit(Unit a,int i)throws Exception{
		if((a.getData().getClass().getSimpleName()==this.getColonneType().toString()) || 
			(this.getColonneType().toString()=="short" && a.getData().getClass().getSimpleName().trim().toString().equals("String"))){
			if(i>=this.units.size()+1) new Indexofbound();
			Colonne resultat = new Colonne();
			resultat.units=this.units;
			units.add(i,a);
				resultat.colonneTitre=this.colonneTitre;
				resultat.colonneType=this.colonneType;
				resultat.units=units;
				return resultat;
			
		}else {
			throw new IncoherenceTypeException();
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Supprimer les données en double dans une colonne
	 * @return Une colonne
	 * @throws Exception 
	 */
	public Colonne supprimeDuplicateUnit()throws Exception{
		LinkedHashSet<Unit> lhs = new LinkedHashSet<Unit>();
		lhs.addAll(this.units);
		this.units.clear();
		this.units.addAll(lhs);
		
		Colonne resultat = new Colonne();
		resultat.colonneTitre=this.colonneTitre;
		resultat.colonneType=this.colonneType;
		resultat.units=units;
		return resultat;
	}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Supprimer une donnée dans la colonne
	 * @param i La ligne de la donnée à être supprimée
	 * @return Une colonne
	 * @throws Exception La donnée doit être existe dans la ligne demandée
	 */
	public Colonne supprimeUnit(int i)throws Exception{
		if(this.units==null) throw new ColonneVideException();
		if(i>=this.units.size()) new Indexofbound();
		else {
			this.units.remove(i);
		}
		Colonne resultat = new Colonne();
		resultat.colonneTitre=this.colonneTitre;
		resultat.colonneType=this.colonneType;
		resultat.units=units;
		return resultat;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public Colonne supprimeUnit(ArrayList<Unit> units)throws Exception{
//		if(this.units==null) throw new ColonneVideException();
//		return null;
//	}
//	public Colonne supprimeUnit(Unit a)throws Exception{
//	System.out.println("test1");
//	if(this.units==null) throw new ColonneVideException();
//	if(a==null) return this;
//	else {
////		System.out.println("test3");
//			if(a.getData().getClass().getSimpleName()==this.getColonneType().toString()|| 
//					(this.getColonneType().toString()=="short" && a.getData().getClass().getSimpleName().trim().toString().equals("String"))) { 
//				System.out.println("test1");
//				
////				for(int i=this.units.size()-1; i>=0; i--){
////					Unit o= units.get(i);
////					System.out.println("ok");
////					Type t = (Type)obj;
////					System.out.println(t.getType());
////					if(o.getData().equals(t))
////						System.out.println("ok");
////				    }
////				for (Unit c : units) {
////					//System.out.println(c.getData());
////				}
//////				Colonne resultat = new Colonne();
//////				resultat.colonneTitre=this.colonneTitre;
//////				resultat.colonneType=this.colonneType;
//////				resultat.units=units;
//				return null;
//				}else {
//					throw new IncoherenceTypeException();
//		        }
//	    }	
//
//}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public Colonne modifieUnit(){
//		return null;
//	}
}
