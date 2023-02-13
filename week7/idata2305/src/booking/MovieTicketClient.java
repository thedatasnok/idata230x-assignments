package booking;

public class MovieTicketClient extends Thread {
  private MovieTicketServer ticketServer;
  private String customerName;
  private int tickets;

  public MovieTicketClient(MovieTicketServer ticketServer, String customerName, int tickets) {
    this.ticketServer = ticketServer;
    this.customerName = customerName;
    this.tickets = tickets;
  }

  @Override
  public void run() {
    this.ticketServer.bookTicket(this.customerName, this.tickets);
  }
}
