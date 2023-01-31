package computation;

import java.net.Socket;
import java.util.logging.Logger;

import utils.ResponseGenerator;

public class SearchSimulator {
  private static final Logger logger = Logger.getLogger(SearchSimulator.class.getName());

  private SearchSimulator() {}

  public static void processClientRequest(Socket socket, String serverType) throws Exception {
    long time1 = System.currentTimeMillis();
    logger.info("Request processing started at: " + time1);
    Thread.sleep(10_000); // 10 seconds
    long time2 = System.currentTimeMillis();
    logger.info("Request processing ended at: " + time2);

    var response = ResponseGenerator.generatorResponseHTML(time1, time2, serverType).getBytes();
    socket.getOutputStream().write(ResponseGenerator.generatorResponseHeader(response.length).getBytes());
    socket.getOutputStream().write(response);
    socket.close();
  }
}
