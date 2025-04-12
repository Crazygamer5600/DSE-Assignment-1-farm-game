package students.items;

public class Apples extends Food {
	static int subclassCount;
	static int seedPrice = 2;
	static int appleCount = 0;
	
	public Apples() {
		super(0, 3, 5, 3, "a");
		subclassCount++;
		appleCount++;
	}

	public static int getGenerationCount() {
		return subclassCount;
	}
	
	public void reduceGenerationCount() {
		subclassCount--;
	}
	
	public static int getSeedPrice() {
		return seedPrice;
	}
	
	public static int getAppleCount() {
		return appleCount;
	}
	
		
	public String MaturationStr() {
		if (age > maturationAge) {
			String x = symbol.toUpperCase();
			symbol = x;
		}
		return symbol;
	}

	@Override
	public String toString() {
		if(age > maturationAge) {
			this.symbol = "A";
		}
		return symbol;
	}
	
}

