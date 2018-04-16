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
		colonne = null;
	}

	@Test
	public void testUnit() {
		assertNotNull("L'instance est vide",colonne);
	}
	
	@Test
	public void testgetColonneTitre() {
		colonne.setColonneTitre("Mois");
		assertEquals("le Titre est incorect","Mois",colonne.getColonneTitre());
	}
	
	@Test
	public void testsetColonneTitre() {
		colonne.setColonneTitre("Mois");
		assertEquals("le Titre est incorect","Mois",colonne.getColonneTitre());
	}
	
	@Test
	public void testgetColonneType() {
		ArrayList <Unit> unit = new ArrayList<Unit>();
		unit.add(new Unit<String>("janvier"));
		colonne =new Colonne("Mois", Type.getType("String"), unit);
		assertEquals("le type est incorect",Type.getType("String"),colonne.getColonneType());
	}
	
	@Test
	public void testsetColonneType() {
		colonne.setColonneType(Type.getType("String"));
		assertEquals("le Titre est incorect",Type.getType("String"),colonne.getColonneType());
	}
	
	@Test
	public void testgetUnits() {
		ArrayList <Unit> unit = new ArrayList<Unit>();
		unit.add(new Unit<String>("janvier"));
		unit.add(new Unit<String>("fevrier"));
		unit.add(new Unit<String>("mars"));
		colonne =new Colonne("Mois", Type.getType("String"), unit);
		assertEquals("le type est incorect",unit,colonne.getUnits());
	}
	
	@Test
	public void testsetUnits() {
		ArrayList <Unit> unit = new ArrayList<Unit>();
		unit.add(new Unit<String>("janvier"));
		unit.add(new Unit<String>("fevrier"));
		unit.add(new Unit<String>("mars"));
		colonne.setUnits(unit);
		assertEquals("le Titre est incorect",unit,colonne.getUnits());
	}
	
	@Test
	public void testgetSizeColonne() {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<String>("janvier"));
		colonne =new Colonne("Mois", Type.getType("String"), colonne01);
		assertEquals("le size est incorect",1,colonne.getSizeColonne());
	}

	@Test
	public void testcompareColonne() throws Exception {
		ArrayList <Unit> units = new ArrayList<Unit>();
		units.add(new Unit<String>("janvier"));
		colonne.setColonneTitre("Mois");
		colonne.setColonneType(Type.getType("String"));
		colonne.setUnits(units);
		Colonne a=new Colonne("Mois", Type.getType("String"), units);
		assertTrue("Book check in failed",this.colonne.compareColonne(a));
	}
	
	@Test
	public void testaddDebutUnit() throws Exception {
		Unit test = new Unit<String>("fevrier");
		ArrayList <Unit> units1 = new ArrayList<Unit>();
		units1.add(new Unit<String>("janvier"));
		ArrayList <Unit> units2 = new ArrayList<Unit>();
		units2.add(new Unit<String>("fevrier"));
		units2.add(new Unit<String>("janvier"));
		colonne.setColonneTitre("Mois");
		colonne.setColonneType(Type.getType("String"));
		colonne.setUnits(units1);
		Colonne a = new Colonne("Mois", Type.getType("String"), units2);
		this.colonne=this.colonne.addDebutUnit(test);
		assertTrue("Book check in failed",this.colonne.compareColonne(a));
	}
	
	@Test
	public void testaddFinUnit() throws Exception {
		Unit test = new Unit<String>("fevrier");
		ArrayList <Unit> units1 = new ArrayList<Unit>();
		units1.add(new Unit<String>("janvier"));
		ArrayList <Unit> units2 = new ArrayList<Unit>();
		units2.add(new Unit<String>("janvier"));
		units2.add(new Unit<String>("fevrier"));
		colonne.setColonneTitre("Mois");
		colonne.setColonneType(Type.getType("String"));
		colonne.setUnits(units2);
		Colonne a = new Colonne("Mois", Type.getType("String"), units1);
		a=a.addFinUnit(test);
		assertTrue("Book check in failed",this.colonne.compareColonne(a));
	}
	
	@Test
	public void testaddUnit() throws Exception {
		Unit test = new Unit<String>("fevrier");
		ArrayList <Unit> units1 = new ArrayList<Unit>();
		units1.add(new Unit<String>("janvier"));
		ArrayList <Unit> units2 = new ArrayList<Unit>();
		units2.add(new Unit<String>("janvier"));
		units2.add(new Unit<String>("fevrier"));
		colonne.setColonneTitre("Mois");
		colonne.setColonneType(Type.getType("String"));
		colonne.setUnits(units2);
		Colonne a = new Colonne("Mois", Type.getType("String"), units1);
		a=a.addUnit(test,1);
		assertTrue("Book check in failed",this.colonne.compareColonne(a));
	}
	
	@Test
	public void testsupprimeDuplicateUnit() {
		
	}
	
	@Test
	public void testsupprimeUnit() {
		
	}
}
