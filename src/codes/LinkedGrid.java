package codes;

public class LinkedGrid {
	private Node FirstOfRow;
	private Node FirstOfGrid;
	private Node Last;
	private int Size;
	private boolean CheckforNextRow = false;
	
	// CONSTRUCTOR:
	public LinkedGrid() {
		Size = 0;
		FirstOfRow = null;
		Last = null;
	}

	public void Display() {
		Node Temp = FirstOfGrid; // setting the temporary variable as the very-FirstOfRow node
		Node RowMarker = FirstOfGrid; // dictating the very instance of the FirstOfRow row
		// we have an additional variable for RowMarker, as we do not want to change 'FirstOfRow'
		
		System.out.println(); // adding a new line for spacing purposes
		for(int x = 0; x < Size; x++)
		{ // printing out the number of 
			while(Temp != null)
			{ // printing out the row, similar as regular display
				System.out.print(Temp.getData() + " ");
				Temp = Temp.getRight();
			}
			
			// Progressing to the FirstOfRow iteration of the next row
			RowMarker = RowMarker.getDown();// progressing to the next row
			Temp = RowMarker; // moving the temporary variable as well
			System.out.println(); // additional line
			// this instance repeats for size times
		}
	}

	public void PushingNodes(int data)
	{
		Node Temp = new Node(data);
		
		if(!CheckforNextRow)
		{ // only for the FirstOfRow row, when nothing has been moved to the next part of the list
			// Only if its the FirstOfRow node in the list, list is empty
			if(FirstOfRow == null) {
				FirstOfGrid = Temp;
				FirstOfRow = Temp; 
			}
	
			else 
			{ // list already has nodes
				Last.setRight(Temp); 
				Temp.setLeft(Last);
			}
			
			// last must always be the 'right-most' occurrence in the list
			Last = Temp;
		}
		
		else 
		{ // next line method has already been activated, meaning row after the FirstOfRow one
			PushNextLines(Temp);
		}
	}
	
	public void PushNextLines(Node Temp)
	{		
		// setting the placement of temp
		Last.setRight(Temp);
		Temp.setLeft(Last);
		
		// Dictating the connections
		Temp.setUP(Temp.getLeft().getUP().getRight()); // setting the up connection
		Temp.getLeft().getUP().getRight().setDown(Temp); // setting the connection from up
		Last = Temp; // moving "last" forward
	}
	
	public void MovingNextLine(int data)
	{
		// creating the FirstOfRow instance of the next row
		Node Temp = new Node(data);
		
		// Remember: the list must be populated to work both ways
		// organizing the temp variable and moving last
		Temp.setUP(FirstOfRow); // Setting the next instance to be one below the FirstOfRow
		FirstOfRow.setDown(Temp); // other side of list
		FirstOfRow = Temp;
		Last = Temp; // moving last to Temp, to begin the next instance of the list
		CheckforNextRow = true;
	}
	
	public void Populate(int Size) {
		this.Size = Size; // setting the size of the grid
		
		for(int x = 0; x < Size; x++)
			PushingNodes(0); // pushing the FirstOfRow row
		
		for(int x = 1; x < Size; x++)
		{ // setting the number of rows

			MovingNextLine(0);
			for(int Populate = 1; Populate < Size; Populate++) // setting each instance in a row
				PushingNodes(0);
		}
	} 
	
	public void MarkPosition(int XCoordinate, int YCoordinate)
	{ // assuming in this case that both x and y will not be out of reach of the code
		
		Node Temp = FirstOfGrid; // one, as it is the starting position
		int Start = 1;
		
		for(int x= 1; x < XCoordinate; x++)
		{ // dictating the movement right
			Temp = Temp.getRight();
		}
		
		for(int y= 1; y < YCoordinate; y++)
		{ // dictating the movement down
			Temp = Temp.getDown();
		} 
		
		// we just give it a value of 1 at the start
		Temp.setData(Start); 
	}

	public void FindingAndDictatingPathways()
	{
		FindingAndDictatingPathways(1,FirstOfGrid);
	}
	
	public void FindingAndDictatingPathways(int Counter, Node CurrentKnight)
	{		
		CurrentKnight.setData(Counter);
		
		if(Counter < (Size*Size))
		{
			// Setting all the paths for the knight (Path 1, Path 2...)
			CurrentKnight.SetAllPaths(CurrentKnight);
			
			// Checking all the paths and seeing if they are open
			// they are an if statement as to pursue every possible path
			if(CurrentKnight.getPath1() != null && CurrentKnight.getPath1().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath1());
			if(CurrentKnight.getPath2() != null && CurrentKnight.getPath2().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath2());
			if(CurrentKnight.getPath3() != null && CurrentKnight.getPath3().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath3());
			if(CurrentKnight.getPath4() != null && CurrentKnight.getPath4().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath4());
			if(CurrentKnight.getPath5() != null && CurrentKnight.getPath5().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath5());
			if(CurrentKnight.getPath6() != null && CurrentKnight.getPath6().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath6());
			if(CurrentKnight.getPath7() != null && CurrentKnight.getPath7().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath7());
			if(CurrentKnight.getPath8() != null && CurrentKnight.getPath8().getData() == 0)
				FindingAndDictatingPathways(Counter+1, CurrentKnight.getPath8());
			
			// in the case that none of the paths are open, it goes one back
			CurrentKnight.setData(0); 
		}
		
			
		else	
		{ // only on the last instance, to showcase the solution
			
			int HighestNumber = FindTheHighestNumberInTheList();
			
			// Due to recursive nature of this algorithm, the program enters this method many times
			// We just compare the two highest number and counter to check for completion
			if(HighestNumber == Counter)
			{  
				System.out.println("\n**********************");
				System.out.println("The solution");
				System.out.println("**********************\n");
				Display();
			}
			
			else // for the case where there is a solution in the grid but not for this particular position
				System.out.println("There is no solution available");
		}
		
		// to account for the case where there is no solution for that grid size as a whole (ie: size 2)
		if(FindTheHighestNumberInTheList() == 0)
		{ 
			System.out.println("\nThere is no solution available");
		}
	}
	
	public int FindTheHighestNumberInTheList()
	{		
		int HighestNumber = 0;
		
		// Going through every node in the list to find the highest number
		Node Temp = FirstOfGrid; // setting the temporary variable as the very-FirstOfRow node
		Node RowMarker = FirstOfGrid; // dictating the very instance of the FirstOfRow row
		// we have an additional variable for RowMarker, as we do not want to change 'FirstOfRow'
	
		for(int x = 0; x < Size; x++)
		{ // printing out the number of 
			while(Temp != null)
			{ // printing out the row, similar as regular display
				if(Temp.getData() > HighestNumber)
					HighestNumber = Temp.getData();
				Temp = Temp.getRight();
			}
			
			// Progressing to the FirstOfRow iteration of the next row
			RowMarker = RowMarker.getDown();// progressing to the next row
			Temp = RowMarker; // moving the temporary variable as well
			// this instance repeats for size times
		}
		return HighestNumber;
	}
}

