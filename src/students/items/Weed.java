package students.items;

public class Weed extends Item{
	static int subclassCount;
	
	public Weed() {
		super(0, Integer.MAX_VALUE, Integer.MAX_VALUE, -1, "#");
		subclassCount++;
	}
	
	public static int getGenerationCount() {
		return subclassCount;
	}
	
	public void reduceGenerationCount() {
		subclassCount--;
	}

	
}