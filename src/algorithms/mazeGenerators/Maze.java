package algorithms.mazeGenerators;

public class Maze {
    private int[][] grid;
    private Position start ;
    private Position goal;

    public Maze(int rows, int columns) {
        grid = new int[rows][columns];
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

    public Position getStartPosition() {
        return this.start;
    }

    public void setStartPosition(Position S) {
        // check if the position is on the edges of the maze
        // if it is, set the start position
        // if not, do nothing
        if(CheckValidEndStartPosition(S))
        {
            this.start = S;
            this.grid[S.getRowIndex()][S.getColumnIndex()]=2;
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
            this.grid[G.getRowIndex()][G.getColumnIndex()]=9;
        }
    }
    private boolean CheckValidEndStartPosition(Position p)
    {
        // check if the position is on the edges of the maze
        // if it is, return true
        // if not, return false
        if((p.getRowIndex()== grid.length-1 ||p.getRowIndex()==0) && p.getColumnIndex() <= grid[0].length-1 || (p.getColumnIndex() == grid[0].length-1 ||p.getColumnIndex()==0)  &&p.getRowIndex()<= grid.length-1)
            return true;
        return false;

    }
    private boolean CheckValidCell(int row, int col)
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
