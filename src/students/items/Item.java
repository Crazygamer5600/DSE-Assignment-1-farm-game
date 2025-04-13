package students.items;

public abstract class Item {
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
		if (this.toString().equals("A") || this.toString().equals("G") || this.toString().equals("F")) {
			return monetaryValue;
		}
		else {
			return 0;
		}	
	}

	public boolean equals(Item x) {
		if (x.age == this.age && x.deathAge == this.deathAge && x.maturationAge == this.maturationAge && x.monetaryValue == this.monetaryValue) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getAge() {
		return age;
	}
	public int getMaturationAge() {
		return maturationAge;
	}
	
	public int getDeathAge() {
		return deathAge;
	}
	
	public int getMonetaryValue() {
		return monetaryValue;
	}
	

	@Override
	public String toString() {
		return symbol;
	}
	
	
}	


