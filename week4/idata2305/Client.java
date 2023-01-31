import java.net.*;
import java.io.*;

public class Client {
  public static void main(String[] args) {
    try {
      var sock = new Socket("127.0.0.1", 5000);
      var inStream = sock.getInputStream();
      var bufferedReader = new BufferedReader(new InputStreamReader(inStream));

      String line;

      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }

      sock.close();
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  } 
}
