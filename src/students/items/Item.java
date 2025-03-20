package students.items;

public class Item {
	int age = 0;
	int maturationAge;
	int deathAge;
	int maturation;
	int monetaryValue;
	
	public void tick(){
		age++;}

	public void setAge(int age) {
		this.age = age;}
	
	public boolean died(){
		boolean dead = false;
		if(age>deathAge) {
			dead = true;}
		return dead;}

	public int getValue(){
		if (age>maturation){
		return monetaryValue;}
	}

}
