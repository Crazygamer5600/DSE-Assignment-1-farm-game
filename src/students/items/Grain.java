package students.items;

public class Grain{
	static int SubclassCount;
	Food Grain = new Food(0,2,6,2,"g");
	
	public int getGenerationCount(){
		SubclassCount++;
		return SubclassCount;}
	}

