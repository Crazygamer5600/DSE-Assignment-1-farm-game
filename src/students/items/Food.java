package students.items;

public class Food {
	int age = 0;
	int maturationAge;
	int deathAge;
	int monetaryValue;
	String name;
	
	public Food(int age, int maturationAge, int deathAge, int monetaryValue, String name) {
		this.age=age;
		this.maturationAge=maturationAge;
		this.deathAge=deathAge;
		this.monetaryValue=monetaryValue;
		this.name=name;}
	
	public String MaturationStr(){
		String x = name;
		if (age>maturationAge){
			name = x.toUpperCase();}
		return name;}
	
	Item Food = new Item(age,maturationAge,deathAge,monetaryValue,name);
	
}
