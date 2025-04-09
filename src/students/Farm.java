package students;
import java.util.Scanner;

import students.items.Apples;
import students.items.Grain;


public class Farm {
	int fieldWidth;
	int fieldHeight;
	int Funds;
	
	public Farm(int fieldWidth, int fieldHeight, int Funds) {
	this.fieldWidth = fieldWidth;
	this.fieldHeight = fieldHeight;
	this.Funds = Funds;
	}
	
	public void run() {
		String input = "";
		Scanner command = new Scanner(System.in);
		Field beerenburg = new Field(fieldHeight, fieldWidth);
		beerenburg.prepField();
		
		while(!input.equals("q")) {
			
			System.out.println(beerenburg.toString() + "\n" + "Bank balance: $" + this.Funds + "\n\nEnter your next action:\r\n" 
			+ "  t x y: till\r\n" + "  h x y: harvest\r\n"	+ "  p x y: plant\r\n" + "  s: field summary\r\n" + "  w: wait\r\n" 
			+ "  q: quit\r\n");
			
			input = command.nextLine();
			
			if (input.length() == 1) { 
				if(!input.equals("w") && !input.equals("s") && !input.equals("q")) { //ensures that single character inputs = w,s or q
					System.out.println("invalid input");
				}
				
				if(input.equals("s")) {
					System.out.println(beerenburg.getSummary());
				}
				
			}
			
			else if (input.length() > 1) { 
				if(!input.substring(0,2).equals("t ") && !input.substring(0,2).equals("h ") && !input.substring(0,2).equals("p ")) { //ensures that multi-character inputs  begin with "t ","p " or "h "
					System.out.println("invalid input");
				}
				
				String coords = input.substring(2); // if the above input is correct this segments the input into the string following the operand of t,h and p
				String[] coords1 = coords.split(" "); //removes spaces from the above coordinate and places each character separated with a space into an array
				
				if (coords1.length != 2) { //ensures there are only two coordinates
					System.out.println("invalid");
				}
				
				else if (coords1.length == 2) {
					try {
					int xCoord = Integer.parseInt(coords1[0]); // attempts to convert the string coordinates into integers but if this fails it prints an invalid input error
					int yCoord = Integer.parseInt(coords1[1]);
					coords1[0] = Integer.toString(xCoord); //assigns the variables to coords1 element 0 and 1
					coords1[1] = Integer.toString(yCoord);
					} 
					catch(Exception e) {
						System.out.println("invalid");
						coords1[0] = Integer.toString(-1); //if an error occurs then the coords become -1 to denote that the characters ascribed are not valid
						coords1[1] = Integer.toString(-1);
					}
					
					if (Integer.parseInt(coords1[0]) == -1 || Integer.parseInt(coords1[1]) == -1) {
						System.out.println("invalid");
					}
						
					else if (Integer.parseInt(coords1[0]) != -1 || Integer.parseInt(coords1[1]) != -1) { //ensures that the exception has not occurred
						int xCoord = Integer.parseInt(coords1[0]);
						int yCoord = Integer.parseInt(coords1[1]);
						if (xCoord>fieldWidth || yCoord > fieldHeight || xCoord <= 0 || yCoord <= 0) { //makes sure that neither of the inputs are greater than the bounds of the field
							System.out.println("invalid");
						}
						else {
							if (input.substring(0, 1).equals("t")) { // checks if the user is trying to till
								beerenburg.till(xCoord, yCoord);
							}
							
							if (input.substring(0, 1).equals("h")) { // checks if the user is trying to harvest
								this.Funds+= beerenburg.get(xCoord, yCoord).getValue();
							}
							
							if (input.substring(0, 1).equals("p")) { // checks if the user is trying to plant
								System.out.println("Enter:\r\n" + " - 'a' to buy an apple for $\r\n" + " - 'g' to buy grain for\r\n");
								String seedToPurchase;
								seedToPurchase = command.nextLine();
								if (!seedToPurchase.equals("a") && !seedToPurchase.equals("g")) { //makes sure that the user is choosing one of the two options of an apple or a grain
									System.out.println("invalid");
								}
								
								if (seedToPurchase.equals("a")) { // code to execute if apple is chosen
									if (Apples.getSeedPrice()>this.Funds){ // makes sure that user can afford an apple seed
										System.out.println("insufficient funds");
									}
									
									else { // condition to follow if user can afford seeds
									this.Funds -= Apples.getSeedPrice(); // deducts from funds the seed price
									Apples apple = new Apples(); // instantiates an apple object to plant
									beerenburg.plant(xCoord, yCoord, apple); // plants the object at the specific coordinate
									}
								}
								
								if (seedToPurchase.equals("g")) { // code to execute if grain is chosen
									if (Grain.getSeedPrice()>this.Funds) { // makes sure that user can afford a grain seed
										System.out.println("insufficient funds");
									}
									
									else { // condition to follow if user can afford seeds
									this.Funds-=Grain.getSeedPrice(); // deducts from funds the seed price
									Grain wheat = new Grain(); // instantiates a grain object to plant
									beerenburg.plant(xCoord, yCoord, wheat); // plants the object at the specific coordinate
									}
								}
							}
						}
					}
				}		
			}
			beerenburg.tick();
		}	
	}		
}

