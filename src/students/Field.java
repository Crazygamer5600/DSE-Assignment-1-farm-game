package students;

public class Field {
	int height;
	int width;
	String[][] fieldItems = new String [width][height];//2d array similar to excel table
	public Field(int height, int width){
		this.height=height;
		this.width=width;
	}

	
}