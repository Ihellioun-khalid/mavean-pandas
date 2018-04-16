import Exceptions.UnitVideException;
import Exceptions.UnitsNonComparableException;

public class Unit<E> {
	
	private E data;

	public Unit(){
		this.data=null;
	}

	public Unit(E data){
		this.data = data;
	}

	public Unit(Unit u){
		this.data = (E) u.data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

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

	public int UnitSize() throws Exception{	
		if(this.getData()==null) 
			throw new UnitVideException();
		else {
			return this.data.toString().length();
		}
	}

	public void afficheUnit() throws Exception{
		if(this.getData()==null)
			throw new UnitVideException();
		else{
			System.out.println(this.getData());
		}
	}

}
