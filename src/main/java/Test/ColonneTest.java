package Test;

import static org.junit.Assert.*;
import com.sun.org.apache.bcel.internal.generic.Type;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Colonne;
import main.Unit;

public class ColonneTest {
	
	private Colonne colonne = new Colonne();

	public ColonneTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<String>("janvier"));
		colonne01.add(new Unit<String>("fevrier"));
		colonne01.add(new Unit<String>("mars"));
		colonne01.add(new Unit<String>("avril"));
		new Colonne("Mois", Type.getType("String"), colonne01);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
