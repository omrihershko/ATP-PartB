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
//        int[][] directions = {{-1, 0}, {0, 1} ,{1, 0}, {0, -1} };// {-1, 1}, {-1, -1}, {1, 1}, {1, -1}}; // Including diagonals
        //check all directions and diagonals by clock way
        int row = pos.getRowIndex();
        int col = pos.getColumnIndex();
        //up
        if(maze.CheckValidCell(row-1 , col) && maze.getCell(row-1,col)==0)
        {
            MazeState up = (MazeState) states[row-1][col];
            up.setCost(10 + state.getCost());
            neighbors.add(up);
        }
        //right up
        //      ((up is valid                                 and up is 0 )               or            (right is valid                              and 0))              And        (right up is valid cell            and          0)
        if(((maze.CheckValidCell(row-1 , col) && maze.getCell(row-1 , col) ==0) || (maze.CheckValidCell(row , col+1) && maze.getCell(row , col+1)==0) )&&( maze.CheckValidCell(row-1 , col+1) && maze.getCell(row-1,col+1)==0))
        {
            MazeState rightUp = (MazeState) states[row-1][col+1];
            rightUp.setCost(15 + state.getCost());
            neighbors.add(rightUp);
        }
        //right
        if(maze.CheckValidCell(row , col+1) && maze.getCell(row,col+1)==0)
        {
            MazeState right = (MazeState) states[row][col+1];
            right.setCost(10 + state.getCost());
            neighbors.add(right);
        }
        //right down
        //      ((down is valid                                 and down is 0 )             or            (right is valid                              and 0))              And        (right down is valid cell            and          0)
        if((((maze.CheckValidCell(row+1 , col) && maze.getCell(row+1 , col) ==0) || (maze.CheckValidCell(row , col+1) ))&&( maze.getCell(row , col+1)==0) && maze.CheckValidCell(row+1 , col+1) && maze.getCell(row+1,col+1)==0))
        {
            MazeState rightUp = (MazeState) states[row+1][col+1];
            rightUp.setCost(15 + state.getCost());
            neighbors.add(rightUp);
        }
        //down
        if(maze.CheckValidCell(row+1 , col) && maze.getCell(row+1,col)==0)
        {
            MazeState down = (MazeState) states[row+1][col];
            down.setCost(10 + state.getCost());
            neighbors.add(down);
        }
        //left down
        //      ((down is valid                                 and down is 0 )             or            (left is valid                              and 0))              And        (left down is valid cell            and          0)
        if(((maze.CheckValidCell(row+1 , col) && maze.getCell(row+1 , col) ==0) || (maze.CheckValidCell(row , col-1) && maze.getCell(row , col-1)==0)) && (maze.CheckValidCell(row+1 , col-1) && maze.getCell(row+1,col-1)==0))
        {
            MazeState leftDown = (MazeState) states[row+1][col-1];
            leftDown.setCost(15 + state.getCost());
            neighbors.add(leftDown);
        }

        //left
        if(maze.CheckValidCell(row , col-1) && maze.getCell(row,col-1)==0)
        {
            MazeState left = (MazeState) states[row][col-1];
            left.setCost(10 + state.getCost());
            neighbors.add(left);
        }
        //left up
        //      ((up is valid                                 and up is 0 )               or            (left is valid                              and 0))              And        (left up is valid cell            and          0)
        if((((maze.CheckValidCell(row-1 , col) && maze.getCell(row-1 , col) ==0) || (maze.CheckValidCell(row , col-1) )&& maze.getCell(row , col-1)==0) &&( maze.CheckValidCell(row-1 , col-1) && maze.getCell(row-1,col-1)==0)))
        {
            MazeState leftUp = (MazeState) states[row-1][col-1];
            leftUp.setCost(15 + state.getCost());
            neighbors.add(leftUp);
        }

