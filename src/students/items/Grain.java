package students.items;

public class Grain extends Food{
	static int subclassCount;
	public Grain(int age, int maturationAge, int deathAge, int monetaryValue, String symbol, int seedPrice) {
		super(age, maturationAge, deathAge, monetaryValue, symbol, seedPrice);
		this.age=0;
		this.maturationAge=2;
		this.deathAge=6;
		this.monetaryValue=2;
		this.Symbol="g";
		this.seedPrice=1;}

	
	
	
	public int getGenerationCount(){
		subclassCount++;
		return subclassCount;}
	
	public String MaturationStr(){
		if (age>maturationAge){
			String x = Symbol.toUpperCase();
			Symbol=x;}
		return Symbol;}
}

