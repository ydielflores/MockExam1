package Class;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountryTest {

	private Country UnitedStates;
	private Country Iran;
	private Country Russia;
	private Country Britain;
	private Country Mexico;
	
	
	
	/*DO NOT BE AFRAID OF ERRORS HERE. YOU STILL HAVE TO DO THE GETTERS AND SETTERS.
	 * DO NOT BE AFRAID OF ERRORS HERE. YOU STILL HAVE TO DO THE GETTERS AND SETTERS.
	 * DO NOT BE AFRAID OF ERRORS HERE. YOU STILL HAVE TO DO THE GETTERS AND SETTERS.
	 * DO NOT BE AFRAID OF ERRORS HERE. YOU STILL HAVE TO DO THE GETTERS AND SETTERS.
	 * DO NOT BE AFRAID OF ERRORS HERE. YOU STILL HAVE TO DO THE GETTERS AND SETTERS.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	@Before
	public void setUp() {
		//1,4,2,3 
		
		UnitedStates = new Country("United States", 100, 50, 500, 80, "Britain", 6160, "Russia");
		Iran = new Country("Iran", 10, 3, 400, 20, "Russia", 900, "Britain");
		Russia = new Country("Russia", 90, 45, 400, 78, "Iran", 5216, "United States");
		Britain = new Country("Britain", 75, 20, 400, 50, "United States", 4420, "Iran");
		Mexico = new Country("Mexico", 100, 50, 500, 80, "Chile", 600, "Colombia");
		
	}
	
	
	public void loadDefault() {
		UnitedStates.battleReport(500, 80, 50, 100, 6160);
		Iran.battleReport(400, 20, 3, 10, 900);
		Russia.battleReport(400, 78, 45, 90, 5216);
		Britain.battleReport(400, 50, 20, 75, 4420);
	}
	
	@Test
	public void testTotalForces() {
		assertEquals("Total force of the United States is 730", 730, UnitedStates.totalForces());
		assertEquals("Total force of Iran is 433", 433, Iran.totalForces());
		assertEquals("Total force of Russia is 613", 613, Russia.totalForces());
		assertEquals("Total force of Britain is 545", 545, Britain.totalForces());

	}
	
	@Test
	public void testForceReport() {
		UnitedStates.battleReport(100, 100, 100, 100, 100);
		Iran.battleReport(50, 50, 50, 50, 50);
		Russia.battleReport(200, 200, 200, 200, 100);
		Britain.battleReport(150, 150, 150, 150, 150);
		
		assertEquals("After rounding up the forcess, the United States was left with a total of: 400", 400, UnitedStates.totalForces());
		assertEquals("After rounding up the forcess, Iran was left with a total of: 200", 200, Iran.totalForces());
		assertEquals("After rounding up the forcess, Russia was left with a total of: 800", 800, Russia.totalForces());
		assertEquals("After rounding up the forcess, Britain was left with a total of: 600", 600, Britain.totalForces());
		
		loadDefault();
		
	}
	
	@Test
	public void testSuppliesNeeded() {
		assertEquals("The United States needs: 1540",1540,UnitedStates.suppliesConsumed());
		assertEquals("Iran needs: 882", 882, Iran.suppliesConsumed());
		assertEquals("Russia needs: 1304", 1304, Russia.suppliesConsumed());
		assertEquals("Britain needs: 1105", 1105, Britain.suppliesConsumed());
	}

	@Test
	public void testSupportUnits() {
		assertTrue("The United States counts with enough supplies.", UnitedStates.getSupplies() >= 2*UnitedStates.suppliesConsumed());
		assertFalse("Iran will suffer from attrition.", Iran.getSupplies() >= 2*Iran.suppliesConsumed());
		assertTrue("Russia counts with enough supplies.", Russia.getSupplies() >= 2*Russia.suppliesConsumed());
		assertTrue("Britain counts with enough supplies.", Britain.getSupplies() >= 2*Britain.suppliesConsumed());
	}
	@Test
	public void testIsAlly() {
		assertTrue("United States and Britain are allies.", UnitedStates.isAlly(Britain));
		assertTrue("Russia and Iran are allies.", Russia.isAlly(Iran));
		assertFalse("United States and Iran are not allies.", UnitedStates.isAlly(Iran));
		assertFalse("Russia and Britain are allies.", Russia.isAlly(Britain));
	}
	@Test
	public void testReinforcements() {
		
		UnitedStates.reinforcements(Britain);
		assertEquals("United States and Britain join forces. Britain incorporates to the US.",1275, UnitedStates.totalForces());
		assertEquals("Combined supplies should be: ",10580, UnitedStates.getSupplies());
		
		Russia.reinforcements(Iran);
		assertEquals("Russia and Iran join forces. Iran incorporates to Russia.",1046, Russia.totalForces());
		assertEquals("Combined supples should be : ",6116,Russia.getSupplies());
		
		UnitedStates.reinforcements(Russia);
		assertEquals("US and Russia are not allies! They should not be merging.", 1275, UnitedStates.totalForces());
		
		loadDefault();
	}
	@Test
	public void	testAllyOnCheck() {
		assertTrue("US is stronger than his ally.", UnitedStates.allyOnCheck(Britain));
		assertFalse("Britain should pomp those numbers.",Britain.allyOnCheck(UnitedStates));
		assertTrue("Russia is stronger than his ally.", Russia.allyOnCheck(Iran));
		assertFalse("Iran might get back stabbed.", Iran.allyOnCheck(Russia));
		
		assertFalse("US and Russia are not allies!", UnitedStates.allyOnCheck(Russia));
		assertFalse("Iran and Britain are not allies!", Iran.allyOnCheck(Britain));
	}
	@Test
	public void	testContractor() {
		
		UnitedStates.contractor(100, 100);
		Iran.contractor(100, 100);
		Russia.contractor(100, 100);
		Britain.contractor(100, 100);
		
		assertEquals("The US had gain some forces!", 600, UnitedStates.getInfantryUnits());
		assertEquals("Iran had gain some forces!", 500, Iran.getInfantryUnits());
		assertEquals("Russia had gain some forces!", 500, Russia.getInfantryUnits());
		assertEquals("Britain had gain some forces!", 500, Britain.getInfantryUnits());
		
		assertEquals("The US had gain some supplies!", 6260, UnitedStates.getSupplies());
		assertEquals("Iran had gain some supplies!", 1000, Iran.getSupplies());
		assertEquals("Russia had gain some supplies!", 5316, Russia.getSupplies());
		assertEquals("Britain had gain some supplies!", 4520, Britain.getSupplies());
		
		loadDefault();
	}
	@Test
	public void	testWarDeclaration() {
		assertEquals("US and Russia are enemies.", "Enemy", UnitedStates.warDeclaration(Russia));
		assertEquals("US and Mexico are Neutral.", "Neutral", UnitedStates.warDeclaration(Mexico));
		assertEquals("US and Iran are enemies.", "Enemy", UnitedStates.warDeclaration(Iran));
		assertEquals("US and Britain are allies.", "Ally", UnitedStates.warDeclaration(Britain));
	}
	@Test
	public void	testRemainingForces() {
		UnitedStates.remainingForces(Russia);
		assertEquals("US is the victor over Russia. US supplies should be: ", 11376, UnitedStates.getSupplies());
		assertEquals("US is the victor over Russia. US forces should be: ", 730, UnitedStates.totalForces());
		assertEquals("US is the victor over Russia. Russian forces should be: ", 0, Russia.totalForces());
		
		Iran.remainingForces(Britain);
		
		assertEquals("Iran attacked a much stronger foe! Britain win. Iran supplies should be: ", 0, Iran.getSupplies());
		assertEquals("Iran attacked a much stronger foe! Britain win. Iran forces should be: ", 0, Iran.totalForces());
		assertEquals("Iran attacked a much stronger foe! Britain win. Britan forces should be: ", 545, Britain.totalForces());
		assertEquals("Iran attacked a much stronger foe! Britain win. Britain supplies should be: ", 5320, Britain.getSupplies());
		
		loadDefault();
		UnitedStates.remainingForces(Mexico);
		
		assertEquals("Oh no! The US accidentally attacked Mexico, but Mexico responded! US forces should be: ", 365, UnitedStates.totalForces());
		assertEquals("Oh no! The US accidentally attacked Mexico, but Mexico responded! US supplies should be: ", 3080, UnitedStates.getSupplies());
		assertEquals("Oh no! The US accidentally attacked Mexico, but Mexico responded! Mexico forces should be: ", 365, Mexico.totalForces());
		assertEquals("Oh no! The US accidentally attacked Mexico, but Mexico responded! Mexico supplies should be: ", 300, Mexico.getSupplies());
	}
}
