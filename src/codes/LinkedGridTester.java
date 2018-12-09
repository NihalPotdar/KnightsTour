package codes;

import java.util.Scanner;

public class LinkedGridTester {

	public static void main(String[]args) {
		
		Scanner Input = new Scanner(System.in);
		LinkedGrid Grid = new LinkedGrid();
		int Menu, Counter = 0;
		System.out.println("Welcome to Nihal's Linked List Manipulator\n");
		
		do {			
			// Menu to pick choices for what to do
			System.out.println();
			System.out.println("0: Exit the Interface.");
			System.out.println("1. Populate. ");
			System.out.println("2. Display. ");
			System.out.println("3. Mark a Node. ");
			System.out.println("4. Knight's tour");
			Menu = Input.nextInt();
			
			if (Menu == 1 && Counter == 0)
			{ //populating the grid to a certain size
				System.out.print("\nHow large do you want your grid to be? ");
				int Size = Input.nextInt(); // seeking the size of the grid						
				Grid.Populate(Size);
				Counter = Counter+1; // we do not want to run this segment more than once as to avoid populating the list multiple times
			}
			
			else if(Menu == 2) // displaying the grid
				Grid.Display();
			
			else if(Menu == 3)
			{
				int Check = 0, HorizontalCoordinate = 0, VerticalCoordinate = 0;
				
				do {
					System.out.print("\nDo you just want to go with default coordinates? (1 for confirmation, 2 for rejection) ");
					Check = Input.nextInt();
				} while(Check != 1 && Check != 2);
				
				if(Check == 1)
				{// Using Default - middle of list
					HorizontalCoordinate = 3;
					VerticalCoordinate = 3;
				}
				
				else
				{
					// seeking the vertical coordinate
					System.out.print("Please enter a Vertical Coordinate"); 
					VerticalCoordinate = Input.nextInt();
					
					// seeking the horizontal coordinate
					System.out.print("\nPlease enter a Horizontal Coordinate");
					HorizontalCoordinate = Input.nextInt();
				}
				
				// marking that particular position in the grid
				Grid.MarkPosition(HorizontalCoordinate, VerticalCoordinate);
			}
			
			else if (Menu == 4)
			{
				Grid.FindingAndDictatingPathways(); // running the initial constructor
				Menu = 0; // ending the program when its purpose has been served
			}
			
		} while(Menu != 0);
		
		System.out.println("\nThank you for using this interface!");
		
	}	
}

