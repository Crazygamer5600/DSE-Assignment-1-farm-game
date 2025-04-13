package students.items;

public class Fertilizer extends Item {
	static int Price = 5;
	
	public Fertilizer(Item x) {
		super(x.getAge(), x.getMaturationAge()-1, x.getDeathAge(), x.getMonetaryValue()*2, "f");
	}
	
	public static int getPrice() {
		return Price;
	}

	@Override
	public String toString() {
		if(age > maturationAge) {
			this.symbol = "F";
		}
		return this.symbol;
	}
	
	

}
