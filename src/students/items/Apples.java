package students.items;

public class Apples extends Food {
	static int subclassCount;
	static int seedPrice = 2;
	
	public Apples() {
		super(0, 3, 5, 3, "a");
		subclassCount++;
	}

	public static int getGenerationCount() {
		return subclassCount;
	}
	
	public static int getSeedPrice() {
		return seedPrice;
	}
	

	@Override
	public String toString() {
		if(age > maturationAge) {
			this.symbol = "A";
		}
		return symbol;
	}
	
}

