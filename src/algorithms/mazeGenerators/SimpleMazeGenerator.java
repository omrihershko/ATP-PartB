package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int columns) {
        Random rand = new Random();
        if(rows < 1 || columns < 1)
            throw new IllegalArgumentException("Maze dimensions are too small");
        // Create a new maze with the given dimensions
        Maze maze_simple = new Maze(rows, columns);
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                // Set the value of the cell to random 1/0
                maze_simple.setCell(i, j, rand.nextInt(2));
            }
        }
        return maze_simple;
    }
}
