package algorithms.mazeGenerators;

import java.util.Random;
import java.util.Stack;

public class MyMazeGenerator extends AMazeGenerator {
    private int[][] Visited;

    @Override
    public Maze generate(int rows, int columns) {
        //Create a new Maze
        Maze maze = new Maze(rows, columns);
        //Set all cells as Walls
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                maze.setCell(i,j,1);
            }
        }
        //Generate the Maze Using the Iterative implementation of the Randomized DFS Algorithm
        generate_helper_iterative(maze);
        return maze;
    }

    private void generate_helper_iterative(Maze M)
    {
        //Get the Start and Goal Positions
        Position StartP = M.getStartPosition();
        Position GoalP = M.getGoalPosition();
        //Set the Start and Goal Positions as Empty Cells
        M.setCell(GoalP.getRowIndex(),GoalP.getColumnIndex(),0);
        //Create a Stack to store the visited Cells
        Stack <Position> stack = new Stack<Position>();
        //Create a 2D array to store the visited Cells
        Visited = new int[M.getRows()][M.getColumns()];
        //Set the Start Position as Visited
        Visited[StartP.getRowIndex()][StartP.getColumnIndex()]=1;
        //Push the Start Position to the Stack
        stack.push(StartP);
        Position CurrP = StartP;
        Position ChosenP =StartP;
        //Iterate until the Stack is Empty
        while(!stack.isEmpty())
        {
            //Pop the Current Position
           CurrP= stack.pop();
           //Get a Random Neighbor using the helper function getRandomNeighbor
           ChosenP = getRandomNeighbor(CurrP,M);
           //If the Neighbor Chosen is not null
           if(ChosenP!=null )
           {
               //Push the Current Position to the Stack
               stack.push(CurrP);
               //Remove the Wall between the Current Position and the Chosen Position
               //using the helper function RemoveWall
               RemoveWall(CurrP,ChosenP,M);
               //Set the Chosen Position as Visited
               Visited[ChosenP.getRowIndex()][ChosenP.getColumnIndex()]=1;
               //Push the Chosen Position to the Stack
                stack.push(ChosenP);
           }
        }
    }

    private void RemoveWall(Position P1,Position P2,Maze M)
    {
        //Remove the Wall between the two Positions
        M.setCell(P1.getRowIndex(),P1.getColumnIndex(),0);
        M.setCell(P2.getRowIndex(),P2.getColumnIndex(),0);
        //Set the Cell between the two Positions as Empty
        int row = (P1.getRowIndex()+P2.getRowIndex())/2;
        int col = (P1.getColumnIndex()+P2.getColumnIndex())/2;
        M.setCell(row,col,0);
    }
    private Position getRandomNeighbor(Position P ,Maze M)
    {
        //                   Right ,Left ,Down , Up
        int[][] directions = {{0,2},{0,-2},{2,0},{-2,0}};
        //Get a Random Direction
        Random rand= new Random();
        int random = rand.nextInt(4);
        for (int i = 0; i < 4; i++) {
            //Calculate the Neighbors Position by the random direction
            int row = P.getRowIndex()+directions[random][0];
            int col = P.getColumnIndex()+directions[random][1];
            //Check if the Neighbor is a valid Cell and not Visited
            if(M.CheckValidCell(row,col) && Visited[row][col]==0 )
            {
                return new Position(row,col);
            }
            //Change the Random Direction
            //Right -> Left -> Down -> Up
            //reaching here means that the last Neighbor we checked is not valid
            random=(random+1)%4;
        }
        //If no valid Neighbor is found return null
        return null;
    }

}

