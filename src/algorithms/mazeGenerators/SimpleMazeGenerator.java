package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    // Generate a maze with random 1/0 values
    // The maze will have the given dimensions
    // The maze will have a start position in the first row and a random column
    // The maze will have a goal position in a random row and the last column
    // The maze will have a path from the start to the goal
    @Override
    public Maze generate(int rows, int columns)
    {
        Random rand = new Random();
        if (rows < 1 || columns < 1)
            throw new IllegalArgumentException("Maze dimensions are too small");
        // Create a new maze with the given dimensions
        Maze maze_simple = new Maze(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
            {
                // Set the value of the cell to random 1/0
                    int next = rand.nextInt(2);
                    maze_simple.setCell(i, j, next);
            }

        }
        int Si=maze_simple.getStartPosition().getRowIndex();
        int Sj=maze_simple.getStartPosition().getColumnIndex();
        int Gi=maze_simple.getGoalPosition().getRowIndex();
        int Gj=maze_simple.getGoalPosition().getColumnIndex();
        // Move the start position to the goal position


        return maze_simple;
        }



    }

