import java.util.ArrayList;
import com.sun.org.apache.bcel.internal.generic.Type;
public class Run {

	public static void main(String[] args) throws Exception {
		
		try {
			
			//Cellule test
				Cellule a = new Cellule<>("a");
				Cellule b = new Cellule<>(22.2);
				Cellule c = new Cellule<>("cccc");
//				a.afficheCellule();
//				System.out.println(a.CelluleSize());
//				System.out.println(b.CelluleSize());
				
			//Colonne test
				
				ArrayList <Cellule> cellules_a = new ArrayList<>();
				ArrayList <Cellule> cellules_b = new ArrayList<>();
				ArrayList <Cellule> cellules_c = new ArrayList<>();
				ArrayList <Cellule> cellules_e = new ArrayList<>();
				cellules_a.add(a);cellules_b.add(b);cellules_c.add(c);
				cellules_a.add(a);cellules_b.add(b);cellules_c.add(c);
				cellules_a.add(a);cellules_b.add(b);cellules_c.add(c);
				
				Colonne aa =new Colonne();
				Colonne cc =new Colonne("Pays", Type.getType("SHORT"), cellules_c);
				Colonne dd =new Colonne("Passager", Type.getType("FLOAT"), cellules_b);
				Colonne ee =new Colonne("Lovers", Type.getType("SHORT"), cellules_a);
				ee=ee.addCellule(c,1);
				ee.afficheColonne();
//				ee.addDebutCellule(c);
//				dd.addDebutCellule(a);
//				cc.afficheColonne();
//				dd.afficheColonne();
		//		aa.afficheColonne();
				
//				System.out.println(cc.compareColonne(dd));
//				System.out.println(aa.compareColonne(aa));	
//				System.out.println(cc.compareColonne(dd));
//				System.out.println(aa.getSizeColonne());
//				System.out.println(cc.getSizeColonne());
//				System.out.println(dd.getSizeColonne());
//				System.out.println(ee.getSizeColonne());
				
				
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
