package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;

public class Server {

    private  int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private ExecutorService threadPool;


    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
    }

    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept();

                    try {
                        strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
                        clientSocket.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } catch (SocketTimeoutException e){
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
