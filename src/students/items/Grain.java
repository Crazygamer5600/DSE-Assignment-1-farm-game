package students.items;

public class Grain extends Food{
	static int subclassCount;
	static int seedPrice = 1;
	static int grainCount = 0;
	
	public Grain() {
		super(0, 2, 6, 2, "g");
		subclassCount++;
		grainCount++;
	}
	
	public static int getGenerationCount() {
		return subclassCount;
	}
	
	public static int getSeedPrice() {
		return seedPrice;
	}
	
	public static int getGrainCount() {
		return grainCount;
	}
	
	public void reduceGenerationCount() {
		subclassCount--;	
	}

	@Override
	public String toString() {
		if(age > maturationAge) {
			this.symbol = "G";
		}
		return symbol;
	}
	
		
	}


