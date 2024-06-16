package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchableMaze implements ISearchable {
    Maze maze;
    MazeState startState;
    MazeState goalState;

    AState [][] states;


    public SearchableMaze(Maze maze) {
        this.maze = maze;
        states = new AState[maze.getRows()][maze.getColumns()];
        for(int i=0;i<maze.getRows();i++){
            for(int j=0;j<maze.getRows();j++){
                AState state=new MazeState(new Position(i,j));
                states[i][j]=state;
            }
        }

        startState=new MazeState(maze.getStartPosition());
        goalState=new MazeState(maze.getGoalPosition());
    }

public Maze getMaze() {
    return maze;
}


    @Override
    public AState getStartState() {
        return startState;
    }

    @Override
    public AState getGoalState() {
        return goalState;
    }

    public List<AState> getAllPossibleStates(AState s)
    {
        List<AState> neighbors = new ArrayList<>();
        MazeState state = (MazeState) s;
        Position pos = state.getCurrent();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};// {-1, 1}, {-1, -1}, {1, 1}, {1, -1}}; // Including diagonals
        for (int[] d : directions)
        {
            int newRow = pos.getRowIndex() + d[0];
            int newCol = pos.getColumnIndex() + d[1];
            if (maze.CheckValidCell(newRow, newCol) && maze.getCell(newRow, newCol) == 0)
            {
                neighbors.add(states[newRow][newCol]);

                //insert the diagonal neighbors
                // Right Up
//                if (maze.CheckValidCell(newRow-1, newCol+1) && maze.getGrid()[newRow-1][newCol+1]==0 && ((neighbors.contains(states[newRow - 1][newCol]) ||neighbors.contains(states[newRow - 1][newCol+1])) ))
//                    neighbors.add(states[newRow-1][newCol + 1]);
//                // Right Down
//                if (maze.CheckValidCell(newRow+1, newCol+1) && maze.getGrid()[newRow+1][newCol+1]==0 && ((neighbors.contains(states[newRow + 1][newCol]) ||neighbors.contains(states[newRow ][newCol+1])) ))
//                    neighbors.add(states[newRow+1][newCol + 1]);
//                // Left Up
//                if (maze.CheckValidCell(newRow-1, newCol-1) && maze.getGrid()[newRow-1][newCol-1]==0 && ((neighbors.contains(states[newRow - 1][newCol]) ||neighbors.contains(states[newRow ][newCol-1])) ))
//                    neighbors.add(states[newRow-1][newCol - 1]);
//                // Left Down
//                if (maze.CheckValidCell(newRow+1, newCol-1) && maze.getGrid()[newRow+1][newCol-1]==0 && ((neighbors.contains(states[newRow + 1][newCol]) ||neighbors.contains(states[newRow][newCol-1])) ))
//                    neighbors.add(states[newRow+1][newCol - 1]);

            }
        }
        if(neighbors.size()==0)
        {
            return null;
        }
        return neighbors;
    }









}


