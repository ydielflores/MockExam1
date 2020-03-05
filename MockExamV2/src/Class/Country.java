package Class;

public class Country {

	String countryName;
	int airUnits; 
	int navalUnits; 
	int infantryUnits; 
	int armorUnits; 
	String warAlly; 
	int supplies;
	String enemy;

	public Country(String countryName, int airUnits, int navalUnits, int infantryUnits, int armorUnits, String warAlly, int supplies, String enemy) {
		//TODO Finish the constructor and auto generate getters and setters.
		

	}
	
	/*In case of not having an ally you must have your forces counted!
	 * 
	 */
	public int totalForces() {
		//TODO Round up your forces.
		return 0;
	}
	
	/*
	 * In case of battle, you should be able to update your units and supplies quickly!
	 */
	public void forceReport(int infantry, int armor, int naval, int air, int supplies) {
		//TODO update all the values of your forces!
		
	}
	/*What's the point of having an army if you don't have the supplies to support it?
	 * TODO 
	 * AirUnits = 1 supply
	 * InfantryUnit = 2 supply
	 * ArmorUnit = 3 supply
	 * NavalUnit = 4 supply
	 * 
	 */
	public boolean supportUnits() {
		//TODO You can support your units if your supplies are at least two times the supplies needed!
		return false;
	}
	
	/*Determine if the param is an ally */
	public boolean isAlly( Country country) {
		//TODO 
		return false;
	}
	
	/*In case of a conflict erupting, your ally will sum their forces and supplies to yours! 
	 * 
	 */
	public void reinforcements(Country country) {
		//TODO make sure to have every single troop and supply counted!
		
	}
	/*Be wary! If your ally senses that you are weaker than him, he might abandon you in times of need!
	 * 
	 */
	public boolean allyOnCheck(Country country) {
		//TODO Your ally won't betray you if you are at least in strength.
		return false;
	}
	
	/*You have contracted a private Home Land security company.
	 * They will provide with infantry and supplies, great!
	 */
	public void contractor(int infantry, int supplies) {
		//TODO make sure to add up your contractors forces and supplies.
		
	}
	
	/*OH NO! Country differences escalated! An army is marching on your lands and you can see flags in the distance. What now!?
	 * 
	 */
	public String warDeclaration(Country country) {
		//TODO Return a string saying if it is an Enemy, Ally or Neutral. Remember, an ally of your enemy is also an enemy!
		return "";
	}
	/*It is time to confront our enemy!
	 * If your forces are greater than the one of the enemy, you destroy all their forces and you claim their supplies as yours.
	 * If your forces are equal than the one of the enemy, you both lose half your forces of every unit, half your supplies and retreat.
	 * If your forces are smaller than the one of the enemy, you lose every unit and every supply!
	 */
	public int remainingForces(Country country) {
		//TODO Calculate the remaining forces after the battle! Make sure to update your forces and supplies as well as the ones for your enemy.
		return 0;
	}

}
