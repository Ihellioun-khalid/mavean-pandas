package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.Unit;

public class UnitTest extends TestCase {
	
	private Unit unit;
	
	public UnitTest() {
		super();
	}
	
	public UnitTest(String data) {
		super(data);
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		unit = new Unit<String>("janvier");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		unit = null;
	}

	@Test
	public void testUnit() {
		assertNotNull("L'instance est vide",unit);
	}
	
	@Test
	public void testgetUnit() {
		assertEquals("le Mois est incorect","janvier",unit.getData());
	}
	
	@Test
	public void testsetUnit() {
		unit.setData("Mars");
		assertEquals("le Mois est incorect","Mars",unit.getData());
	}
	
	@Test
	public void testUnitSize() throws Exception {
		unit.setData("Mars");
		assertEquals("la taille est ",4, unit.UnitSize());
	}
	
	@Test
	public void testcompareUnit() throws Exception {
		Unit a = new Unit("Mars");
		unit.setData("Mars");
		assertTrue("Book check in failed",this.unit.compareUnit(a));	
	}
}
