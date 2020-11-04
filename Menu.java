package Shapes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	//main method where the program starts and ends
	public static void main (String[] args){
		Scanner scan = new Scanner( System.in );
		int number=0;
		double radius=0;
		double height=0;
		int x=0;
		int y=0;
		int i=0; // to count the number of shapes created 
		Shape [] Array =new Shape [100]; // creating array to save the shapes
		int variable=0;//keeps count of all shapes created
		//The menu will give the option to create shapes until the user chooses option 4 - to print all shapes
		while (number!=4){	
			while(true) {
				try {
					System.out.println( "\nPlease choose your option: " );
					System.out.println("\n Press 1 to create Point");
					System.out.println("\n Press 2 to create Circle");
					System.out.println("\n Press 3 to create Cylinder");
					System.out.println("\n Press 4 to print");
					number = scan.nextInt();
					//The menu has only 4 options
					if(number<5 && number>0) {
						break;}
					else System.out.println("\n The menu offers only 4 options. Please introduce a number smaller than 4. ");
				}
				//Check if the scanned value does not match the pattern for the expected type
				//If no exception occurs the catch clause is skipped and execution of try is ended
				catch (InputMismatchException e) {
					System.out.println( "\nInputMismatchException" );
					System.out.println( "Choose between the 4 menu options" );
					scan.next();
				}
			}
			//Keep on giving the options for the user to print shapes until the user presses 4 to print all
			if(number!=4) {
				//For the User to enter x and y coordinates; checking if the values do not match the expected parameters	
			    System.out.println("\n Please enter the x and y coordinates:\n");
			    //check the x coordinate input
			    while(true) {
					try {
						 System.out.println("Enter the x coordinate");
						x = scan.nextInt();
						break;
					}
					catch (InputMismatchException e) {
						System.out.println( "Error!\nHint:The x coordinate needs to be an integer.");
						scan.next();
					}
					System.out.println();
			    }
			    //check the y coordinate input
					 while(true) {
							try {
								 System.out.println("Enter the y coordinate");
								y = scan.nextInt();
								break;
							}
							catch (InputMismatchException e) {
								System.out.println(  "Error!\nHint:The y coordinate needs to be an integer.");
								scan.next();
							}
							System.out.println();
					 } 
				if (number==1) {
					Point point = new Point(x,y);// Creating new object point, calling the 2nd Point constructor with parameters for initialization
					Array[variable]=point;
				}
				//for circle and cylinder we also need radius
				if(number==2 || number==3) {

					while(true) {
						//it verifies if we have a valid integer, the catch block catches the error and forces the loop to repeat
						try {
							
							System.out.println( "Please enter the desired radius: " );
							radius = scan.nextInt();
							if(radius>0)
							break;
							else System.out.println( "Hint:The radius must be a positive number" );
						}
						//in case the scanned parameter is not as expected
						catch (InputMismatchException e) {
							System.out.println( "Error!.\nHint: It must be of of type double." );
							scan.next();
						}
						
						System.out.println();
					}
					if (number==2) {
						Circle circle = new Circle( x, y , radius);  //Creating new object circle, calling Circle constructor for initialization
						Array[variable] = circle;

					}
					//for cylinder we also need a height							}
					if (number==3) {
						while(true) {
							try {
								//String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
								System.out.println( "Please enter the desired height: " );
								height = scan.nextInt();
								//height must be positive
								if(height>0)
									break;
								else System.out.println( "Hint:The height must be a positive number" );
							}
							catch (InputMismatchException e) {
								System.out.println( "Error!.\nHint: It must be of of type double" );
								scan.next();
							}

							System.out.println();
						}
						Cylinder cylinder = new Cylinder( x, y, radius, height); ////Creating new object cylinder, calling Cylinder constructor from Cylinder class
						Array[variable] = cylinder;

					}

				}
				variable ++;	
				System.out.println( "Shape saved. Please choose what you want to do next: " );
			}		

		if(number==4) {
			if (variable==0) 	
				System.out.println("You haven't saved any shapes");
			else {
				System.out.println("You have saved the following shapes:\n");	
				//print all the Array's elements
				for( i=0; i<variable; i++) { //virtual method invocations
					System.out.println(Array[i].getName() + ": " + Array[i].toString());
					System.out.println("Area: " + Array[i].getArea());
					System.out.println("Volume: " + Array[i].getVolume());
					System.out.println();

				}
			}
		}
	}

		}}



