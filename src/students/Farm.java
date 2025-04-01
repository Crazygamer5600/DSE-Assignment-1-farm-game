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
		Scanner command = new Scanner(System.in);
		String input = command.nextLine();
		Field beerenburg=new Field(fieldHeight,fieldWidth);
		beerenburg.prepField();
		
		while(input!="q") {
			beerenburg.toString();
		}
		
		
	}
}
