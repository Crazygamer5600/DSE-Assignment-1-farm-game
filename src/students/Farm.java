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
			
			if (input.length()==1) {
				if(!input.equals("w") && !input.equals("s") && !input.equals("q")){
					System.out.println("invalid input");
				}
			}
			
			else if (input.length()>1) {
				if(!input.substring(0,2).equals("t ") && !input.substring(0,2).equals("h ") && !input.substring(0,2).equals("p ")){
					System.out.println("invalid input");
				}
				String coords = input.substring(2);
				String[] coords1 = coords.split(" ");
				String[] validChars = {"1","2","3","4","5","6","7","8","9","0"," "};
				if (coords1.length!=2) {
					System.out.println("invalid");
				}
				else if (coords1.length==2) {
					try {
					int xCoord = Integer.parseInt(coords1[0]);
					int yCoord = Integer.parseInt(coords1[1]);
					}catch(Exception e){
						System.out.println("invalid");
					}
				}
				}
			
			
			beerenburg.tick();
		}
			
		}
		
		
}

