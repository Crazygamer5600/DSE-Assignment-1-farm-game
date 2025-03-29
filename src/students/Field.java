package students;
import students.items.Soil;
import students.items.UntilledSoil;

import java.util.Arrays;
import java.util.Random;

import students.items.Item;


public class Field {
	int height;
	int width;
	Item[][] fieldItems;//2d array similar to excel table
	
	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		this.fieldItems= new Item[width][height];
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
					fieldItems[currentRow][rowElement] = new UntilledSoil();
				}
				System.out.println(fieldItems[currentRow][rowElement]);
			}
		}
	}

	
	
	
	
	
}