import servers.MultiThreadedServer;
import servers.SingleThreadedServer;

public class Main {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Usage: java -cp ./out Main <server-type>");
      System.exit(1);
    }

    var serverType = ServerTypeDiscriminator.fromString(args[0]);

    var server = switch (serverType) {
      case SINGLE_THREADED -> new SingleThreadedServer(8080);
      case MULTI_THREADED -> new MultiThreadedServer(8080);
    };

    new Thread(server).start();
  }
}

enum ServerTypeDiscriminator {
  SINGLE_THREADED("single"),
  MULTI_THREADED("multi");

  private String discriminator;

  ServerTypeDiscriminator(String discriminator) {
    this.discriminator = discriminator;
  }

  public String getDiscriminator() {
    return this.discriminator;
  }

  public static ServerTypeDiscriminator fromString(String discriminator) {
    for (ServerTypeDiscriminator serverType : ServerTypeDiscriminator.values()) {
      if (serverType.getDiscriminator().equals(discriminator)) {
        return serverType;
      }
    }

    throw new IllegalArgumentException("Invalid server type discriminator: " + discriminator);
  }
}
