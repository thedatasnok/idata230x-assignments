import booking.MovieTicketClient;
import booking.MovieTicketServer;

public class Main {
  public static void main(String[] args) {
    try {
      System.out.println("===== Synchronized =====");
      Main.run(true);

      Thread.sleep(1000); // ensures threads are finished before continuing with the next test

      System.out.println("===== Unsynchronized =====");
      Main.run(false);
    } catch (Exception e) {
      System.err.println("Well... that didn't go as planned.");
      e.printStackTrace();
    }
  }

  public static void run(boolean runSynchronized) {
    var ticketServer = new MovieTicketServer("Avengers", 10, runSynchronized);

    var thread1 = new MovieTicketClient(ticketServer, "John", 3);
    var thread2 = new MovieTicketClient(ticketServer, "Mary", 2);
    var thread3 = new MovieTicketClient(ticketServer, "Peter", 3);
    var thread4 = new MovieTicketClient(ticketServer, "Jane", 4);

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }
}
