package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SearchableMaze implements ISearchable {
    Maze maze;
    MazeState startState;
    MazeState goalState;


    public SearchableMaze(Maze maze) {
        this.maze = maze;

    }



    @Override
    public AState getStartState() {
        return startState;
    }

    @Override
    public AState getGoalState() {
        return goalState;
    }

    @Override
    public List<AState> getAllPossibleStates(AState s) {
        return null;
    }






}


