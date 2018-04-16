package main;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.Type;

public class Run {

	public static void main(String[] args) throws Exception {
		
		try {	
				ArrayList <Unit> colonne01 = new ArrayList<>();
				ArrayList <Unit> colonne02 = new ArrayList<>();
				ArrayList <Unit> colonne03 = new ArrayList<>();
		
		        ArrayList<Colonne> colonnes = new ArrayList<>();
		        
		        colonnes.add(new Colonne("Mois", Type.getType("String"), colonne01));
		        colonnes.add(new Colonne("Categories", Type.getType("String"), colonne02));
		        colonnes.add(new Colonne("Montant", Type.getType("FLOAT"), colonne03));
		        
		        DataFrame dataFrame = new DataFrame("dépenses domestiques", colonnes);
		        
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

		        System.out.println("Moyenne des  Montant: " + dataFrame.calculateAverge("Montant"));
		        System.out.println("Population minimale : " + dataFrame.calculateMinimum("Montant"));
		        System.out.println("Population maximale : " + dataFrame.calculateMaximum("Montant"));
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
}
