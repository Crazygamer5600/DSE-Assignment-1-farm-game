package students.items;

public class Soil extends Item {
	static int subclassCount;
	public Soil() {
		super(0, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, ".");
		subclassCount++;
	}

	public static int getGenerationCount(){
		return subclassCount;
	}
	
	public void reduceGenerationCount(){
		subclassCount--;
	}
	
	
}
