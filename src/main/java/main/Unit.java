package main;
import Exceptions.UnitVideException;
import Exceptions.UnitsNonComparableException;

/**
 * Une donnée stockée dans une colonne se represente comme un Unit
 * @author IHELLIOUN Khalid, SARRAJ Ahhmed, ABDULLAH HASIM Mohd Thaqif
 * @version 1.0
 * @param <E> Le type des données
 */
public class Unit<E> {
	
	private E data;

	/**
	 * Le constructeur qui une donnée null
	 */
	public Unit(){
		this.data=null;
	}

	/**
	 * Le constructeur qui définit une donnée
	 * @param data
	 */
	public Unit(E data){
		this.data = data;
	}

	/**
	 * Le constructeur qui copie une donnée
	 * @param u Unit
	 */
	public Unit(Unit u){
		this.data = (E) u.data;
	}

	/**
	 * Récupérer une donnée
	 * @return Une donnée
	 */
	public E getData() {
		return data;
	}

	/**
	 * Modifier une donnée dans une colonne
	 * @param data La donnée à être mis
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Comparer une donnée Unit avec une autre donnée Unit
	 * @param obj Un objet de type Unit
	 * @return True si les données ont le même type, False sinon
	 * @throws Exception
	 */
	public boolean compareUnit(Object obj) throws Exception{
		if(this.data==null) throw new UnitsNonComparableException();
		if (obj==null || getClass() != obj.getClass()){
			return false;
		}
		Unit unit2 = (Unit)obj;
		if (this.getData().equals(unit2.getData())){
			return true;
		}
		return false;
	}

	/**
	 * Récupérer la taille d'une donnée Unit
	 * @return La taille 
	 * @throws Exception
	 */
	public int UnitSize() throws Exception{	
		if(this.getData()==null) 
			throw new UnitVideException();
		else {
			return this.data.toString().length();
		}
	}

	/**
	 * Afficher la donnée d'Unit
	 * @throws Exception
	 */
	public void afficheUnit() throws Exception{
		if(this.getData()==null)
			throw new UnitVideException();
		else{
			System.out.println(this.getData());
		}
	}

}
