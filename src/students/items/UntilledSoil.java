package students.items;

public class UntilledSoil extends Item{
	static int subclassCount;
	public UntilledSoil() {
		super(0, Integer.MAX_VALUE, Integer.MAX_VALUE, -1, "/");
		subclassCount++;
	}
	
	public static int getGenerationCount(){
		subclassCount++;
		return subclassCount;
	}

	
	
	
	
}
