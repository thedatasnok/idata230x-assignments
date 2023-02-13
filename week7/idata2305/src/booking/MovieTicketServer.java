package booking;

public class MovieTicketServer {
  private String movieName;
  private int availableSeats;
  private boolean runSynchronized;

  public MovieTicketServer(String movieName, int seats, boolean runSynchronized) {
    this.movieName = movieName;
    this.availableSeats = seats;
    this.runSynchronized = runSynchronized;
  }

  /**
   * Books tickets for a customer.
   * 
   * @param customerName name of the customer
   * @param numberOfSeats number of seats to book
   */
  public void bookTicket(String customerName, int numberOfSeats) {
    if (this.runSynchronized) {
      this.bookTicketSynchronized(customerName, numberOfSeats);
    } else {
      this.bookTicketUnsynchronized(customerName, numberOfSeats);
    }
  }

  /**
   * Wraps the unsynchronized method in a synchronized block.
   */
  private synchronized void bookTicketSynchronized(String customerName, int numberOfSeats) {
    this.bookTicketUnsynchronized(customerName, numberOfSeats);
  }

  /**
   * Unsynchronized method that books tickets.
   * 
   * @param customerName name of the customer
   * @param numberOfSeats number of seats to book 
   */
  private void bookTicketUnsynchronized(String customerName, int numberOfSeats) {
    System.out.println("Hi, " + customerName + " : " + availableSeats + " seats available for " + movieName);

    if ((this.availableSeats - numberOfSeats) < 0) {
      System.out.println("Hi, " + customerName + " : Not enough seats available for " + movieName);
      return;
    }
    
    System.out.println("Hi, " + customerName + " : "  + numberOfSeats + " Seats booked succesfully for " + movieName);

    this.availableSeats -= numberOfSeats;
  }
}