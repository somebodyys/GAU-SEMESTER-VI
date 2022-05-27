package ChatSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends Thread {
    private Socket socket;
    private String message = "";
    private String clientIP = "localhost";
    private Scanner scanner;

    public void run(){
        try {
            clientSetup();

            while (true){
                send();
                receive();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void clientSetup() throws IOException {
        System.out.print("Client IP : ");
        this.scanner = new Scanner(System.in);
        this.clientIP = scanner.nextLine();
        this.socket = new Socket(
                InetAddress.getByName(this.clientIP), 8080
        );
    }
    private void send() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        scanner = new Scanner(System.in);
        System.out.print("Message : ");
        this.message = scanner.nextLine();
        objectOutputStream.writeObject(this.message);
    }
    private void receive() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        this.message = (String) objectInputStream.readObject();
        System.out.printf("%s -> %s\n", "Client", this.message);
    }
}
