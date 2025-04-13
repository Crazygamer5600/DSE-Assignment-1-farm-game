package students.items;

public class UntilledSoil extends Item{
	
	public UntilledSoil() {
		super(0, Integer.MAX_VALUE, Integer.MAX_VALUE, -1, "/");
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
}
