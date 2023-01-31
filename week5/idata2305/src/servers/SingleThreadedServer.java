package servers;

import java.net.ServerSocket;
import java.util.logging.Logger;

import computation.SearchSimulator;

public class SingleThreadedServer implements Runnable {
  protected int serverPort = 8080;
  protected ServerSocket serverSocket;
  protected boolean isStopped = false;

  private static final Logger logger = Logger.getLogger(SingleThreadedServer.class.getName());

  public SingleThreadedServer(int port) {
    this.serverPort = port;
  }

  @Override
  public void run() {
    openServerSocket();

    while (!isStopped()) {
      try {
        var clientSocket = this.serverSocket.accept();
        SearchSimulator.processClientRequest(clientSocket, "Single threaded");
      } catch (Exception e) {
        logger.severe("Error accepting connection: " + e.getMessage());
      }
    }

    logger.info("Server Stopped.");
  }

  private synchronized boolean isStopped() {
    return this.isStopped;
  }

  public synchronized void stop() {
    try {
      this.serverSocket.close();
    } catch (Exception e) {
      logger.severe("Error closing server socket: " + e.getMessage());
    }

    System.exit(0);
  }

  private void openServerSocket() {
    try {
      this.serverSocket = new ServerSocket(this.serverPort);
    } catch (Exception e) {
      this.isStopped = true;
    }
  }
}
