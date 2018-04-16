package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.Type;

import main.Colonne;
import main.DataFrame;
import main.Unit;

public class TestDataFrame {

	private DataFrame dataframe;
	
	public TestDataFrame() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<String>("janvier"));
		colonne01.add(new Unit<String>("fevrier"));
		colonne01.add(new Unit<String>("mars"));
		colonne01.add(new Unit<String>("avril"));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("Mois", Type.getType("String"), colonne01));
		dataframe = new DataFrame("dépenses domestiques", colonnes);
	}

	@After
	public void tearDown() throws Exception {
		dataframe=null;
	}

	@Test
	public void testgetTitre() {
		dataframe.setTtitre("dépenses domestiques");
		assertEquals("le Titre est incorect","dépenses domestiques",dataframe.getTitre());
	}
	
	@Test
	public void testsetTtitre() {
		dataframe.setTtitre("dépenses domestiques");
		assertEquals("le Titre est incorect","dépenses domestiques",dataframe.getTitre());
	}
	
	@Test
	public void testgetColonnes() {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<String>("janvier"));
		colonne01.add(new Unit<String>("fevrier"));
		colonne01.add(new Unit<String>("mars"));
		colonne01.add(new Unit<String>("avril"));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("Mois", Type.getType("String"), colonne01));
		dataframe = new DataFrame("dépenses domestiques", colonnes);
		assertEquals("le Titre est incorect",colonnes,dataframe.getColonnes());
	}
	
	@Test
	public void testsetColonnes() {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<String>("janvier"));
		colonne01.add(new Unit<String>("fevrier"));
		colonne01.add(new Unit<String>("mars"));
		colonne01.add(new Unit<String>("avril"));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("Mois", Type.getType("String"), colonne01));
		dataframe.setColonnes(colonnes);
		assertEquals("le Titre est incorect",colonnes,dataframe.getColonnes());
	}
	
	@Test
	public void testgetLigneNumber() {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<String>("janvier"));
		colonne01.add(new Unit<String>("fevrier"));
		colonne01.add(new Unit<String>("mars"));
		colonne01.add(new Unit<String>("avril"));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("Mois", Type.getType("String"), colonne01));
		dataframe = new DataFrame("dépenses domestiques", colonnes);
		assertEquals("le size est incorect",4,dataframe.getLigneNumber());
	}
	
	@Test
	public void testgetSize() {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<String>("janvier"));
		colonne01.add(new Unit<String>("fevrier"));
		colonne01.add(new Unit<String>("mars"));
		colonne01.add(new Unit<String>("avril"));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("Mois", Type.getType("String"), colonne01));
		dataframe = new DataFrame("dépenses domestiques", colonnes);
		assertEquals("le size est incorect",4,dataframe.getSize());
	}
	
	@Test
	public void testcalculateAverge() throws Exception {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<Float>(1.00f));
		colonne01.add(new Unit<Float>(2.00f));
		colonne01.add(new Unit<Float>(3.00f));
		colonne01.add(new Unit<Float>(6.00f));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("test", Type.getType("Float"), colonne01));
		dataframe = new DataFrame("test", colonnes);
		assertEquals(3.00f, dataframe.calculateAverge("test"), 0);
	}
	
	@Test
	public void testcalculateMinimum() throws Exception{
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<Float>(1.00f));
		colonne01.add(new Unit<Float>(2.00f));
		colonne01.add(new Unit<Float>(3.00f));
		colonne01.add(new Unit<Float>(6.00f));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("test", Type.getType("Float"), colonne01));
		dataframe = new DataFrame("test", colonnes);
		assertEquals(1.00f, dataframe.calculateMinimum("test"), 0);
	}
	
	@Test
	public void testcalculateMaximum() throws Exception {
		ArrayList <Unit> colonne01 = new ArrayList<Unit>();
		colonne01.add(new Unit<Float>(1.00f));
		colonne01.add(new Unit<Float>(2.00f));
		colonne01.add(new Unit<Float>(3.00f));
		colonne01.add(new Unit<Float>(6.00f));
		ArrayList<Colonne> colonnes = new ArrayList<>();
		colonnes.add(new Colonne("test", Type.getType("Float"), colonne01));
		dataframe = new DataFrame("test", colonnes);
		assertEquals(6.00f, dataframe.calculateMaximum("test"), 0);
	}
	
	
//getSizeColonnes;selectColonnes

}
