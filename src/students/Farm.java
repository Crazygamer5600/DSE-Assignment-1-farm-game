package students;
import java.util.Scanner;

import students.items.Apples;
import students.items.Fertilizer;
import students.items.Grain;


public class Farm {
	int fieldWidth;
	int fieldHeight;
	int funds;
	
	public Farm(int fieldWidth, int fieldHeight, int funds) {
		this.fieldWidth = fieldWidth;
		this.fieldHeight = fieldHeight;
		this.funds = funds;
	}
	
	public void run() {
		String input = "";
		Scanner command = new Scanner(System.in);
		Field beerenburg = new Field(fieldWidth, fieldHeight);// instantiates the field then prepares a 2d array populated solely
		
		while(!input.equals("q")) {// begins the game under the pretense that input should never be equal to q and continue in the loop
			System.out.println(beerenburg.toString() + "\n" + "Bank balance: $" + this.funds + "\n\nEnter your next action:\r\n" 
			+ "  t x y: till\r\n" + "  h x y: harvest\r\n"	+ "  p x y: plant\r\n" + "  s: field summary\r\n" + "  w: wait\r\n"
			+ "  f x y: fertilize in bulk \r\n" + "  q: quit\r\n");
			
			input = command.nextLine();
			
			if (input.length() == 1) { //if the input has a length of one character
				if(!input.equals("w") && !input.equals("s") && !input.equals("q")) { //ensures that single character inputs = w,s or q otherwise it will print erro then skip turn
					System.out.println("invalid input");
				}
				
				if(input.equals("s")) {
					System.out.println(beerenburg.getSummary());
				}
				
			}
			
			else if (input.length() > 1) { 
				if(!input.substring(0,2).equals("t ") && !input.substring(0,2).equals("h ") && !input.substring(0,2).equals("p ") && !input.substring(0,2).equals("f ")) { //ensures that multi-character inputs  begin with "t ","p ","b " or "h "
					System.out.println("invalid input");
				}
				
				String coords = input.substring(2); // if the above input is correct this segments the input into the string following the operand of t,h and p
				String[] coords1 = coords.split(" "); //removes spaces from the above coordinate and places each character separated with a space into an array
				
				if (coords1.length != 2) { //ensures there are only two coordinates
					System.out.println("invalid input");
				}
				
				else if (coords1.length == 2) {
					try {
						int xCoord = Integer.parseInt(coords1[0]); // attempts to convert the coordinates into integers but if this fails it assigns invalid numbers to a variable which will make the program know it is invalid. 
						int yCoord = Integer.parseInt(coords1[1]);
						coords1[0] = Integer.toString(xCoord); //assigns the variables to coords1 element 0 and 1
						coords1[1] = Integer.toString(yCoord);
					} 
					catch(Exception e) {
						coords1[0] = Integer.toString(-1); //if an error occurs then the coords become -1 to denote that the characters ascribed are not valid
						coords1[1] = Integer.toString(-1);
					}
					
					int xCoord = Integer.parseInt(coords1[0]) - 1;
					int yCoord = Integer.parseInt(coords1[1]) - 1;
					if (xCoord >= fieldWidth || yCoord >= fieldHeight || xCoord < 0 || yCoord < 0) { //makes sure that neither of the inputs are greater than the bounds of the field
						System.out.println("invalid input");
					}
					
					else {
						if (input.substring(0, 1).equals("t")) { // checks if the user is trying to till
							beerenburg.till(xCoord, yCoord);
						}
							
						if (input.substring(0, 1).equals("h")) { // checks if the user is trying to harvest
							this.funds+= beerenburg.get(xCoord, yCoord).getValue();
							System.out.println("Sold " + beerenburg.get(xCoord, yCoord) + " for " + beerenburg.get(xCoord, yCoord).getValue());
							beerenburg.till(xCoord, yCoord);
						}
						
						if (input.substring(0, 1).equals("f")) { // checks if the user is trying bulk fertilize
							System.out.println("Write the number of spots beside and below your coordinate that you want to fertilize (x y)");
							String coveredArea;
							coveredArea = command.nextLine();
							String[] coveredArea1 = coveredArea.split(" ");
							if (coveredArea1.length != 2) { //ensures there are only two coordinates
								System.out.println("invalid input");
							}
							
							else if (coveredArea1.length == 2) {
								try {
									int horizonRange = Integer.parseInt(coveredArea1[0]); // attempts to convert the range into integers but if this fails it assigns a value which the program will know is wrong
									int verticalRange = Integer.parseInt(coveredArea1[1]);
									coveredArea1[0] = Integer.toString(horizonRange); //assigns the variables to coords1 element 0 and 1
									coveredArea1[1] = Integer.toString(verticalRange);
								}catch(Exception f) {
									coveredArea1[0] = Integer.toString(Integer.MAX_VALUE); //if an error occurs then range is maxxed to denote that input is invalid;
									coveredArea1[1] = Integer.toString(Integer.MAX_VALUE);
								}
								
								
								if (Integer.parseInt(coveredArea1[0]) + xCoord > fieldWidth-1 || Integer.parseInt(coveredArea1[0]) + xCoord > fieldWidth-1) {
									System.out.println("invalid input");
								}
								
								else if (Integer.parseInt(coveredArea1[0]) < 0 || Integer.parseInt(coveredArea1[1]) < 0 ) {
									System.out.println("invalid input");
								}
								
								else if (Integer.parseInt(coveredArea1[0]) == 0  && Integer.parseInt(coveredArea1[1]) == 0) {
									if (this.funds<=0) {
										System.out.println("insufficient funds");
										break;
									}
									else {
										this.funds -= Fertilizer.getPrice();
									}
									beerenburg.fertilize(xCoord, yCoord);
								}
								
								else if (Integer.parseInt(coveredArea1[0]) == 0  && Integer.parseInt(coveredArea1[0]) != 0) {
									for (int y = 0; yCoord + y <= yCoord + Integer.parseInt(coveredArea1[1]);) {
										if (this.funds<=0) {
											System.out.println("insufficient funds");
											break;
										}
										else {
											this.funds -= Fertilizer.getPrice();
										}
										beerenburg.fertilize(xCoord, yCoord-y);
										}
									}
								
								
								else if (Integer.parseInt(coveredArea1[0]) != 0  && Integer.parseInt(coveredArea1[0]) == 0) {
									for (int x = 0; xCoord + x <= xCoord + Integer.parseInt(coveredArea1[1]); ) {
										if (this.funds<=0) {
											System.out.println("insufficient funds");
											break;
										}
										else {
											this.funds -= Fertilizer.getPrice();
										}
										beerenburg.fertilize(xCoord-x, yCoord);
									}
								}
								
								else {
									int x = xCoord;
									for(; xCoord <= x + Integer.parseInt(coveredArea1[0]) ;xCoord++) {
										int y = yCoord;
										if (this.funds<=0) {
											System.out.println("insufficient funds");
											break;
										}
									
										for(; yCoord <= y + Integer.parseInt(coveredArea1[1]) ;yCoord++) {
											System.out.println(xCoord+"+"+yCoord);
											beerenburg.fertilize(xCoord, yCoord);
											this.funds -= Fertilizer.getPrice();
											if (this.funds<=0) {
												break;
											}
										}
										yCoord = y;
									}		
								}
							}
						}
					
							
						if (input.substring(0, 1).equals("p")) { // checks if the user is trying to plant
							System.out.println("Enter:\r\n" + " - 'a' to buy an apple for $\r\n" + " - 'g' to buy grain for\r\n");
							String seedToPurchase;
							seedToPurchase = command.nextLine();
							if (!seedToPurchase.equals("a") && !seedToPurchase.equals("g")) { //makes sure that the user is choosing one of the two options of an apple or a grain
								System.out.println("invalid input");
							}
								
							if (seedToPurchase.equals("a")) { // code to execute if apple is chosen
								if (Apples.getSeedPrice() > this.funds) { // makes sure that user can afford an apple seed
									System.out.println("insufficient funds");
								}
									
								else { // condition to follow if user can afford seeds
									this.funds -= Apples.getSeedPrice(); // deducts from funds the seed price
									Apples apple = new Apples(); // instantiates an apple object to plant
									beerenburg.plant(xCoord, yCoord, apple); // plants the object at the specific coordinate
								}
							}
								
							if (seedToPurchase.equals("g")) { // code to execute if grain is chosen
								if (Grain.getSeedPrice() > this.funds) { // makes sure that user can afford a grain seed
									System.out.println("insufficient funds");
								}
									
								else { // condition to follow if user can afford seeds
									this.funds -= Grain.getSeedPrice(); // deducts from funds the seed price
									Grain wheat = new Grain(); // instantiates a grain object to plant
									beerenburg.plant(xCoord, yCoord, wheat); // plants the object at the specific coordinate
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


