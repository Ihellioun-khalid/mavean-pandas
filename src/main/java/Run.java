import java.util.ArrayList;
import com.sun.org.apache.bcel.internal.generic.Type;
public class Run {

	public static void main(String[] args) throws Exception {
		
		try {
			
			//Unit test
//				Unit a = new Unit<>("a");
//				Unit b = new Unit<>(22.2);
//				Unit c = new Unit<>("cccc");
////				a.afficheUnit();
////				System.out.println(a.UnitSize());
////				System.out.println(b.UnitSize());
//				
//			//Colonne test
//				
//				ArrayList <Unit> Units_a = new ArrayList<>();
//				ArrayList <Unit> Units_b = new ArrayList<>();
//				ArrayList <Unit> Units_c = new ArrayList<>();
//				ArrayList <Unit> Units_e = new ArrayList<>();
//				Units_a.add(a);Units_b.add(b);Units_c.add(c);
//				Units_a.add(a);Units_b.add(b);Units_c.add(c);
//				Units_a.add(a);Units_b.add(b);Units_c.add(c);
//				
//				Colonne aa =new Colonne();
//				Colonne cc =new Colonne("Pays", Type.getType("SHORT"), Units_c);
//				Colonne dd =new Colonne("Passager", Type.getType("FLOAT"), Units_b);
//				Colonne ee =new Colonne("Lovers", Type.getType("SHORT"), Units_a);
////				ee=ee.addUnit(c,1);
////				ee.afficheColonne();
////				ee.addDebutUnit(c);
////				dd.addDebutUnit(a);
////				cc.afficheColonne();
////				dd.afficheColonne();
//		//		aa.afficheColonne();
//				//ee.afficheColonne();
//				
//				ee.addUnit(c, 2);
//				ee.afficheColonne();
//				ee.supprimeUnit(2);
////				ee.supprimeUnit(55);
////				ee=ee.supprimeDuplicateUnit();
//				//ee.afficheColonne();
//				
////				System.out.println(cc.compareColonne(dd));
////				System.out.println(aa.compareColonne(aa));	
////				System.out.println(cc.compareColonne(dd));
////				System.out.println(aa.getSizeColonne());
////				System.out.println(cc.getSizeColonne());
////				System.out.println(dd.getSizeColonne());
////				System.out.println(ee.getSizeColonne());
//				
//				
//				//addUnit()
//				//suppUnit()
//				//modifieUnit()
				
				
				
				
				
				ArrayList <Unit> colonne01 = new ArrayList<>();
				ArrayList <Unit> colonne02 = new ArrayList<>();
				ArrayList <Unit> colonne03 = new ArrayList<>();
		
		        ArrayList<Colonne> colonnes = new ArrayList<>();
		        
		        colonnes.add(new Colonne("Mois", Type.getType("String"), colonne01));
		        colonnes.add(new Colonne("Categories", Type.getType("String"), colonne02));
		        colonnes.add(new Colonne("Montantt", Type.getType("FLOAT"), colonne03));
		        
		        DataFrame dataFrame = new DataFrame("Villes de France", colonnes);
		        
		        // Données
		        colonne01.add(new Unit<String>("janvier"));
		        colonne01.add(new Unit<String>("janvier"));
		        colonne01.add(new Unit<String>("janvier"));
		        colonne01.add(new Unit<String>("janvier"));
		        colonne01.add(new Unit<String>("fevrier"));
		        colonne01.add(new Unit<String>("fevrier"));
		        colonne01.add(new Unit<String>("fevrier"));
		        colonne01.add(new Unit<String>("fevrier"));
		        colonne01.add(new Unit<String>("mars"));
		        colonne01.add(new Unit<String>("mars"));
		        colonne01.add(new Unit<String>("mars"));
		        colonne01.add(new Unit<String>("mars"));      
		      
		        colonne02.add(new Unit<String>("Transport"));
		        colonne02.add(new Unit<String>("Course"));
		        colonne02.add(new Unit<String>("Foyer"));
		        colonne02.add(new Unit<String>("Loisirs"));
		        colonne02.add(new Unit<String>("Transport"));
		        colonne02.add(new Unit<String>("Course"));
		        colonne02.add(new Unit<String>("Foyer"));
		        colonne02.add(new Unit<String>("Loisirs"));
		        colonne02.add(new Unit<String>("Transport"));
		        colonne02.add(new Unit<String>("Course"));
		        colonne02.add(new Unit<String>("Foyer"));
		        colonne02.add(new Unit<String>("Loisirs"));

		        colonne03.add(new Unit<Float>(74.00f));
		        colonne03.add(new Unit<Float>(235.00f));
		        colonne03.add(new Unit<Float>(175.00f));
		        colonne03.add(new Unit<Float>(100.00f));
		        colonne03.add(new Unit<Float>(115.00f));
		        colonne03.add(new Unit<Float>(140.00f));
		        colonne03.add(new Unit<Float>(225.00f));
		        colonne03.add(new Unit<Float>(90.00f));    
		        colonne03.add(new Unit<Float>(200.00f));
		        colonne03.add(new Unit<Float>(120.00f));
		        colonne03.add(new Unit<Float>(90.00f));
		        colonne03.add(new Unit<Float>(110.00f));
		        
		        dataFrame.afficherDataframe();

		        System.out.println("Moyenne des populations : " + dataFrame.calculateAverge("Montantt"));
		        System.out.println("Population minimale : " + dataFrame.calculateMinimum("Montantt"));
		        System.out.println("Population maximale : " + dataFrame.calculateMaximum("Montantt"));
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
}
