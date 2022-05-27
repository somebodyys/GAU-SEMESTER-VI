package HDNE;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private Socket socket;
    private ServerSocket serverSocket;

    public void run(){
        try {
            this.serverSocket = new ServerSocket(8081);

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
        ActionHandler actionHandler = (ActionHandler) objectInputStream.readObject();
        actionHandler.save();
    }
    private void respond() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        objectOutputStream.writeObject("Saved!");
    }
}
