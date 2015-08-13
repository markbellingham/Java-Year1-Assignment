public class Bellingham_Mark_grp13_Tests {

	public static void main(String[] args) {
		
		//Test string
		//Creates the string and prints it for user reference
		String str = "**The Quick Brown Fox Jumps Over The Lazy Dog!^^ *&^&*%$";
		System.out.println("The test string is : " + str);
		System.out.println();
		
		//Sends input to the frequency method				
		Bellingham_Mark_grp13_FreqCalc.frequency(str);
		
		//Array of expected outputs
		double expctd [] = {0.03, 0.03, 0.03, 0.03, 0.09, 0.03, 0.03, 0.06, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.11, 0.03, 0.03, 0.06, 0.03, 0.06, 0.06, 0.03, 0.03, 0.03, 0.03, 0.03}; 
		
		//Prints out the expected output
		System.out.println("The expected output is : ");
		System.out.println();
		for(int i = 0; i < 26; i++){
			System.out.print(Bellingham_Mark_grp13_FreqCalc.getLetters()[i] + " : ");
			System.out.print(expctd[i]);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("3 letter words : 0.40");
		System.out.println("4 letter words : 0.20");
		System.out.println("5 letter words : 0.30");
		
		//Prints the actual output
		System.out.println();
		System.out.println("The actual output is : ");
		Bellingham_Mark_grp13_FreqCalc.print();
		
	}
		
}


