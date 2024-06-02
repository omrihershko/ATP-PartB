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
        int max = Math.min(rows, columns);
        // Set the start and goal positions
        // Set the start position to be in the first row and a random column
        // Set the goal position to be in a random row and the last column
        maze_simple.setStartPosition(new Position(0, rand.nextInt(max) ));
        maze_simple.setGoalPosition(new Position(rand.nextInt(max) ,columns-1));
        return maze_simple;
    }
}
