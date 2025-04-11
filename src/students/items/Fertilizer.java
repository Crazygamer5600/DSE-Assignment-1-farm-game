package students.items;

public class Fertilizer extends Item {
	static int subclassCount;
	
	public Fertilizer(Food x) {
		super(x.getAge(), x.getMaturationAge(), x.getDeathAge()+5, x.getMonetaryValue()*2, "F");
		x.reduceGenerationCount();
		subclassCount++;
	}
	
	public static int getGenerationCount() {
		return subclassCount;
	}
	
	@Override
	public void reduceGenerationCount() {
		subclassCount--;
	}

}
