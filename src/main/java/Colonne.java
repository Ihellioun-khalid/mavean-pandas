import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.sun.org.apache.bcel.internal.generic.Type;

import Exceptions.ColonneNonComparableException;
import Exceptions.ColonnePasCelluleException;
import Exceptions.ColonnePasTitreException;
import Exceptions.ColonnePasTypeException;
import Exceptions.ColonneVideException;
import Exceptions.IncoherenceTypeException;
import Exceptions.Indexofbound;

public class Colonne {
	
	private String colonneTitre;
	private Type colonneType;
	private ArrayList <Cellule> cellules;
	
	public Colonne() {
		this.colonneTitre = "";
		this.colonneType = null;
		this.cellules = null;
	}
	
	public Colonne(String colonneTitre, Type colonneType){
		this.colonneTitre = colonneTitre;
		this.colonneType = colonneType;
	}
	
	public Colonne(String colonneTitre, Type colonneType, ArrayList <Cellule> cellules){
		this.colonneTitre = colonneTitre;
		this.colonneType = colonneType;
		this.cellules = cellules;
	}
	
	public Colonne(Colonne a){
		this.colonneTitre = a.colonneTitre;
		this.colonneType = a.colonneType;
		this.cellules = a.cellules;
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
	
	
	public boolean compareColonne(Object obj) throws Exception{
		if(this.colonneTitre=="" && this.colonneType==null && this.cellules==null) throw new ColonneNonComparableException();
		if (obj==null || getClass() != obj.getClass()){
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
		if(this.getCellules()==null) throw new ColonnePasCelluleException();
		else {
			 System.out.println("les donnees de la Colonne "+getColonneTitre()+" sont:");
			 int size=this.cellules.size();
			 int j=0;
			 for(Cellule c : this.cellules ){
				 if(j!=size-1) {
					 System.out.print(c.getData()+"; ");
					 j++;
				 }
				 else {
					 System.out.println(c.getData());
				 }
	         }	
			 System.out.println("----------------------------------------------------------------------------------------");
		}
	}
	
	public int getSizeColonne(){	
		if(this.getCellules()==null) {
			return -1;
		}
		return this.getCellules().size();
	}

	public Colonne addDebutCellule(Cellule a) throws Exception{ 
		if((a.getData().getClass().getSimpleName()==this.getColonneType().toString()) || (this.getColonneType().toString()=="short" && a.getData().getClass().getSimpleName().trim().toString().equals("String"))) {
				Colonne resultat = new Colonne();
				ArrayList <Cellule> cellules=new ArrayList <Cellule>();
				cellules.add(a);
				for (Cellule c : this.cellules) {
					cellules.add(c);
				}
				resultat.colonneTitre=this.colonneTitre;
				resultat.colonneType=this.colonneType;
				resultat.cellules=cellules;
				return resultat;
			}else {
				throw new IncoherenceTypeException();
			}
	}

	public Colonne addFinCellule(Cellule a)throws Exception{
		if((a.getData().getClass().getSimpleName()==this.getColonneType().toString()) || (this.getColonneType().toString()=="short" && a.getData().getClass().getSimpleName().trim().toString().equals("String"))) {
			Colonne resultat = new Colonne();
			ArrayList <Cellule> cellules=new ArrayList <Cellule>();
			for (Cellule c : this.cellules) {
				cellules.add(c);
			}
			cellules.add(a);
			resultat.colonneTitre=this.colonneTitre;
			resultat.colonneType=this.colonneType;
			resultat.cellules=cellules;
			return resultat;
		}else {
			throw new IncoherenceTypeException();
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Colonne addCellule(Cellule a,int i)throws Exception{
		if((a.getData().getClass().getSimpleName()==this.getColonneType().toString()) || 
			(this.getColonneType().toString()=="short" && a.getData().getClass().getSimpleName().trim().toString().equals("String"))){
			if(i>=this.cellules.size()+1) new Indexofbound();
			Colonne resultat = new Colonne();
			resultat.cellules=this.cellules;
			cellules.add(i,a);
				resultat.colonneTitre=this.colonneTitre;
				resultat.colonneType=this.colonneType;
				resultat.cellules=cellules;
				return resultat;
			
		}else {
			throw new IncoherenceTypeException();
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Colonne supprimeCellule(Cellule a)throws Exception{
		if(this.cellules==null) throw new ColonneVideException();
		else {
//			if((obj.getClass().getSimpleName()==this.getColonneType().toString()) || 
//					(this.getColonneType().toString()=="short" && obj.getClass().getSimpleName().trim().toString().equals("String"))){
//					for(int i=this.cellules.size()-1; i>=0; i--){
//						Cellule o= cellules.get(i);
//						System.out.println("ok");
//						Type t = (Type)obj;
//						System.out.println(t.getType());
//						if(o.getData().equals(t))
//							System.out.println("ok");
//					    }
//					for (Cellule c : cellules) {
//						//System.out.println(c.getData());
//					}
////					Colonne resultat = new Colonne();
////					resultat.colonneTitre=this.colonneTitre;
////					resultat.colonneType=this.colonneType;
////					resultat.cellules=cellules;
					return null;
			}
//			else {
//				throw new IncoherenceTypeException();
//			}
		}	
//	}
	
	public Colonne supprimeDuplicateCellule()throws Exception{
		LinkedHashSet<Cellule> lhs = new LinkedHashSet<Cellule>();
		lhs.addAll(this.cellules);
		this.cellules.clear();
		this.cellules.addAll(lhs);
		
		Colonne resultat = new Colonne();
		resultat.colonneTitre=this.colonneTitre;
		resultat.colonneType=this.colonneType;
		resultat.cellules=cellules;
		return resultat;
	}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Colonne supprimeCellule(int i)throws Exception{
		if(this.cellules==null) throw new ColonneVideException();
		if(i>=this.cellules.size()) new Indexofbound();
		else {
			this.cellules.remove(i);
		}
		Colonne resultat = new Colonne();
		resultat.colonneTitre=this.colonneTitre;
		resultat.colonneType=this.colonneType;
		resultat.cellules=cellules;
		return resultat;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Colonne supprimeCellule(ArrayList<Cellule> cellules)throws Exception{
		if(this.cellules==null) throw new ColonneVideException();
		return null;
	}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public Colonne modifieCellule(){
//		return null;
//	}
}
