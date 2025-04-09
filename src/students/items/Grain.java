package students.items;

public class Grain extends Food{
	static int subclassCount;
	static int seedPrice = 1;
	public Grain() {
		super(0, 2, 6, 2, "g");
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
	
	public static int getSeedPrice() {
		return seedPrice;
	}
	
	public void reduceGenerationCount() {
		subclassCount--;	
	}
	
		
	}


