package algorithms.mazeGenerators;

public class Maze {
    private int[][] grid;
    private Position start ;
    private Position goal;

    public Maze(int rows, int columns) {
        grid = new int[rows][columns];
    }

    public void setCell(int row, int col, int value) {
        grid[row][col] = value;
    }

    public Position getStartPosition() {
        return start;
    }

    public void setStartPosition(Position start) {
        this.start = start;
    }

    public Position getGoalPosition() {
        return goal;
    }

    public void setGoalPosition(Position goal) {
        this.goal = goal;
    }

    public void print() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("Start Position: " + getStartPosition());
        System.out.println("Goal Position: " + getGoalPosition());
    }
}
