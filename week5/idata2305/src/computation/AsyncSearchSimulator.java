package computation;

import java.net.Socket;
import java.util.logging.Logger;

public class AsyncSearchSimulator implements Runnable {
  protected Socket clientSocket;

  private static final Logger logger = Logger.getLogger(AsyncSearchSimulator.class.getName());

  public AsyncSearchSimulator(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {
    try {
      SearchSimulator.processClientRequest(clientSocket, "Multithreaded");
    } catch (Exception e) {
      logger.severe("Error processing request: " + e.getMessage());
    }
  }

}
