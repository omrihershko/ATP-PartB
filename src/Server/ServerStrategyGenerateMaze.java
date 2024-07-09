package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.*;

import java.io.*;


public class ServerStrategyGenerateMaze implements IServerStrategy {


    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            int [] maze_date=(int []) fromClient.readObject();

            Maze maze=new Maze(maze_date[0],maze_date[1]);

            MyCompressorOutputStream myCompressorOutputStream=new MyCompressorOutputStream(toClient);

            myCompressorOutputStream.write(maze.toByteArray());

            toClient.flush();

            myCompressorOutputStream.close();

            toClient.close();

            fromClient.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
