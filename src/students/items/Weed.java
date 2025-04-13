package students.items;

public class Weed extends Item {
	
	public Weed() {
		super(0, Integer.MAX_VALUE, Integer.MAX_VALUE, -1, "#");
	}
	
	@Override
	public String toString() {
		return symbol;
	}

	
}