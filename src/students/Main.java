package students;
import students.items.Apples;
import students.items.Grain;

public class Main {

	public static void main(String[] args) {
		Apples GrannySmith = new Apples();
		Apples GrannySmith1 = new Apples();
		Apples GrannySmith2 = new Apples();
		Apples GrannySmith3 = new Apples();
		Apples GrannySmith4 = new Apples();
		System.out.println(Apples.getGenerationCount());
		Field r = new Field(10,10);
		r.prepField();
		r.tick();
		System.out.println(r.toString());
		r.till(10, 10);
		r.plant(1, 1, GrannySmith);
		r.tick();
		r.tick();
		r.tick();
		r.tick();
		r.tick();
		r.tick();
		System.out.println(r.toString());
		System.out.println(r.get(1, 1));

		System.out.println(r.getSummary());
		
		
		
	
	}
}
