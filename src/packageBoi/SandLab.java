package packageBoi;

import java.awt.*;
import java.util.*;

public class SandLab
{
  //Step 4,6
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int GRASS = 4;
  public static final int DIRT = 5;
  public static final int FIRE = 6;
  
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
    names = new String[7];
    // Each value needs a name for the button
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[GRASS] = "Grass";
    names[DIRT] = "Dirt";
    names[FIRE] = "Fire";
    
    //1. Add code to initialize the data member grid with same dimensions
    grid = new int [numRows] [numCols];
    
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    for(int row = 0; row < grid.length; row++)
	  {
		  for(int col = 0; col < grid[0].length; col++)
		  {
			  grid[row][col] = GRASS;
		  }
	  }
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
    int randSide = (int) (Math.random() * 3);
    int randFire = (int) (Math.random() * 8);
    int randAlive = (int) (Math.random() * 4);
    
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
    
    if(grid[randRow][randCol] == WATER && randCol - 1 >= 0)
    {
    		if(randRow + 1 < grid.length && randSide == 1 && grid[randRow + 1][randCol] == EMPTY)
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow + 1][randCol] = WATER;
    		}
    		else if(randCol - 1 < grid[0].length && randSide == 2 && grid[randRow][randCol - 1] == EMPTY)
    		{
    			grid[randRow][randCol] = EMPTY;
    			grid[randRow][randCol - 1] = WATER;
    		}
    		else if(randCol + 1 < grid[0].length && grid[randRow][randCol + 1] == EMPTY)
    		{
    			grid[randRow][randCol] = EMPTY;
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
    		else if(randCol + 1 < grid[0].length && grid[randRow][randCol + 1] == DIRT)
    		{
    			grid[randRow][randCol] = GRASS;
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
