import ChatSocket.Client;
import ChatSocket.Server;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Server server = new Server();
        client.start();
        server.start();
    }
}