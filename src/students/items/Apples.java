package students.items;

public class Apples {
		static int SubclassCount;
		Food Apple = new Food(0,2,6,2,"a");

		public int getGenerationCount(){
			SubclassCount++;
			return SubclassCount;}	
}

