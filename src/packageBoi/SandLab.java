package packageBoi;

import java.awt.*;
import java.util.*;

public class SandLab
{
  //Step 4,6
  //add constants for particle types here
  public static final int CLEAR = 0;
  public static final int EMPTY = 1;
  public static final int METAL = 2;
  public static final int SAND = 3;
  public static final int WATER = 4;
  public static final int GRASS = 5;
  public static final int DIRT = 6;
  public static final int FIRE = 7;
  public static final int STEAM = 8;
  public static final int OIL = 9;
  public static final int BOUNCE = 10;
  public static final int BUBBLE = 11;
  public static final int IDK = 12;
  public static final int GUNPOWDER = 13;
  public boolean[] bounceUp;
  public boolean twoByTwo;
  
  //do not add any more fields below
  private int[][] grid;
  private SandDisplay display;
  
  
  /**
   * Constructor for SandLab
   * @param numRows The number of rows to start with
   * @param numCols The number of columns to start with;
   */
  public SandLab(int numRows, int numCols)
  {
    String[] names;
    // Change this value to add more buttons
    //Step 4,6
    names = new String[14];
    // Each value needs a name for the button
    names[CLEAR] = "Clear";
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[GRASS] = "Grass";
    names[DIRT] = "Dirt";
    names[FIRE] = "Fire";
    names[STEAM] = "Steam";
    names[OIL] = "Oil";
    names[BOUNCE] = "Bounce";
    names[BUBBLE] = "Bubble";
    names[IDK] = "Idk";
    names[GUNPOWDER] = "Gun Powder";
    
    //1. Add code to initialize the data member grid with same dimensions
    grid = new int [numRows] [numCols];
    bounceUp = new boolean[numCols];
    twoByTwo = false;
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    
    //MAKE EVERYTHING GRASS
//    for(int row = 0; row < grid.length; row++)
//	  {
//		  for(int col = 0; col < grid[0].length; col++)
//		  {
//			  grid[row][col] = OIL;
//		  }
//	  }
  }
  
  //called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool)
  {
	  //2. Assign the values associated with the parameters to the grid
	  grid[row][col] = tool;
  }

  //copies each element of grid into the display
  public void updateDisplay()
  {
      //Step 3
	  Color sand = new Color(235, 194, 136);
	  Color water = new Color(97, 166, 171);
	  Color grass = new Color(141, 189, 12);
	  Color dirt = new Color(100, 48, 0);
	  Color fire = new Color(196, 35, 17);
	  Color steam = new Color(227, 227, 227);
	  Color oil = new Color(81, 28, 0);
	  Color bubble = new Color(127, 196, 201);
	  Color gunPowder = new Color(71, 74, 81);
	  //Hint - use a nested for loop
	  for(int row = 0; row < grid.length; row++)
	  {
		  for(int col = 0; col < grid[0].length; col++)
		  {
			  if(grid[row][col] == EMPTY)
			  {
				  display.setColor(row, col, Color.BLACK);
			  }
			  else if(grid[row][col] == METAL)
			  {
				  display.setColor(row, col, Color.GRAY);
			  }
			  else if(grid[row][col] == SAND)
			  {
				  display.setColor(row, col, sand);
			  }
			  else if(grid[row][col] == WATER)
			  {
				  display.setColor(row, col, water);
			  }
			  else if(grid[row][col] == GRASS)
			  {
				  display.setColor(row, col, grass);
			  }
			  else if(grid[row][col] == DIRT)
			  {
				  display.setColor(row, col, dirt);
			  }
			  else if(grid[row][col] == FIRE)
			  {
				  display.setColor(row, col, fire);
			  }
			  else if(grid[row][col] == STEAM)
			  {
				  display.setColor(row, col, steam);
			  }
			  else if(grid[row][col] == OIL)
			  {
				  display.setColor(row, col, oil);
			  }
			  else if(grid[row][col] == BOUNCE)
			  {
				  display.setColor(row, col, Color.magenta);
			  }
			  else if(grid[row][col] == BUBBLE)
			  {
				  display.setColor(row, col, bubble);
			  }
			  else if(grid[row][col] == IDK)
			  {
				  display.setColor(row, col, Color.PINK);
			  }
			  else if(grid[row][col] == GUNPOWDER)
			  {
				  display.setColor(row, col, gunPowder);
			  }
		  }
	  }
  }

