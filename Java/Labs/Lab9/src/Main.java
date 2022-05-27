import HDNE.Client;
import HDNE.Server;

public class Main {
    public static void main(String[] args) {
//        Client client = new Client();
//        Server server = new Server();
//        client.start();
//        server.start();

        Client client = new Client();
        Server server = new Server();
        client.start();
        server.start();
    }
}