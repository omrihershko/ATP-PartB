package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {


    @Override
    public Maze generate(int rows, int columns) {
         Maze maze_simple = new Maze(0, 0);
        return maze_simple;
    }
}
