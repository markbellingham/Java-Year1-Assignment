import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Bellingham_Mark_grp13_FreqCalc {
	
	static String input;
	private static char letters [] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static double [] frequencyArray = new double[letters.length];
	static int [] wordLengths = new int [30];
	static ArrayList<String> lines;
	static DecimalFormat df = new DecimalFormat("0.00");
	static int noOfCharacters;
	static int charCounter [] = new int [letters.length];
	static int noOfWords = 0;
	static double [] wordLengthFreq = new double[30];
		
	//Constructor
	public Bellingham_Mark_grp13_FreqCalc(String input){
		//Bellingham_Mark_grp13_FreqCalc.input = input;
	}	

	
	
	//Method to calculate frequencies
	static double [] frequency(String input)
	{
		//Convert the input to lower case
		input = input.toLowerCase();
		
		//Send input to word count method
		wordCount(input);
		
		/*Check if character matches 'letters' array, increments character counter array 
		 and counts total number of characters*/
		for(int i = 0; i < letters.length; i++){
			for(char a : input.toCharArray()){
				if(a == letters[i]){
					charCounter[i]++;
					noOfCharacters++;
				}
			}
		}		
		
		/*Calculates letter frequencies by dividing the 
		character counter with the total number of characters*/
		for(int i = 0; i <  letters.length; i++){
			frequencyArray[i] =	((double)charCounter[i]/noOfCharacters);
		}
		return frequencyArray;
	}

	
	
	//Method for printing the output
	static void print(){
		
		//Prints the letters and their frequencies
		if(noOfCharacters > 0){
			System.out.println();
			System.out.println("The letter frequencies are : ");
			for(int i = 0; i < letters.length; i++){
				System.out.println();
				System.out.print(letters[i] + " : ");
				System.out.print(df.format(frequencyArray[i]) + " ");
				
				//Prints the letter frequency bar chart
				int n = (int)Math.round(frequencyArray[i]*100);
				String l = "N";
				String base = "";
				while(base.length() < n){
					base = base + l;
				}
				System.out.print(base);
			}
			System.out.println();
			System.out.println();
			
			//Prints out the word size frequencies
			wordFreq();
			System.out.println("The word length frequencies are : ");
			for(int i = 0; i < 30; i++){
				if(wordLengths[i] > 0){
					System.out.println();
					if(i >0 && i < 10){
						System.out.print(" " + i + " letter words : " + (df.format(wordLengthFreq[i])) + " ");
					}
					else if(i >= 10){
						System.out.print(i + " letter words : " + (df.format(wordLengthFreq[i])) + " ");
					}
					
					//Prints the word size frequency bar chart
					if(i>0){
						int n = (int)Math.round(wordLengthFreq[i]*100);
						String l = "N";
						String base2 = "";
						while(base2.length() < n){
							base2 = base2 + l;
						}
						System.out.print(base2);
					}

				}

			}
			System.out.println();
			
			//Clear variables and arrays
			frequencyArray = new double[letters.length];
			charCounter = new int [letters.length];
			noOfCharacters = 0;
			wordLengths = new int [30];
			noOfWords = 0;
			wordLengthFreq = new double[30];
		}
		else{
			System.out.println("There are no letters");
		}
	}
		
	
	
	//Method for retrieving input from a file
	static void fileFrequency(){
		
		//Get input from the user
		System.out.println("Please input your filename including path if necessary");
		Scanner sc1 = new Scanner(System.in);
		String filename = sc1.next();
		noOfCharacters = 0;
		try {
			String input = "";
			//int k = 0;
			
			//Two classes to open text file for reading
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			lines = new ArrayList<String>();
			
			//While the Buffered Reader is still accepting input, assign each line to string 'input'
			while((input=br.readLine()) != null){
				
				//store the lines in ArrayList 'lines'
				lines.add(input);
				//k++;
			}
			
			//Sends the ArrayList lines to the frequency and wordCount methods
			for(int j = 0; j < lines.size(); j++){
				frequency(lines.get(j));
				wordCount(lines.get(j));
			}
			
			//Prints out all the letters along with their accumulated frequencies
			print();
			br.close();
						
		} catch (FileNotFoundException e) {
			//Error if the file is not found
			//e.printStackTrace();
			System.out.println("The file does not exist, please check your filename and/or path");
			System.out.println();
			sc1.nextLine();
		}
		  catch (IOException f){
			f.printStackTrace();
		}
	}
	
	
	
	//Method for counting the word sizes
	static int[] wordCount(String input){
		//Split line where a space is encountered and add to array wordStr
		String words[] = input.split(" ");
		
		for(String w : words){
			String wStripped = w.replaceAll("[^a-zA-Z]", "");
			wordLengths[wStripped.length()]++;
			noOfWords++;
			}
		return wordLengths;
	}


	
	
	
	//Method for calculating the word size frequencies
	static double [] wordFreq(){
		for(int i = 0; i < wordLengths.length; i++){
			wordLengthFreq[i] = ((double)wordLengths[i]/noOfWords);
		}
		return wordLengthFreq;
	}
	
	
	
	// setters and getters
	// getter
	public static char[] getLetters()
	{
		return letters;
	}
	
	// setter
	public void setLetter(char[] aLetters)
	{
		Bellingham_Mark_grp13_FreqCalc.letters = aLetters;
	}
}
