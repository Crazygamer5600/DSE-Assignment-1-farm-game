package students;
import students.items.Apples;

public class Main {

	public static void main(String[] args) {
		Field r = new Field(10,10);
		r.prepField();
		r.tick();
		System.out.println(r.toString());
		r.till(10, 10);
		System.out.println(r.toString());
		
	
	}
}
