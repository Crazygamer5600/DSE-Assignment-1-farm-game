package students.items;

public class Fertilizer extends Item {
	static int subclassCount;
	static int Price = 5;
	
	public Fertilizer(Item x) {
		super(x.getAge(), x.getMaturationAge(), x.getDeathAge(), x.getMonetaryValue()*2, "f");
		subclassCount++;
	}
	
	public static int getGenerationCount() {
		return subclassCount;
	}
	
	public static int getPrice() {
		return Price;
	}
	
	@Override
	public void reduceGenerationCount() {
		subclassCount--;
	}

	@Override
	public String toString() {
		if(age > maturationAge) {
			this.symbol = "F";
		}
		return this.symbol;
	}
	
	

}
