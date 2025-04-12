package students;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;
import java.util.Random;
import students.items.Item;
import students.items.Apples;
import students.items.Fertilizer;
import students.items.Grain;

public class Field {
	int height;
	int width;
	Item[][] fieldItems;
	
	public Field(int width, int height) {
		this.height = height;
		this.width = width;
		this.fieldItems = new Item[width][height];
		
		for (int currentRow = 0; currentRow < width; currentRow++) { //loops through range of the x coordinate in the 2d array
			for (int currentColumn = 0; currentColumn < height; currentColumn++) { //loops through range of the y coordinate in the 2d array
				fieldItems[currentRow][currentColumn] = new Soil(); // populates every element in the 2d array with soil
			}
		}	
	}


	public void tick() {
		for (int currentColumn = 0; currentColumn < height; currentColumn++) { // loops through range of height
			for (int currentRow = 0; currentRow < width; currentRow++) { // loops through range of width
				fieldItems[currentRow][currentColumn].tick(); // ages all elements by 1
				Random ran = new Random();
				int randomInteger = ran.nextInt(5) + 1; // generates a random integer between 1 and 5
				if (fieldItems[currentRow][currentColumn].toString() == "." && randomInteger == 1) { // if soil and the randomInteger = 1 which it has a 20 percent chance of doing so
					fieldItems[currentRow][currentColumn].reduceGenerationCount(); 
					fieldItems[currentRow][currentColumn] = new Weed(); // weed grows 20 percent of the time
				}
				if (fieldItems[currentRow][currentColumn].died() == true) { // if a perishable object inheriting from item has died
					fieldItems[currentRow][currentColumn].reduceGenerationCount();
					fieldItems[currentRow][currentColumn] = new UntilledSoil(); // plant becomes untilled soil
				}
			}
		}
	}

	@Override
	public String toString() {
		String fieldView=" ";
		for (int currentRow = 0; currentRow < width; currentRow++) { // loops through the numbers in the x coordinate and assigns the values to fieldView
			fieldView += " "+Integer.toString(currentRow+1);
			if (currentRow == width - 1) {
				fieldView+="\n";
			}
		}
		for (int currentRow = 0; currentRow < height; currentRow++) {
			if (Integer.toString(currentRow + 1).length() == 1) { // condition to properly space out numbers in the range of y coordinate
				fieldView += Integer.toString(currentRow + 1) + " "; 
			}
			else{ // condition to properly space out numbers in the range of y coordinate
				fieldView += Integer.toString(currentRow + 1);
			}
			
			for (int currentColumn = 0; currentColumn < width; currentColumn++) {
				fieldView += fieldItems[currentColumn][currentRow] + " "; // adds all items together but spaced out
			}
			fieldView += "\n";
		}
		return fieldView;
		
	}
	
	
	public void till(int xCoord, int yCoord) {
		fieldItems[xCoord][yCoord].reduceGenerationCount();
		fieldItems[xCoord][yCoord] = new Soil();
	}
	
	public void fertilize(int xCoord, int yCoord) {
			fieldItems[xCoord][yCoord].reduceGenerationCount();
			Fertilizer troforte = new Fertilizer(fieldItems[xCoord][yCoord]);
			fieldItems[xCoord][yCoord] = troforte; // replaces the item prior with its own fertilized version
	}

	public Item get(int xCoord, int yCoord) {
		return fieldItems[xCoord][yCoord];
	}
	
	public void plant(int xCoord, int yCoord, Item plant) {
		fieldItems[xCoord][yCoord].reduceGenerationCount();
		fieldItems[xCoord][yCoord] = plant;
	}
	
	public int getValue() {
		int monetaryValue = 0;
		for (int currentRow = 0; currentRow < width; currentRow++) {
			for (int currentColumn = 0; currentColumn < height; currentColumn++) {
				monetaryValue += fieldItems[currentRow][currentColumn].getValue();// uses get value method which returns value of only food items
			}
		}
		return monetaryValue;
	}
	
	public String getSummary() {
		int appleSum = Apples.getGenerationCount(); // each variable with get gen count monitors the quantity of each object currently in the field
		int grainSum = Grain.getGenerationCount();
		int soilSum = Soil.getGenerationCount();
		int untilledSum = UntilledSoil.getGenerationCount();
		int weedSum = Weed.getGenerationCount();
		int fertilizedSum = Fertilizer.getGenerationCount();
		
		String summary = "Apples:" + appleSum + "\n" + "Grain:" + grainSum + "\n" + "Soil:" + soilSum + "\n" + "Untilled:" + untilledSum 
				+ "\n" + "Weed:" + weedSum + "\n" + "fetilizer:" + fertilizedSum + "\nFor a total of $" + this.getValue() + "\nTotal apples created: "
				+ Apples.getAppleCount() + "\nTotal grain created: "+ Grain.getGrainCount() + "\n"; // grain count and apple count monitor past instances of apple and grain.
		
		return summary;		
	}
		
		
}

	
	
	
