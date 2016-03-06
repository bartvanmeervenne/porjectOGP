package hillbillies.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	private Unit newUnit1;
	@Before
	public void setUp() throws Exception {
		int[] pos = {3,3,3};
		newUnit1 = new Unit(pos, "Larry", 100,100,100,100 );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPosition() {
		int[] position = new int[3];
		position[0] = 1;
		position[1] = 1;
		position[2] = 1;
		
		Unit newUnit = new Unit(position, "Larry", 50, 50, 50, 50);
		assertEquals(position[0], newUnit.getPosition()[0], 0);
		assertEquals(position[1], newUnit.getPosition()[1], 0);
		assertEquals(position[2], newUnit.getPosition()[2], 0);
		
		
	}
	@Test
	public void testSetPosition() {
		int[] position = {2,1,0};
		
		double[] newpos = {3,4,1};
		Unit newUnit = new Unit(position, "Larry", 50, 50, 50, 50);
		newUnit.setPosition(newpos);
		assertEquals(newpos[0], newUnit.getPosition()[0], 0);
		assertEquals(newpos[1], newUnit.getPosition()[1], 0);
		assertEquals(newpos[2], newUnit.getPosition()[2], 0);
		
			
	}
	
	@Test
	public final void testValidPos(){
		int[] position = new int[3];
		position[0] = 1;
		position[1] = 3;
		position[2] = 4;
		
		Unit newUnit = new Unit(position, "Larry", 50, 50, 50, 50);
		double[] pos = new double[3];
		pos[0] = 20;
		pos[1] = 25;
		pos[2] = 34;
		assertTrue(newUnit.isValidPosition(pos));
		
	}
	
	@Test
	public final void testName(){
		newUnit1.setName("Bobby");
		assertEquals("Bobby", newUnit1.getName());
		
		
	}
	
	@Test
	public final void testValidNameTrue(){
		assertTrue(newUnit1.isValidName(newUnit1.getName()));
		
		
	}
	@Test
	public final void testValidNameFalseTooShort(){
		assertFalse(newUnit1.isValidName("b"));
	}
	@Test
	public final void testValidNameFalseNotAllowedSymbol(){
		assertFalse(newUnit1.isValidName("Barry0!9"));
	}
	
	@Test
	public final void testWeightEqual(){
		newUnit1.setWeight(150);
		assertEquals(150, newUnit1.getWeight());
		
	}

	@Test 
	public final void testWeightNotEqualLessMinWeight(){
		newUnit1.setWeight(25);
		assertNotEquals(25, newUnit1.getWeight());
		
	}
	
	@Test 
	public final void testWeightNotEqualMoreMaxWeight(){
		newUnit1.setWeight(202);
		assertNotEquals(202,newUnit1.getWeight());
	}
	@Test
	public final void testStrengthEqual(){
		newUnit1.setStrength(150);
		assertEquals(150, newUnit1.getStrength());
		
	}

	@Test 
	public final void testStrenghtNotEqualLessMinStrength(){
		newUnit1.setStrength(0);
		assertNotEquals(0, newUnit1.getStrength());
		
	}
	
	@Test 
	public final void testStrengthNotEqualMoreMaxtrength(){
		newUnit1.setStrength(202);
		assertNotEquals(202,newUnit1.getStrength());
	
	}
	@Test
	public final void testAgilityEqual(){
		newUnit1.setAgility(150);
		assertEquals(150, newUnit1.getAgility());
		
	}

	@Test 
	public final void testAgilityNotEqualLessMinAgility(){
		newUnit1.setAgility(0);
		assertNotEquals(0, newUnit1.getAgility());
		
	}
	
	@Test 
	public final void testAgilityNotEqualMoreMaxAgility(){
		newUnit1.setAgility(202);
		assertNotEquals(202,newUnit1.getAgility());
	
	}
	
	@Test
	public final void testToughnessEqual(){
		newUnit1.setToughness(150);
		assertEquals(150, newUnit1.getToughness());
		
	}

	@Test 
	public final void testToughnessNotEqualLessMinToughness(){
		newUnit1.setToughness(0);
		assertNotEquals(0, newUnit1.getToughness());
		
	}
	
	@Test 
	public final void testToughnessNotEqualMoreMaxToughness(){
		newUnit1.setToughness(202);
		assertNotEquals(202,newUnit1.getToughness());
	
	}
	
	@Test
	public final void testMaxHit(){
		assertEquals((int)(200*(newUnit1.getWeight()/100)*(newUnit1.getToughness()/100)+1), newUnit1.getMaxHitpoints());
	}
	
	@Test 
	public final void testValidMaxHitNotEqual(){
		assertNotEquals(0, newUnit1.isValidMaxHit(5));
	}
	
	@Test
	public final void testGetHit(){
		newUnit1.setHitpoints(42);
		assertEquals(42, newUnit1.getHitpoints(),0);
		
	}
	@Test
	public final void testValidHitTrue(){
		newUnit1.setHitpoints(40);
		assertTrue(newUnit1.isValidHitpoints(42, newUnit1.getMaxHitpoints()));
		
	}
	
	@Test
	public final void testValidHitFalseNegative(){
		assertFalse(newUnit1.isValidHitpoints(-3, newUnit1.getMaxHitpoints()));
	}
	
	@Test
	public final void testValidHitFalseTooBig(){
		assertFalse(newUnit1.isValidHitpoints(500, newUnit1.getMaxHitpoints()));
	}
	
	@Test
	public final void testMaxStamina(){
		assertEquals((int)(200*(newUnit1.getWeight()/100)*(newUnit1.getToughness()/100)+1), newUnit1.getMaxHitpoints());
	}
	
	@Test 
	public final void testValidMaxStaminaNotEqual(){
		assertNotEquals(0, newUnit1.isValidMaxHit(5));
	}
	
	@Test
	public final void testGetStamina(){
		newUnit1.setHitpoints(42);
		assertEquals(42, newUnit1.getHitpoints(),0);
		
	}
	@Test
	public final void testValidStaminaTrue(){
		newUnit1.setHitpoints(40);
		assertTrue(newUnit1.isValidHitpoints(42, newUnit1.getMaxHitpoints()));
		
	}
	
	@Test
	public final void testValidStaminaFalseNegative(){
		assertFalse(newUnit1.isValidHitpoints(-3, newUnit1.getMaxHitpoints()));
	}
	
	@Test
	public final void testValidStaminaFalseTooBig(){
		assertFalse(newUnit1.isValidHitpoints(500, newUnit1.getMaxHitpoints()));
	}
	
	@Test
	public final void testSetAngleEquals(){
		newUnit1.setAngle((float)(-1/2 * Math.PI * 1/2.0));
		assertEquals((float)(-1/2 * Math.PI * 1/2.0), newUnit1.getAngle(), 0);
	}
	
	@Test 
	public final void testSetAngleNotEqualAngleTooLarge(){
		newUnit1.setAngle((float)(3 * Math.PI  ));
		assertNotEquals((float)(3 * Math.PI), newUnit1.getAngle(), 0);
	}
	
	
	@Test
	public final void testGetAngle(){
		newUnit1.setAngle((float)(-0.5* Math.PI));
		assertEquals((float)(-0.5 * Math.PI), newUnit1.getAngle(), 0);
		
		
		
	}
	
	
	
}
