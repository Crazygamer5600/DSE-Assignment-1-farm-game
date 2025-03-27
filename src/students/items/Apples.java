package students.items;

public class Apples extends Food {
	
	static int SubclassCount;
	String Symbol="a";
	
	public Apples(int age, int maturationAge, int deathAge, int monetaryValue) {
		super(age, maturationAge, deathAge, monetaryValue);}
	
	public int getGenerationCount(){
		SubclassCount++;
		return SubclassCount;}	
		
	public String MaturationStr(){
		if (age>maturationAge){
			String x = Symbol.toUpperCase();
			Symbol=x;}
		return Symbol;}
}

