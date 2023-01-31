import java.net.*;
import java.io.*;
import java.util.Date;

public class Server {
  public static void main(String[] args) {
    try (ServerSocket socket = new ServerSocket(5000)) {
      while (true) {
        var client = socket.accept();
        var pout = new PrintWriter(client.getOutputStream(), true);
        var dateString = new Date().toString();
        System.out.println(dateString);
        pout.println(dateString);
        client.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}