//        for (int[] d : directions)
//        {
//            int newRow = pos.getRowIndex() + d[0];
//            int newCol = pos.getColumnIndex() + d[1];
//            if (maze.CheckValidCell(newRow, newCol) && maze.getCell(newRow, newCol) == 0)
//            {
//                //
//                states[newRow][newCol].setCost(10 + states[pos.getRowIndex()][pos.getColumnIndex()].getCost());
//                neighbors.add(states[newRow][newCol]);
//                //Diagonals:
//
//                // Right Added , Check diagonals right up ------------------------------------------------------------------------------------------------------------------------------------------------------  Up Added - Check diagonals right up
//                if ((d[0] == 0 && d[1] == 1 && (maze.CheckValidCell(pos.getRowIndex() - 1, pos.getColumnIndex() + 1) && maze.getCell(pos.getRowIndex() - 1, pos.getColumnIndex() + 1) == 0)) || (d[0] == -1 && d[1] == 0 && (maze.CheckValidCell(pos.getRowIndex() - 1, pos.getColumnIndex() + 1) && maze.getCell(pos.getRowIndex() - 1, pos.getColumnIndex() - 1) == 0))) {
//                    //Add right up
//                    states[pos.getRowIndex() - 1][pos.getColumnIndex() + 1].setCost(15+ states[pos.getRowIndex()][pos.getColumnIndex()].getCost());
//                    neighbors.add(states[pos.getRowIndex() - 1][pos.getColumnIndex() + 1]);
//                }
//                //Right Added, Check diagonals right down ------------------------------------------------------------------------------------------------------------------------------------------------------  Down Added - Check diagonals right down
//                if ((d[0] == 0 && d[1] == 1 && (maze.CheckValidCell(pos.getRowIndex() + 1, pos.getColumnIndex() + 1) && maze.getCell(pos.getRowIndex() + 1, pos.getColumnIndex() + 1) == 0)) || (d[0] == 1 && d[1] == 0 && (maze.CheckValidCell(pos.getRowIndex() + 1, pos.getColumnIndex() + 1) && maze.getCell(pos.getRowIndex() + 1, pos.getColumnIndex() + 1) == 0))) {
//                    //Add right down
//                    states[pos.getRowIndex() + 1][pos.getColumnIndex() + 1].setCost(15+ states[pos.getRowIndex()][pos.getColumnIndex()].getCost());
//                    neighbors.add(states[pos.getRowIndex() + 1][pos.getColumnIndex() + 1]);
//                }
//                //Left Added , Check diagonals left down --------------------------------------------------------------------------------------------------------------------------------------------------------  Down Added - Check diagonals left down
//                if ((d[0] == 0 && d[1] == -1 && (maze.CheckValidCell(pos.getRowIndex() + 1, pos.getColumnIndex() - 1) && maze.getCell(pos.getRowIndex() + 1, pos.getColumnIndex() - 1) == 0)) || (d[0] == 1 && d[1] == 0 && (maze.CheckValidCell(pos.getRowIndex() + 1, pos.getColumnIndex() - 1) && maze.getCell(pos.getRowIndex() + 1, pos.getColumnIndex() - 1) == 0))) {
//                    //Add left down
//                    states[pos.getRowIndex() + 1][pos.getColumnIndex() - 1].setCost(15+ states[pos.getRowIndex()][pos.getColumnIndex()].getCost());
//                    neighbors.add(states[pos.getRowIndex() + 1][pos.getColumnIndex() - 1]);
//                }
//                //Left Added , Check diagonals left up ----------------------------------------------------------------------------------------------------------------------------------------------------------  Up Added - Check diagonals left up
//                if ((d[0] == 0 && d[1] == -1 && (maze.CheckValidCell(pos.getRowIndex() - 1, pos.getColumnIndex() - 1) && maze.getCell(pos.getRowIndex() - 1, pos.getColumnIndex() - 1) == 0)) || (d[0] == -1 && d[1] == 0 && (maze.CheckValidCell(pos.getRowIndex() - 1, pos.getColumnIndex() - 1) && maze.getCell(pos.getRowIndex() - 1, pos.getColumnIndex() - 1) == 0))) {
//                    //Add left up
//                    states[pos.getRowIndex() - 1][pos.getColumnIndex() - 1].setCost(15+ states[pos.getRowIndex()][pos.getColumnIndex()].getCost());
//                    neighbors.add(states[pos.getRowIndex() - 1][pos.getColumnIndex() - 1]);
//                }
//            }
//        }
        if(neighbors.size()==0)
        {
            return null;
        }
        return neighbors;
    }









}


