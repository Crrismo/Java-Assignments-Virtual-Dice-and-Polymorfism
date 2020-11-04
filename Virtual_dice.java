//Virtual Dice Throwing Program
package Virtual_Dice;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Virtual_dice {
	///^^^ 1st Generate random numbers simulating the throwing of a dice 
	public static int[] throwDice(int nsides, int nthrows){  
		Random number = new Random(  ); 
		int[] resultsArray = new int[nthrows];//initializing an array that holds the numbers from rolling the dice, its length is equal to nthrows
		for(int i=0; i<nthrows;i++){
			//We now use nextInt that will return random numbers in the range [0 , num of sides], thus we then add +1 to shift the value to the dice face
			resultsArray[i] = number.nextInt( nsides )+ 1; // holds the results in an array
		}
		return resultsArray;	
	}
	//^^2nd Calculating the times each number is shown by the dice->Occurence
	public static int[] numberOccurrence(int[] resultsArray, int nsides){
		//using static because we only call this method once
		int[] counterArray = new int[nsides]; //counterArray saves number of times each number is shown; length equal to the number of sides selected in main
		for (int i = 1; i <= nsides; i++) {
			for (int j=0; j< resultsArray.length ; j++) {
				if (resultsArray[j] == i) {
					counterArray[i-1]++; //counter of occurence increasing for that number
				}
			}
		}
		return counterArray;
	}

	///^^^3rd Printing method
	//^^^^^3.1 Print  the resulted numbers shown by the dice by going through the resultsArray values
	//We use void as this is a method for which we do not need to return a value
	public static void printThrowDice(int[] resultsArray){
		System.out.println( "The results of the dice thrower are the following: " );
		for( int i=0; i<resultsArray.length; i++) {
			int printN=resultsArray[i];
			System.out.format(" %d ", printN );
		}
		System.out.println();
	}

	//^^^^^3.2 Print the occurrence 
	public static void printNumberOccurence(int[] resultsArray, int[] printOccArray) {
		int variable = 1; 
		for (int i=0; i< printOccArray.length; i++) {
			System.out.println("Number: " + variable);
			System.out.println("Occurrence: " + printOccArray[i]);
			//To observe what happens to the occurence probabiliy when increasing the number of sides
			System.out.println("Occurrence probability(%): " + (double) printOccArray[i] * 100 / resultsArray.length);
			System.out.println();
			variable++;
		}
	}
	///4th User menu - main method where the program starts and ends
	public static void main (String[] args) {
		Scanner scan = new Scanner( System.in );
		int nsides=0;
		int nthrows =0;
		// Dealing with incorrect Values for the number of sides
		while(true) {
			try {
				System.out.println( "Choose the number of sides of your dice:" );
				nsides = scan.nextInt(); //reading the value
				if(nsides>=2) // the picked number can never be less than 2
					break;
				else System.out.println( "\nHint:It needs to have at least 2 sides." );
			}
			// Check if the scanned value does not match the pattern for the expected type
			//If no exception occurs the catch clause is skipped and execution of try is ended
			catch (InputMismatchException e) {
				System.out.println( "Incorrect input. Choose the sides of your die again.\nHint:The number should be an integer." );
				scan.next();// Scanner next  used to move on to the next line of the  standard  input.
			}
		}
		//Dealing with incorrect values for the number of throws
		while (true) {
			try {
				System.out.println( "How many times do you want your die to be thrown? Must be a multiple of the sides of the die." );
				nthrows = scan.nextInt();
				break;
			}
			catch(InputMismatchException e){
				System.out.println( "Error! Specify again the number of throws." );
				scan.next();
			}
		}
		// Checking if the number of throws 'mod' the number of sides gives zero, which is true for nthrows multiple of nsides
		if(nthrows%nsides!=0){
			while(nthrows%nsides!=0){
				System.out.println( "The input is incorrect. Specify the number of throws again.\n Hint: Must be a multiple of the chosen sides number:" );
				nthrows = scan.nextInt();
			}
		}

		int[] mainThrow = throwDice( nsides, nthrows); // initializing array and giving it the value of the returned dice from throwDice method
		printThrowDice( mainThrow );

		int[] mainOccurence = numberOccurrence( mainThrow,nsides );
		printNumberOccurence( mainThrow,mainOccurence);
	}

}
