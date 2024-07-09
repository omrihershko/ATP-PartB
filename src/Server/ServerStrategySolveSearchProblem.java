package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerStrategySolveSearchProblem implements IServerStrategy {
    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            Maze maze = (Maze) fromClient.readObject();
            String mazeHash = String.valueOf(maze.hashCode());
            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            Path solutionFilePath = Paths.get(tempDirectoryPath, mazeHash);
            Solution solution;

            if (Files.exists(solutionFilePath)) {
                try (ObjectInputStream solutionReader = new ObjectInputStream(new FileInputStream(solutionFilePath.toFile()))) {
                    solution = (Solution) solutionReader.readObject();
                }
            } else {
                SearchableMaze searchableMaze = new SearchableMaze(maze);
                ISearchingAlgorithm searcher = new BreadthFirstSearch();
                solution = searcher.solve(searchableMaze);

                try (ObjectOutputStream solutionWriter = new ObjectOutputStream(new FileOutputStream(solutionFilePath.toFile()))) {
                    solutionWriter.writeObject(solution);
                }
            }

            toClient.writeObject(solution);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}