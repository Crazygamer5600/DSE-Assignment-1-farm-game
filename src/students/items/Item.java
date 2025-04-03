package students.items;

import java.util.HashMap; 

public class Item {
	int age;
	int maturationAge;
	int deathAge;
	int monetaryValue;
	String symbol;

	public Item(int age, int maturationAge, int deathAge, int monetaryValue, String symbol) {
		this.age = age;
		this.maturationAge = maturationAge;
		this.deathAge = deathAge;
		this.monetaryValue = monetaryValue;
		this.symbol = symbol;
	}
	
	public int getGenerations(Item objName ){
		HashMap<String, Integer> capitalCities = new HashMap<String, Integer>();
		capitalCities.put(symbol, objName.getGenerations());
	}

	public void tick() {
		age++;
	}

	public void setAge(int age) {
		this.age = age;
		
	}
	
	public boolean died() {
		boolean dead = false;
		if(age > deathAge) {
			dead = true;
		}
		return dead;
	}

	public int getValue() {
		if (age > maturationAge) {
			return monetaryValue;
		} else {
			return 0;
		}
	}
	
	
	public String getSymbol() {
		return symbol;
	}

	public boolean equals(Item x, Item y) {
		if (x.age == y.age && x.deathAge == y.deathAge && x.maturationAge == y.maturationAge && x.monetaryValue == y.monetaryValue) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString(){
		return "Item [age=" + age + ", maturationAge=" + maturationAge + ", deathAge=" + deathAge + ", monetaryValue="
				+ monetaryValue + "]";
	}
	
	
}	