  //Step 5,7
  //called repeatedly.
  //causes one random particle in grid to maybe do something.
  public void step()
  {
    //Remember, you need to access both row and column to specify a spot in the array
    //The scalar refers to how big the value could be
    //int someRandom = (int) (Math.random() * scalar)
    //remember that you need to watch for the edges of the array
    int randRow = (int) (Math.random() * (grid.length));
    int randCol = (int) (Math.random() * (grid[0].length));
    int randSide = (int) (Math.random() * 4);
    int randFire = (int) (Math.random() * 8);
    int randAlive = (int) (Math.random() * 4);
    int randWater = (int) (Math.random() * 128);
    int randBubble = (int) (Math.random() * 90000);
    
    //CLEAR
    if(grid[randRow][randCol] == CLEAR)
    {
    		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[0].length; col++)
			{
				grid[row][col] = EMPTY;
			}
		}
    }
    
    //BORDER
//    if(randRow == 0)
//    {
//    		grid[randRow][randCol] = METAL;
//    }
    if(randCol == 0)
    {
    		grid[randRow][randCol] = METAL;
    }
//    if(randRow == grid.length - 1)
//    {
//    		grid[randRow][randCol] = METAL;
//    }
    if(randCol == grid[0].length - 1)
    {
    		grid[randRow][randCol] = METAL;
    }
    
    //IDK
    if(grid[randRow][randCol] == IDK)
    {
    		if(randFire == 1 && randRow + 1 < grid.length && grid[randRow + 1][randCol] == EMPTY)
		{
			//grid[randRow][randCol] = EMPTY;
			grid[randRow + 1][randCol] = IDK;
		}
		else if(randFire == 2 && randCol - 1 > -1 && grid[randRow][randCol - 1] == EMPTY)
		{
			//grid[randRow][randCol] = EMPTY;
			grid[randRow][randCol - 1] = IDK;
		}
		else if(randFire == 3 && randCol + 1 < grid[0].length && grid[randRow][randCol + 1] == EMPTY)
		{
			//grid[randRow][randCol] = EMPTY;
			grid[randRow][randCol + 1] = IDK;
		}
		else if(randFire == 4 && randRow - 1 > -1 && grid[randRow - 1][randCol] == EMPTY)
		{
			//grid[randRow][randCol] = EMPTY;
			grid[randRow - 1][randCol] = IDK;
		}
    }
    
  //GUN POWDER
    if((randRow + 1 < grid.length) && grid[randRow][randCol] == GUNPOWDER && grid[randRow + 1][randCol] == EMPTY)
    {
    		grid[randRow][randCol] = EMPTY;
    		grid[randRow + 1][randCol] = GUNPOWDER;
    }
    else if((randRow + 1 < grid.length) && grid[randRow][randCol] == GUNPOWDER && grid[randRow + 1][randCol] == WATER)
    {
    		grid[randRow][randCol] = WATER;
    		grid[randRow + 1][randCol] = GUNPOWDER;
    }
    else if((randRow + 1 < grid.length) && grid[randRow][randCol] == GUNPOWDER && grid[randRow + 1][randCol] == OIL)
    {
    		grid[randRow][randCol] = OIL;
    		grid[randRow + 1][randCol] = GUNPOWDER;
    }
    
    if(grid[randRow][randCol] == GUNPOWDER)
	{
    		if(randRow - 1 > -1 
		&& randRow + 1 < grid[0].length 
		&& randCol + 1 < grid[0].length 
		&& randCol - 1 > -1  
		&& grid[randRow - 1][randCol] == FIRE 
		||
		randRow - 1 > -1 
		&& randRow + 1 < grid[0].length 
		&& randCol + 1 < grid[0].length 
		&& randCol - 1 > -1 
		&& grid[randRow - 1][randCol - 1] == FIRE 
		||
		randRow - 1 > -1 
		&& randRow + 1 < grid[0].length 
		&& randCol + 1 < grid[0].length 
		&& randCol - 1 > -1 
		&& grid[randRow - 1][randCol + 1] == FIRE 
		||
		randRow - 1 > -1 
		&& randRow + 1 < grid[0].length 
		&& randCol + 1 < grid[0].length 
		&& randCol - 1 > -1 
		&& grid[randRow + 1][randCol] == FIRE 
		||
		randRow - 1 > -1 
		&& randRow + 1 < grid[0].length 
		&& randCol + 1 < grid[0].length 
		&& randCol - 1 > -1
		&& grid[randRow + 1][randCol - 1] == FIRE 
		||
		randRow - 1 > -1 
		&& randRow + 1 < grid[0].length 
		&& randCol + 1 < grid[0].length 
		&& randCol - 1 > -1
		&& grid[randRow + 1][randCol + 1] == FIRE)
    		{
	    		if(randRow - 3 > -1)
	    		{
	    			grid[randRow - 3][randCol] = FIRE;
	    		}
	    		if(randRow - 3 > -1 && randCol - 2 > -1)
	    		{
	    			grid[randRow -3][randCol -2] = FIRE;
	    		}
	    		if(randRow - 3 > -1 && randCol - 1 > -1)
	    		{
	    			grid[randRow -3][randCol -1] = FIRE;
	    		}
	    		if(randRow -3 > -1 && randCol + 1 < grid.length)
	    		{
	    			grid[randRow -3][randCol + 1] = FIRE;
	    		}
	    		if(randRow -3 > -1 && randCol + 2 < grid.length)
	    		{
	    			grid[randRow -3][randCol + 2] = FIRE;
	    		}
	    		
	    		if(randRow + 3 < grid.length)
	    		{
	    			grid[randRow + 3][randCol] = FIRE;
	    		}
	    		if(randRow + 3 < grid.length && randCol - 2 > -1)
	    		{
	    			grid[randRow +3][randCol -2] = FIRE;
	    		}
	    		if(randRow + 3 < grid.length && randCol - 1 > -1)
	    		{
	    			grid[randRow +3][randCol -1] = FIRE;
	    		}
	    		if(randRow +3 < grid.length && randCol + 1 < grid.length)
	    		{
	    			grid[randRow +3][randCol + 1] = FIRE;
	    		}
	    		if(randRow +3 < grid.length && randCol + 2 < grid.length)
	    		{
	    			grid[randRow +3][randCol + 2] = FIRE;
	    		}
	    		
	    		if(randRow -2 > -1 && randCol + 3 < grid.length)
	    		{
	    			grid[randRow -2][randCol + 3] = FIRE;
	    		}
	    		if(randRow -1 > -1 && randCol + 3 < grid.length)
	    		{
	    			grid[randRow -1][randCol + 3] = FIRE;
	    		}
	    		if(randCol + 3 < grid.length)
	    		{
	    			grid[randRow][randCol + 3] = FIRE;
	    		}
	    		if(randRow +1 < grid.length && randCol + 3 < grid.length)
	    		{
	    			grid[randRow +1][randCol + 3] = FIRE;
	    		}
	    		if(randRow +2 < grid.length && randCol + 3 < grid.length)
	    		{
	    			grid[randRow +2][randCol + 3] = FIRE;
	    		}
	    		if(randRow - 2 > -1 && randCol - 3 > -1)
	    		{
	    			grid[randRow -2][randCol -3] = FIRE;
	    		}
	    		if(randRow -1 > -1 && randCol - 3 > -1)
	    		{
	    			grid[randRow -1][randCol - 3] = FIRE;
	    		}
	    		if(randCol - 3 > -1)
	    		{
	    			grid[randRow][randCol - 3] = FIRE;
	    		}
	    		if(randRow +1 < grid.length && randCol - 3 > -1)
	    		{
	    			grid[randRow +1][randCol - 3] = FIRE;
	    		}
	    		if(randRow +2 < grid.length && randCol - 3 > -1)
	    		{
	    			grid[randRow +2][randCol - 3] = FIRE;
	    		}
    		}
	}
    
    //BOUNCE
    if(grid[randRow][randCol] == BOUNCE)
    {
    		if(randRow + 1 >= grid[0].length)
    		{
    			bounceUp[randCol] = true;
    		}
    		if(randRow - 1 < 0)
    		{
    			bounceUp[randCol] = false;
    		}
    		
    		if(bounceUp[randCol] == true)
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow - 1][randCol] = BOUNCE;
    		}
    		else if(bounceUp[randCol] == false)
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow + 1][randCol] = BOUNCE;
    		}
    }
    
    //FIRE
    if(grid[randRow][randCol] == FIRE && (randRow + 1 >= grid.length))
	{
		grid[randRow][randCol] = EMPTY;
	}
    //Grass above fire
    if(randFire == 1 && randRow - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow - 1][randCol] == GRASS)
    	{
    		grid[randRow - 1][randCol] = FIRE;
    	}
    if(randFire == 5 && randCol - 1 > -1 && randRow - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow - 1][randCol - 1] == GRASS)
	{
		grid[randRow - 1][randCol - 1] = FIRE;
	}
    if(randFire == 6 && randCol + 1 < grid[0].length && randRow - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow - 1][randCol + 1] == GRASS)
	{
		grid[randRow - 1][randCol + 1] = FIRE;
	}
    
    //Grass to the left of fire
    if(randFire == 2 && randCol - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow][randCol - 1] == GRASS)
    {
		grid[randRow][randCol - 1] = FIRE;
    }
    
    //Grass to the right of fire
    if(randFire == 3 && randCol + 1 < grid[0].length && grid[randRow][randCol] == FIRE && grid[randRow][randCol + 1] == GRASS)
    {
		grid[randRow][randCol + 1] = FIRE;
    }
    
    //Grass below fire
    if((randFire == 4 && randRow + 1 < grid.length) && grid[randRow][randCol] == FIRE && grid[randRow + 1][randCol] == GRASS)
    {
		grid[randRow + 1][randCol] = FIRE;
    }
    if((randFire == 7 && randCol - 1 > -1 && randRow + 1 < grid.length) && grid[randRow][randCol] == FIRE && grid[randRow + 1][randCol - 1] == GRASS)
    {
		grid[randRow + 1][randCol - 1] = FIRE;
    }
    if((randFire == 8 && randCol + 1 < grid[0].length && randRow + 1 < grid.length) && grid[randRow][randCol] == FIRE && grid[randRow + 1][randCol + 1] == GRASS)
    {
		grid[randRow + 1][randCol + 1] = FIRE;
    }
    
  //Oil above fire
    if(randRow - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow - 1][randCol] == OIL)
    	{
    		grid[randRow - 1][randCol] = FIRE;
    	}
    if(randCol - 1 > -1 && randRow - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow - 1][randCol - 1] == OIL)
	{
		grid[randRow - 1][randCol - 1] = FIRE;
	}
    if(randCol + 1 < grid[0].length && randRow - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow - 1][randCol + 1] == OIL)
	{
		grid[randRow - 1][randCol + 1] = FIRE;
	}
    
    //Oil to the left of fire
    if(randCol - 1 > -1 && grid[randRow][randCol] == FIRE && grid[randRow][randCol - 1] == OIL)
    {
		grid[randRow][randCol - 1] = FIRE;
    }
    
    //Oil to the right of fire
    if(randCol + 1 < grid[0].length && grid[randRow][randCol] == FIRE && grid[randRow][randCol + 1] == OIL)
    {
		grid[randRow][randCol + 1] = FIRE;
    }
    
    //Oil below fire
    if((randRow + 1 < grid.length) && grid[randRow][randCol] == FIRE && grid[randRow + 1][randCol] == OIL)
    {
		grid[randRow + 1][randCol] = FIRE;
    }
    if((randCol - 1 > -1 && randRow + 1 < grid.length) && grid[randRow][randCol] == FIRE && grid[randRow + 1][randCol - 1] == OIL)
    {
		grid[randRow + 1][randCol - 1] = FIRE;
    }
    if((randCol + 1 < grid[0].length && randRow + 1 < grid.length) && grid[randRow][randCol] == FIRE && grid[randRow + 1][randCol + 1] == OIL)
    {
		grid[randRow + 1][randCol + 1] = FIRE;
    }
    
    //Empty around it
    if((randRow + 1 < grid.length) && grid[randRow][randCol] == FIRE && grid[randRow + 1][randCol] == EMPTY)
    {
    		if (randAlive == 1 && (randRow - 1 > -1) && grid[randRow - 1][randCol] == EMPTY)
    		{
    			grid[randRow][randCol] = EMPTY;
        		grid[randRow - 1][randCol] = FIRE;
    		}
    		else if (randAlive == 2)
    		{
    			grid[randRow][randCol] = EMPTY;
    		}
    		else if (randAlive == 3 && (randRow - 1 > -1) && grid[randRow - 1][randCol] == EMPTY && (randCol + 1 < grid[0].length))
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow - 1][randCol + 1] = FIRE;
    		}
    		else if (randAlive == 4 && (randRow - 1 > -1) && grid[randRow - 1][randCol] == EMPTY && (randCol - 1 > -1))
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow - 1][randCol - 1] = FIRE;
    		}
    }
    else if (grid[randRow][randCol] == FIRE)
    {
    		grid[randRow][randCol] = EMPTY;
    }
    
    
    //SAND
    if((randRow + 1 < grid.length) && grid[randRow][randCol] == SAND && grid[randRow + 1][randCol] == EMPTY)
    {
    		grid[randRow][randCol] = EMPTY;
    		grid[randRow + 1][randCol] = SAND;
    }
    else if((randRow + 1 < grid.length) && grid[randRow][randCol] == SAND && grid[randRow + 1][randCol] == WATER)
    {
    		grid[randRow][randCol] = WATER;
    		grid[randRow + 1][randCol] = SAND;
    }
    else if((randRow + 1 < grid.length) && grid[randRow][randCol] == SAND && grid[randRow + 1][randCol] == OIL)
    {
    		grid[randRow][randCol] = OIL;
    		grid[randRow + 1][randCol] = SAND;
    }
    
    //DIRT
    if((randRow + 1 < grid.length) && grid[randRow][randCol] == DIRT && grid[randRow + 1][randCol] == EMPTY)
    {
    		grid[randRow][randCol] = EMPTY;
    		grid[randRow + 1][randCol] = DIRT;
    }
    else if((randRow + 1 < grid.length) && grid[randRow][randCol] == DIRT && grid[randRow + 1][randCol] == WATER)
    {
    		grid[randRow][randCol] = WATER;
    		grid[randRow + 1][randCol] = DIRT;
    }
    else if((randRow + 1 < grid.length) && grid[randRow][randCol] == DIRT && grid[randRow + 1][randCol] == OIL)
    {
    		grid[randRow][randCol] = OIL;
    		grid[randRow + 1][randCol] = DIRT;
    }
    
    //STEAM
    if(grid[randRow][randCol] == STEAM && randCol - 1 > -1)
    {
	    	if(randSide == 1 && randRow - 1 > -1 && grid[randRow - 1][randCol] == EMPTY)
	    	{
	    		grid[randRow][randCol] = EMPTY;
	    		grid[randRow - 1][randCol] = STEAM;
	    	}
	    	else if(randSide == 2 && randCol - 1 > -1 && grid[randRow][randCol - 1] == EMPTY)
	    	{
	    		grid[randRow][randCol] = EMPTY;
	    		grid[randRow][randCol - 1] = STEAM;
	    	}
	    	else if(randSide == 3 && randCol + 1 < grid[0].length && grid[randRow][randCol + 1] == EMPTY)
	    	{
	    		grid[randRow][randCol] = EMPTY;
	    		grid[randRow][randCol + 1] = STEAM;
	    }
	    	else if(randRow - 1 > -1 
	    			&& randRow + 1 < grid[0].length 
	    			&& randCol + 1 < grid[0].length 
	    			&& randCol - 1 > -1 
	    			&& grid[randRow][randCol] == STEAM 
	    			&& grid[randRow - 1][randCol] == STEAM 
	    			&& grid[randRow - 1][randCol - 1] == STEAM 
	    			&& grid[randRow - 1][randCol + 1] == STEAM 
	    			&& grid[randRow + 1][randCol] == STEAM 
	    			&& grid[randRow + 1][randCol - 1] == STEAM 
	    			&& grid[randRow + 1][randCol + 1] == STEAM)
	    	{
	    		if(randWater == 1)
	    		{
	    			grid[randRow][randCol] = WATER;
	    		}
	    	}
	}
    
  //BUBBLE
    if(grid[randRow][randCol] == BUBBLE && randCol - 1 > -1)
    {
	    	if(randSide == 1 && randRow - 1 > -1 && grid[randRow - 1][randCol] == WATER)
	    	{
	    		grid[randRow][randCol] = WATER;
	    		grid[randRow - 1][randCol] = BUBBLE;
	    	}
	    	else if(randSide == 1 && randRow - 1 > -1 && grid[randRow - 1][randCol] == EMPTY)
	    	{
	    		grid[randRow][randCol] = EMPTY;
	    		if(randRow - 3 > -1)
	    		{
    			grid[randRow - 3][randCol] = WATER;
	    		}
    			if(randCol - 3 > -1)
    			{
    			grid[randRow - 2][randCol - 3] = WATER;
    			grid[randRow - 3][randCol - 2] = WATER;
    			}
    			if(randCol + 3 < grid.length)
    			{
    			grid[randRow - 2][randCol + 3] = WATER;
    			grid[randRow - 3][randCol + 2] = WATER;
    			}
    			if(randRow + 3 < grid[0].length && randCol + 2 < grid.length && randCol - 2 > -1)
    			{
	    			grid[randRow + 3][randCol] = EMPTY;
	    			grid[randRow + 3][randCol - 2] = EMPTY;
	    			grid[randRow + 3][randCol + 2] = EMPTY;
    			}
	    	}
	    	else if(randSide == 2 && randCol - 1 > -1 && grid[randRow][randCol - 1] == WATER)
	    	{
	    		grid[randRow][randCol] = WATER;
	    		grid[randRow][randCol - 1] = BUBBLE;
	    	}
	    	else if(randSide == 3 && randCol + 1 < grid[0].length && grid[randRow][randCol + 1] == WATER)
	    	{
	    		grid[randRow][randCol] = WATER;
	    		grid[randRow][randCol + 1] = BUBBLE;
	    }
	    	
	}
    
    //WATER
    if(grid[randRow][randCol] == WATER && randCol - 1 > -1)
    {
    		if(randSide == 1 && randRow + 1 < grid.length && grid[randRow + 1][randCol] == EMPTY)
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow + 1][randCol] = WATER;
    		}
    		else if(randSide == 2 && grid[randRow][randCol - 1] == EMPTY)
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow][randCol - 1] = WATER;
    		}
    		else if(randSide == 3 && randCol + 1 < grid[0].length && grid[randRow][randCol + 1] == EMPTY)
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow][randCol + 1] = WATER;
    		}
    		
    		//WATER SPAWNS BUBBLES
