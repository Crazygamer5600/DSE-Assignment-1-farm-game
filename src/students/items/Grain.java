package students.items;

public class Grain extends Food{
	static int subclassCount;
	public Grain() {
		super(0, 2, 6, 2, "g", 1);
	}
	
	public int getGenerationCount(){
		subclassCount++;
		return subclassCount;}
	
	public String MaturationStr(){
		if (age>maturationAge){
			String x = symbol.toUpperCase();
			symbol=x;}
		return symbol;}
}

