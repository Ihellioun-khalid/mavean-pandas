public class Cellule<E> {
	
	private E data;

	public Cellule(){
		this.data=null;
	}
	
	public Cellule(E data){
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	public boolean equals(Object obj){
		if (obj == null || getClass() != obj.getClass()){
			return false;
		}
		Cellule cellule2 = (Cellule)obj;
		if (this.getData().equals(cellule2.getData())){
			return true;
		}
		return false;
	}
	
	public int CelluleSize() {	
		if(this.getData()==null) 
			return -1;
		else {
			return this.data.toString().length();
		}
	}
	
	public void afficheCellule() {
		if(this.getData()==null)
			System.out.println("la cellule ne contient aucune data !!");
		else{
			System.out.println(this.getData());
		}
	}
	
}
