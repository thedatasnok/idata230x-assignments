package servers;

import java.net.ServerSocket;
import java.util.logging.Logger;

import computation.AsyncSearchSimulator;

public class MultiThreadedServer implements Runnable {
  protected int serverPort;
  protected ServerSocket serverSocket;
  protected boolean isStopped;

  private static final Logger logger = Logger.getLogger(MultiThreadedServer.class.getName());

  public MultiThreadedServer(int port) {
    this.serverPort = port;
    this.isStopped = false;
  }

  @Override
  public void run() {
    openServerSocket();

    while (!isStopped()) {
      
      try {
        var clientSocket = this.serverSocket.accept();
        
        new Thread(
          new AsyncSearchSimulator(
            clientSocket, 
            "Multithreaded Server"
          )
        ).start();

      } catch (Exception e) {
        logger.severe("Error accepting connection: " + e.getMessage());
      }
    }

    logger.info("Server stopped.");
  }

  private synchronized boolean isStopped() {
    return this.isStopped;
  }

  public synchronized void stop() {
    this.isStopped = true;
  }

  private void openServerSocket() {
    try {
      this.serverSocket = new ServerSocket(this.serverPort);
    } catch (Exception e) {
      logger.severe("Error opening server socket: " + e.getMessage());
      this.isStopped = true;
    }
  }
}