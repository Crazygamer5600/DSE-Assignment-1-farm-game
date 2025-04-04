package students.items;

public abstract class Food extends Item {
	int seedPrice;
	public Food(int age, int maturationAge, int deathAge, int monetaryValue, String symbol, int seedPrice) {
		super(age, maturationAge, deathAge, monetaryValue, symbol);}
	
	public abstract void reduceGenerationCount();
}
