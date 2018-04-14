import java.util.ArrayList;
import com.sun.org.apache.bcel.internal.generic.Type;
public class Run {

	public static void main(String[] args) throws Exception {
		
		try {
			
			//Cellule test
				Cellule a = new Cellule<>("ee");
				Cellule b = new Cellule<>("1");
				b.afficheCellule();
//				Cellule c = new Cellule<>("ee");
//				a.afficheCellule();
//				System.out.println(a.CelluleSize());
//				System.out.println(b.CelluleSize());
				
			//Colonne test
				
				ArrayList <Cellule> cellules_a = new ArrayList<>();
				ArrayList <Cellule> cellules_b = new ArrayList<>();
				ArrayList <Cellule> cellules_c = new ArrayList<>();
				ArrayList <Cellule> cellules_e = new ArrayList<>();
				cellules_a.add(a);
				cellules_a.add(a);
				cellules_a.add(a);
				cellules_a.add(a);
				
				Colonne aa =new Colonne();
				Colonne cc =new Colonne("Pays", Type.getType("SHORT"), cellules_c);
				Colonne dd =new Colonne("Pays", Type.getType("INTEGER"), cellules_b);
				Colonne ee =new Colonne("Pays", Type.getType("STRING"), cellules_a);
				//aa.addDebutCellule(b);
//				aa.afficheColonne();
//				cc.afficheColonne();
//				dd.afficheColonne();
//				System.out.println(cc.compareColonne(dd));
//				System.out.println(aa.compareColonne(aa));	
//				System.out.println(cc.compareColonne(dd));
				System.out.println(aa.getSizeColonne());
				System.out.println(cc.getSizeColonne());
				System.out.println(dd.getSizeColonne());
				System.out.println(ee.getSizeColonne());
				//ee.afficheColonne();
				//addCellule()
				//suppCellule()
				//modifieCellule()
				
			}catch(Exception e){
				//System.out.println(e.getMessage());
			}
		

		
		
		
		
//    		ArrayList<Cellule> colonne01 = new ArrayList<>();
//    		ArrayList<Cellule> colonne02 = new ArrayList<>();
//    		ArrayList<Cellule> colonne03 = new ArrayList<>();
     		
    		
//    		Colonne cc =new Colonne("Pays", Type.getType("SHORT"), colonne01);
//    		cc.afficheColonne();
//    		System.out.println(cc.getSizeColonne());
//    		
	}
}
