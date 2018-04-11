import java.util.ArrayList;
import com.sun.org.apache.bcel.internal.generic.Type;
public class Run {

	public static void main(String[] args) {
    		ArrayList<Cellule> colonne01 = new ArrayList<>();
    		ArrayList<Cellule> colonne02 = new ArrayList<>();
    		ArrayList<Cellule> colonne03 = new ArrayList<>();
     		
    		
    		Colonne cc =new Colonne("Pays", Type.getType("SHORT"), colonne01);
    		cc.afficheColonne();
    		System.out.println(cc.getSizeColonne());
    		
	}
}
