package students;
import students.items.Soil;
import students.items.Item;


public class Field {
	int height;
	int width;
	Item[][] fieldItems = new Item[width][height];//2d array similar to excel table
	public Field(int height, int width){
		this.height=height;
		this.width=width;}
	public static void main(String[] args) {
		
	}
	public Item[][] prepField(){
		for(int currentRow=0; currentRow<=height;currentRow++){
			for(int rowElement=0;rowElement<width;rowElement++) {
				fieldItems[currentRow][rowElement]=new Soil(1,1,1,1,"");
				}}
		
		return fieldItems;
		
		
		
	}	

	
}