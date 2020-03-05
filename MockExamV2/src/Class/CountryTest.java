package Class;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountryTest {

	private Country UnitedStates;
	private Country Iran;
	private Country Russia;
	private Country Britain;
	
	@Before
	public void setUp() {
		//1,4,2,3 
		
		UnitedStates = new Country("United States", 100, 50, 500, 80, "Britain", 5220, "Russia");
		Iran = new Country("Iran", 10, 3, 400, 20, "Russia", 900, "Britain");
		Russia = new Country("Russia", 90, 45, 400, 78, "Iran", 5216, "United States");
		Britain = new Country("Britain", 75, 20, 400, 50, "United States", 4420, "Iran");
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
		
	}
	
	@Test
	public void testSupportUnits() {
		
	}
	@Test
	public void testIsAlly() {
		
	}
	@Test
	public void testReinforcements() {
		
	}
	@Test
	public void	testAllyOnCheck() {
		
	}
	@Test
	public void	testContractor() {
		
	}
	@Test
	public void	testWarDeclaration() {
		
	}
	@Test
	public void	testRemainingForces() {
		
	}
}
