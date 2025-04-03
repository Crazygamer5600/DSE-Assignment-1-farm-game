package students;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;
import java.util.Arrays;
import java.util.Random;
import students.items.Item;
import students.items.Apples;
import students.items.Grain;

public class Field {
	int height;
	int width;
	Item[][] fieldItems;//2d array similar to excel table
	
	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		this.fieldItems = new Item[width][height];
	}
	
	public void prepField() {
		for (int currentRow = 0; currentRow < height; currentRow++) {
			for (int rowElement = 0; rowElement < width; rowElement++) {
				fieldItems[currentRow][rowElement] = new Soil();
			}
		}	
	}	

	public void tick() {
		for (int currentRow = 0; currentRow < height; currentRow++) {
			for (int rowElement = 0; rowElement < width; rowElement++) {
				fieldItems[currentRow][rowElement].tick();
				Random ran = new Random();
				int x = ran.nextInt(5) + 1;
				if (fieldItems[currentRow][rowElement].getSymbol() == "." && x==1){
					fieldItems[currentRow][rowElement] = new Weed();
				}
				if (fieldItems[currentRow][rowElement].died()==true) {
					fieldItems[currentRow][rowElement]=new UntilledSoil();
				}
				System.out.println(fieldItems[currentRow][rowElement]);
			}
		}
	}

	@Override
	public String toString() {
		String fieldView=" ";
		for (int currentRow = 0; currentRow < width; currentRow++) {
			fieldView += " "+Integer.toString(currentRow+1);
			if (currentRow == width-1) {
				fieldView+="\n";
			}
		}
		for (int currentRow = 0; currentRow < height; currentRow++) {
			if (Integer.toString(currentRow+1).length()==1) {
				fieldView+=Integer.toString(currentRow+1)+" ";}
			else{
				fieldView+=Integer.toString(currentRow+1);}
			
			for (int rowElement = 0; rowElement < width; rowElement++) {
				fieldView+=fieldItems[currentRow][rowElement].getSymbol() + " ";
			}
			fieldView+="\n";
		}
		return fieldView;
		
	}
	
	public void till(int xCoord, int yCoord) {
		fieldItems[xCoord-1][yCoord-1] = new Soil();
	}

	public Item get(int xCoord, int yCoord) {
		return fieldItems[xCoord-1][yCoord-1];
	}
	
	public void plant(int xCoord, int yCoord, Item plant) {
		fieldItems[xCoord-1][yCoord-1] = plant;
	}
	
	public int getValue() {
		int monetaryValue=0;
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
		
		String summary="Apples:"+appleSum+"\n"+"Grain:"+grainSum+"\n"+"Soil:"+soilSum+"\n"+"Untilled:"+untilledSum+"\n"+"Weed:"+weedSum+"\n";
		
		return summary;		
			}
		
		
	}

	
	
	
