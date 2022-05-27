package HDNE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class ActionHandler implements Serializable {

    private String action;
    private String message = "";

    public ActionHandler(String action, String message) {
        this.action = action;
        this.message = message;
    }

    public void save() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("index.txt", true)
        );
        bufferedWriter.write(String.format("%s\n%s\n----\n", this.action, this.message));
        bufferedWriter.close();
    }
}
