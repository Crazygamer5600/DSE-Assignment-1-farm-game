package students;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;
import java.util.Arrays;
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
		
		for (int currentRow = 0; currentRow < width; currentRow++) {
			for (int rowElement = 0; rowElement < height; rowElement++) {
				fieldItems[currentRow][rowElement] = new Soil();
			}
		}	
	}


	public void tick() {
		for (int currentColumn = 0; currentColumn < height; currentColumn++) {
			for (int currentRow = 0; currentRow < width; currentRow++) {
				fieldItems[currentRow][currentColumn].tick();
				Random ran = new Random();
				int x = ran.nextInt(5) + 1;
				if (fieldItems[currentRow][currentColumn].getSymbol() == "." && x == 1) {
					fieldItems[currentRow][currentColumn].reduceGenerationCount();
					fieldItems[currentRow][currentColumn] = new Weed();
				}
				if (fieldItems[currentRow][currentColumn].died() == true) {
					fieldItems[currentRow][currentColumn].reduceGenerationCount();
					fieldItems[currentRow][currentColumn] = new UntilledSoil();
				}
			}
		}
	}

	@Override
	public String toString() {
		String fieldView=" ";
		for (int currentRow = 0; currentRow < width; currentRow++) {
			fieldView += " "+Integer.toString(currentRow+1);
			if (currentRow == width - 1) {
				fieldView+="\n";
			}
		}
		for (int currentRow = 0; currentRow < height; currentRow++) {
			if (Integer.toString(currentRow + 1).length() == 1) {
				fieldView += Integer.toString(currentRow + 1) + " ";
			}
			else{
				fieldView += Integer.toString(currentRow + 1);
			}
			
			for (int rowElement = 0; rowElement < width; rowElement++) {
				fieldView += fieldItems[rowElement][currentRow] + " ";
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
			fieldItems[xCoord][yCoord] = troforte;
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
		for (int currentRow = 0; currentRow < height; currentRow++) {
			for (int rowElement = 0; rowElement < width; rowElement++) {
				monetaryValue += fieldItems[currentRow][rowElement].getValue();
			}
		}
		return monetaryValue;
	}
	
	public String getSummary() {
		int appleSum = Apples.getGenerationCount();
		int grainSum = Grain.getGenerationCount();
		int soilSum = Soil.getGenerationCount();
		int untilledSum = UntilledSoil.getGenerationCount();
		int weedSum = Weed.getGenerationCount();
		
		String summary = "Apples:" + appleSum + "\n" + "Grain:" + grainSum + "\n" + "Soil:" + soilSum + "\n" + "Untilled:" + untilledSum 
				+ "\n" + "Weed:" + weedSum + "\n";
		
		return summary;		
	}
		
		
}

	
	
	
