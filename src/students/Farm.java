package students;
import java.util.Scanner;

public class Farm {
	int fieldWidth;
	int fieldHeight;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
	this.fieldWidth=fieldWidth;
	this.fieldHeight=fieldHeight;
	}
	
	public void run(){
		String input = "";
		Scanner command = new Scanner(System.in);
		Field beerenburg=new Field(fieldHeight,fieldWidth);
		beerenburg.prepField();
		
		while(!input.equals("q")) {
			System.out.println(beerenburg.toString());
			input = command.nextLine();
			if(!input.equals("w") && !input.equals("s") && !input.equals("q") && input.charAt(0)!=('t') && input.charAt(0)!=('h') && input.charAt(0)!=('p')) {
				System.out.println("invalid input");
			}
			beerenburg.tick();
			
			
		}
		
		
	}
}
