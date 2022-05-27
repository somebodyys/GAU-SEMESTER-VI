package HDNE;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    private Socket socket;
    private ActionHandler actionHandler;
    private String clientIP = "localhost";
    private Scanner scanner;

    public void run(){
        try {
            while (true){
                clientSetup();
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
                InetAddress.getByName(this.clientIP), 8081
        );
    }
    private void send() throws IOException {
        String action, message;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        scanner = new Scanner(System.in);
        System.out.print("Action : ");
        action = scanner.nextLine();
        System.out.print("Message : ");
        message = scanner.nextLine();
        this.actionHandler = new ActionHandler(action, message);
        objectOutputStream.writeObject(this.actionHandler);
    }
    private void receive() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        String status = (String) objectInputStream.readObject();
        System.out.printf("%s -> %s\n", "Client", status);
    }
}