//    		else if(randRow - 1 > -1 
//	    			&& randRow + 1 < grid[0].length 
//	    			&& randCol + 1 < grid[0].length
//	    			&& randCol - 1 > -1
//	    			&& grid[randRow][randCol] == WATER 
//	    			&& grid[randRow - 1][randCol] == WATER 
//	    			&& grid[randRow - 1][randCol - 1] == WATER 
//	    			&& grid[randRow - 1][randCol + 1] == WATER 
//	    			&& grid[randRow + 1][randCol] == WATER 
//	    			&& grid[randRow + 1][randCol - 1] == WATER 
//	    			&& grid[randRow + 1][randCol + 1] == WATER)
//	    	{
//	    		if(randBubble == 1)
//	    		{
//	    			grid[randRow][randCol] = BUBBLE;
//	    		}
//	    	}
    		
    		if(randRow - 1 < -1 && grid[randRow - 1][randCol] == FIRE)
    		{
    			grid[randRow][randCol] = STEAM;
    		}
    		
    		else if(randRow + 1 < grid.length && randSide == 1 && grid[randRow + 1][randCol] == FIRE)
    		{
    			grid[randRow][randCol] = STEAM;
    			grid[randRow][randCol + 1] = EMPTY;
    		}
    		else if(randCol - 1 < grid[0].length && randSide == 2 && grid[randRow][randCol - 1] == FIRE)
    		{
    			grid[randRow][randCol] = STEAM;
    			grid[randRow][randCol + 1] = EMPTY;
    		}
    		else if(randCol + 1 < grid[0].length && randSide == 3 && grid[randRow][randCol + 1] == FIRE)
    		{
    			grid[randRow][randCol] = STEAM;
    			grid[randRow][randCol + 1] = EMPTY;
    		}
    		
    		if(randRow + 1 < grid.length && randSide == 1 && grid[randRow + 1][randCol] == OIL)
    		{
    			grid[randRow][randCol] = OIL;
    			grid[randRow + 1][randCol] = WATER;
    		}
    		else if(randCol - 1 < grid[0].length && randSide == 2 && grid[randRow][randCol - 1] == OIL)
    		{
    			grid[randRow][randCol] = OIL;
    			grid[randRow][randCol - 1] = WATER;
    		}
    		else if(randCol + 1 < grid[0].length && randSide == 3 && grid[randRow][randCol + 1] == OIL)
    		{
    			grid[randRow][randCol] = OIL;
    			grid[randRow][randCol + 1] = WATER;
    		}
    		
    		else if(randRow + 1 < grid.length && randSide == 1 && grid[randRow + 1][randCol] == DIRT)
    		{
    			grid[randRow][randCol] = GRASS;
    		}
    		else if(randCol - 1 < grid[0].length && randSide == 2 && grid[randRow][randCol - 1] == DIRT)
    		{
    			grid[randRow][randCol] = GRASS;
    		}
    		else if(randCol + 1 < grid[0].length && randSide == 3 && grid[randRow][randCol + 1] == DIRT)
    		{
    			grid[randRow][randCol] = GRASS;
    		}
    }
    
    //OIL
    if(grid[randRow][randCol] == OIL && randCol - 1 >= 0)
    {
    		if(randSide == 1 && randRow + 1 < grid.length && grid[randRow + 1][randCol] == EMPTY)
		{
			grid[randRow][randCol] = EMPTY;
			grid[randRow + 1][randCol] = OIL;
		}
		else if(randSide == 2 && randCol - 1 > -1 && grid[randRow][randCol - 1] == EMPTY)
		{
			grid[randRow][randCol] = EMPTY;
			grid[randRow][randCol - 1] = OIL;
		}
		else if(randSide == 3 && randCol + 1 < grid[0].length && grid[randRow][randCol + 1] == EMPTY)
		{
			grid[randRow][randCol] = EMPTY;
			grid[randRow][randCol + 1] = OIL;
		}
    }
  }
  
  //do not modify this method!
  public void run()
  {
    while (true) // infinite loop
    {
      for (int i = 0; i < display.getSpeed(); i++)
      {
        step();
      }
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
      {
    	  	locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
      }
    }
  }
}
