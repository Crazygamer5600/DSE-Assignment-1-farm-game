package students.items;

public class Weed extends Item{
	public Weed(int age, int maturationAge, int deathAge, int monetaryValue, String symbol) {
		super(age, maturationAge, deathAge, monetaryValue, symbol);
		this.age=0;
		this.maturationAge=Integer.MAX_VALUE;
		this.deathAge=Integer.MAX_VALUE;
		this.monetaryValue=-1;
		this.Symbol="#";}
		
	
}


