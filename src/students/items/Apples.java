package students.items;

public class Apples extends Food {
	
	static int subclassCount;
	public Apples() {
		super(0, 3, 5, 3, "a", 2);
		subclassCount++;
	}

	public static int getGenerationCount(){
		return subclassCount;
	}	
		
	public String MaturationStr(){
		if (age>maturationAge){
			String x = symbol.toUpperCase();
			symbol=x;}
		return symbol;}
}

