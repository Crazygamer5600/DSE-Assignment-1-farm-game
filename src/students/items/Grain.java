package students.items;

public class Grain extends Food{
	
	static int subclassCount;
	String Symbol="g";
	
	public Grain(int age, int maturationAge, int deathAge, int monetaryValue) {
		super(age, maturationAge, deathAge, monetaryValue);}	
	
	public int getGenerationCount(){
		subclassCount++;
		return subclassCount;}
	
	public String MaturationStr(){
		if (age>maturationAge){
			String x = Symbol.toUpperCase();
			Symbol=x;}
		return Symbol;}
}

