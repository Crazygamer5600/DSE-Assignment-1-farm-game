package students.items;

public class Apples extends Food {
	static int SubclassCount;
	public Apples() {
		super(0, 3, 5, 3, "a", 2);}

	public int getGenerationCount(){
		SubclassCount++;
		return SubclassCount;}	
		
	public String MaturationStr(){
		if (age>maturationAge){
			String x = symbol.toUpperCase();
			symbol=x;}
		return symbol;}
}

