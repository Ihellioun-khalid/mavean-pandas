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

public class Colonne {
	
	private String colonneTitre;
	private Type colonneType;
	private ArrayList <Unit> units;
	
	public Colonne() {
		this.colonneTitre = "";
		this.colonneType = null;
		this.units = null;
	}
	
	public Colonne(String colonneTitre, Type colonneType){
		this.colonneTitre = colonneTitre;
		this.colonneType = colonneType;
	}
	
	public Colonne(String colonneTitre, Type colonneType, ArrayList <Unit> units){
		this.colonneTitre = colonneTitre;
		this.colonneType = colonneType;
		this.units = units;
	}
	
	public Colonne(Colonne a){
		this.colonneTitre = a.colonneTitre;
		this.colonneType = a.colonneType;
		this.units = a.units;
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

	public ArrayList<Unit> getUnits() {
		return units;
	}


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
	
	public int getSizeColonne(){	
		if(this.getUnits()==null) {
			return -1;
		}
		return this.getUnits().size();
	}

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
