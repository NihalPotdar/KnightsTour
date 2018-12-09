package codes;

public class Node {
	private int data;
	
	// The respective navigation means for an individual node
	private Node UP;
	private Node Down;
	private Node Left;
	private Node Right;
	
	// The Paths available for a Knight from his position
	private Node Path1;
	private Node Path2;
	private Node Path3;
	private Node Path4;
	private Node Path5;
	private Node Path6;
	private Node Path7;
	private Node Path8;
	
	public Node(int data) {
		this.data = data;
		UP = null;
		Down = null;
		Left = null;
		Right = null;
	}

	public Node() {
		data = -1;
		UP = null;
		Down = null;
		Left = null;
		Right = null;
	}

	public Node getPath1() {
		return Path1;
	}

	public void SetAllPaths(Node CurrenKnightPosition)
	{ // rather than calling each individual path, this method can be called
		setPath1(CurrenKnightPosition); // setting path 1
		setPath2(CurrenKnightPosition); // setting path 2
		setPath3(CurrenKnightPosition); // setting path 3
		setPath4(CurrenKnightPosition);// setting path 4
		setPath5(CurrenKnightPosition); // setting path 5
		setPath6(CurrenKnightPosition); // setting path 6
		setPath7(CurrenKnightPosition);// setting path 7
		setPath8(CurrenKnightPosition); // setting path 8		
	}
	
	public void setPath1(Node CurrenKnightPosition)
	{// finding and setting each path node as per its unique feature
		try {
			Path1 = CurrenKnightPosition;
			Path1 = Path1.getUP().getUP().getRight();
		}
		catch(NullPointerException e)
		{ // in the case that path 1 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)
			Path1 = null;
		}
	}
	
 	public Node getPath2() {
		return Path2;
	}

	public void setPath2(Node CurrenKnightPosition)
	{ // finding and setting each path node as per its unique feature
		try {
			Path2 = CurrenKnightPosition;
			Path2 = Path2.getUP().getUP().getLeft();
		}
		catch(NullPointerException e)
		{// in the case that path 2 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)			
			Path2 = null;
		}
	}
	
	public Node getPath3() {
		return Path3;
	}

	public void setPath3(Node CurrenKnightPosition)
	{// finding and setting each path node as per its unique feature
		try {
			Path3 = CurrenKnightPosition;
			Path3 = Path3.getLeft().getLeft().getUP();
		}
		catch(NullPointerException e)
		{// in the case that path 3 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)
			Path3 = null;
		}
	}

	public Node getPath4() {
		return Path4;
	}

	public void setPath4(Node CurrenKnightPosition)
	{// finding and setting each path node as per its unique feature
		try {
			Path4 = CurrenKnightPosition;
			Path4 = Path4.getLeft().getLeft().getDown();
		}
		catch(NullPointerException e)
		{// in the case that path 4 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)
			Path4 = null;
		}
	}

	public Node getPath5() {
		return Path5;
	}

	public void setPath5(Node CurrenKnightPosition)
	{// finding and setting each path node as per its unique feature
		try {
			Path5 = CurrenKnightPosition;
			Path5 = Path5.getDown().getDown().getLeft();
		}
		catch(NullPointerException e)
		{// in the case that path 5 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)
			Path5 = null;
		}
	}

	public Node getPath6() {
		return Path6;
	}

	public void setPath6(Node CurrenKnightPosition)
	{
		try {
			Path6 = CurrenKnightPosition;
			Path6 = Path6.getDown().getDown().getRight();
		}
		catch(NullPointerException e)
		{// in the case that path 6 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)
			Path6 = null;
		}
	}
	
	public Node getPath7() {
		return Path7;
	}

	public void setPath7(Node CurrenKnightPosition)
	{
		try {
			Path7 = CurrenKnightPosition;
			Path7 = Path7.getRight().getRight().getDown();
		}
		catch(NullPointerException e)
		{// in the case that path 7 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)
			Path7 = null;
		}
	}
	
	public Node getPath8() {
		return Path8;
	}
	
	public void setPath8(Node CurrenKnightPosition)
	{
		try {
			Path8 = CurrenKnightPosition;
			Path8 = Path8.getRight().getRight().getUP();
		}
		catch(NullPointerException e)
		{// in the case that path 8 is not available (outside the board), setting it to null
			// Will only be activated when the available path is a null (not available)
			Path8 = null;
		}
	}
	
	// Getters and Setters
	public int getData() {
		return data;
	}
	

	public Node getUP() {
		return UP;
	}
	

	public void setUP(Node uP) {
		UP = uP;
	}
	

	public Node getDown() {
		return Down;
	}
	

	public void setDown(Node down) {
		Down = down;
	}
	

	public Node getLeft() {
		return Left;
	}
	

	public void setLeft(Node left) {
		Left = left;
	}
	

	public Node getRight() {
		return Right;
	}
	

	public void setRight(Node right) {
		Right = right;
	}
	

	public void setData(int data) {
		this.data = data;
	}
}

