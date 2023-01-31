package utils;

public class ResponseGenerator {
  private ResponseGenerator() {}
  
  public static String generatorResponseHTML(long time1, long time2, String serverType) {
    return ("<html><body>" +
        serverType + " Server: " +
        time1 + " - " + time2 +
        "</body></html>");
  }

  public static String generatorResponseHeader(int contentLength) {
    return ("HTTP/1.1 200 OK\r\n" +
        "Content-Type: text/html; charset=UTF-8\r\n" +
        "Content-Length: " + contentLength +
        "\r\n\r\n");
  }
}