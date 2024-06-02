package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns)
    {
        if(rows < 1 || columns < 1)
            throw new IllegalArgumentException("Maze dimensions are too small");
         Maze maze_simple = new Maze(rows, columns);

        return maze_simple;
    }
}
