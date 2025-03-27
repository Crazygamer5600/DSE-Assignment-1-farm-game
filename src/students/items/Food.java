package students.items;

public class Food extends Item {
	
	public Food(int age, int maturationAge, int deathAge, int monetaryValue, String name) {
		super(age, maturationAge, deathAge, monetaryValue, name);
			}
	
	public String MaturationStr(){
		String x = name;
		if (age>maturationAge){
			name = x.toUpperCase();}
		return name;}
	
	
	
}
