package students.items;

public class Apples extends Food {
	static int SubclassCount;
	public Apples(int age, int maturationAge, int deathAge, int monetaryValue, String symbol, int seedPrice) {
		super(age, maturationAge, deathAge, monetaryValue, symbol, seedPrice);
		this.age=0;
		this.maturationAge=3;
		this.deathAge=5;
		this.monetaryValue=3;
		this.Symbol="a";
		this.seedPrice=2;}

	
	

	public int getGenerationCount(){
		SubclassCount++;
		return SubclassCount;}	
		
	public String MaturationStr(){
		if (age>maturationAge){
			String x = Symbol.toUpperCase();
			Symbol=x;}
		return Symbol;}
}

