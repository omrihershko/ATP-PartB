package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {



//ADDED BY ME
    // ADDED BY OMRI
    // ARE YOU SEE IT ??
    @Override
    public Maze generate(int rows, int columns) {
         Maze maze_simple = new Maze(0, 0);
        return maze_simple;
    }
}
