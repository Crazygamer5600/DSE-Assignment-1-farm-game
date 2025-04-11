package students.items;

public abstract class Food extends Item {
	public Food(int age, int maturationAge, int deathAge, int monetaryValue, String symbol) {
		super(age, maturationAge, deathAge, monetaryValue, symbol);
	}
	public int getAge() {
		return age;
	}
	public int getMaturationAge() {
		return age;
	}
	
	public int getDeathAge() {
		return deathAge;
	}
	
	public int getMonetaryValue() {
		return monetaryValue;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
