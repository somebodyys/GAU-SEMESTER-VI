package ChatSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread {
    private Socket socket;
    private ServerSocket serverSocket;
    private String message = "";

    public void run(){
        try {
            this.serverSocket = new ServerSocket(8080);

            while (true){
                this.socket = this.serverSocket.accept();
                this.receive();
                this.respond();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void receive() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        this.message = (String) objectInputStream.readObject();
        System.out.printf("%s -> %s\n", "Server", this.message);
    }
    private void respond() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        System.out.print("Response : ");
        Scanner scanner = new Scanner(System.in);
        this.message = scanner.nextLine();
        objectOutputStream.writeObject(this.message);
    }
}
