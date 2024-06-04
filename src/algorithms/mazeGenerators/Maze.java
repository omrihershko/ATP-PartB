package algorithms.mazeGenerators;

import java.util.Random;

public class Maze {
    private int[][] grid;
    private Position start ;
    private Position goal;

    public Maze(int rows, int columns)
    {
        grid = new int[rows][columns];
        Random rand = new Random();
        int max = Math.min(rows, columns);
        // Set the start and goal positions
        // Set the start position to be in the first row and a random column
        // Set the goal position to be in a random row and the last column
        int Sidesrand= rand.nextInt(4);
        int Linerand= rand.nextInt(max-1);

        //Set the start position randomly on the sides of the maze
        switch (Sidesrand)
        {
            case 0:
                //set in on the first row and a random column
                this.setStartPosition(new Position(0, Linerand));
                break;
            case 1:
                //set in on the first column and a random row
                this.setStartPosition(new Position(Linerand, 0));
                break;
            case 2:
                //set in on the last row and a random column
                this.setStartPosition(new Position(rows-1, Linerand));
                break;
            case 3:
                //set in on the last column and a random row
                this.setStartPosition(new Position(Linerand, columns-1));
                break;
        }
        //Set the goal position randomly on the sides of the maze
        Sidesrand= rand.nextInt(4);
        Linerand= rand.nextInt(max-1);
        switch (Sidesrand)
        {
            case 0:
                //set in on the first row and a random column
                this.setGoalPosition(new Position(0, Linerand));
                break;
            case 1:
                //set in on the first column and a random row
                this.setGoalPosition(new Position(Linerand, 0));
                break;
            case 2:
                //set in on the last row and a random column
                this.setGoalPosition(new Position(rows-1, Linerand));
                break;
            case 3:
                //set in on the last column and a random row
                this.setGoalPosition(new Position(Linerand, columns-1));
                break;
        }
    }

    public void setCell(int row, int col, int value)
    {
        // check if the cell is inside the maze
        // if it is, set the value of the cell
        // if not, do nothing
        if(CheckValidCell(row, col))
        {
            grid[row][col] = value;
        }
    }
    public int getCell(int row, int col)
    {
        // check if the cell is inside the maze
        // if it is, return the value of the cell
        // if not, return -1
        if(CheckValidCell(row, col))
        {
            return grid[row][col];
        }
        return -1;
}
    public int getRows()
    {
    return grid.length;
    }
    public int getColumns()
    {
        return grid[0].length;
    }
    public Position getStartPosition() {
        return this.start;
    }
public void MarkAsVisited(Position p)
{
    setCell(p.getRowIndex(),p.getColumnIndex(),0);
}
    public void setStartPosition(Position S) {
        // check if the position is on the edges of the maze
        // if it is, set the start position
        // if not, do nothing
        if(CheckValidEndStartPosition(S))
        {
            this.start = S;
//            this.grid[S.getRowIndex()][S.getColumnIndex()]=2;
        }
    }
    public Position getGoalPosition() {

        return goal;
    }

    public void setGoalPosition(Position G) {
        // check if the position is on the edges of the maze
        // if it is, set the goal position
        // if not, do nothing
        if(CheckValidEndStartPosition(G))
        {
            this.goal = G;
//            this.grid[G.getRowIndex()][G.getColumnIndex()]=9;
        }
    }
    public boolean CheckValidEndStartPosition(Position p)
    {
        // check if the position is on the edges of the maze
        // if it is, return true
        // if not, return false
        if((p.getRowIndex()== grid.length-1 ||p.getRowIndex()==0) && p.getColumnIndex() <= grid[0].length-1 || (p.getColumnIndex() == grid[0].length-1 ||p.getColumnIndex()==0)  &&p.getRowIndex()<= grid.length-1)
            return true;
        return false;
    }
    public boolean CheckValidCell(int row, int col)
    {
        // check if the cell is inside the maze
        // if it is, return true
        // if not, return false
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length)
            return true;
        return false;
    }
    public void print() {
        // print the maze

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }



}
