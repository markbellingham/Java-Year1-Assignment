

import java.util.*;

public class Bellingham_Mark_grp13_user_input {

	public static void main(String[] args) {
		//Initialise variables
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
				
		do{
			try{
				//Prints menu
				System.out.println("Press 1 if you want to process a sentence");
				System.out.println("Press 2 if you want to process a file");
				System.out.println("Press 3 to quit");
				
				choice = sc.nextInt();

				if(choice == 1){
					//Gets input from the user
					System.out.println("Please input your sentence");
					String input = sc1.nextLine();
									
					//Sends input to the frequency method				
					Bellingham_Mark_grp13_FreqCalc.frequency(input);
					
					//Prints the output
					Bellingham_Mark_grp13_FreqCalc.print();
					System.out.println();
				}

				else if(choice == 2){
					//Sends the file to the frequency method and prints the output
					Bellingham_Mark_grp13_FreqCalc.fileFrequency();
					System.out.println();
				}
				
				else if(choice < 1 || choice > 3){
					//Error if the user types an integer which is not 1, 2 or 3
					System.out.println("Number must be 1, 2 or 3");
					System.out.println();
				}
				
				else if(choice == 3){
					//Quits the program
					System.out.println();
					System.out.println("Thanks for using the text analyser");
					sc.close();sc1.close();//close the scanners
					break;
					}
				}
				catch(InputMismatchException e){
					/*Error if the user types a letter or other character
					or if they type a fractional number*/
					System.out.println("This is not an Integer");
					System.out.println();
					sc.nextLine();
				}
			}while(choice > 0 || choice < 4);
		}
	}
