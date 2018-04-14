import Exceptions.CelluleNonComparableException;
import Exceptions.colonnePasTrouveException;

public class Cellule<E> {
	
	private E data;

	public Cellule(){
		this.data=null;
	}

	public Cellule(E data){
		this.data = data;
	}

	public Cellule(Cellule c){
		this.data = (E) c.data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public boolean compareCellule(Object obj) throws Exception{
		if(this.data==null) throw new CelluleNonComparableException();
		if (obj==null || getClass() != obj.getClass()){
			return false;
		}
		Cellule cellule2 = (Cellule)obj;
		if (this.getData().equals(cellule2.getData())){
			return true;
		}
		return false;
	}

	public int CelluleSize() throws Exception{	
		if(this.getData()==null) 
			throw new CelluleVideException();
		else {
			return this.data.toString().length();
		}
	}

	public void afficheCellule() throws Exception{
		if(this.getData()==null)
			throw new CelluleVideException();
		else{
			System.out.println(this.getData());
		}
	}

}
