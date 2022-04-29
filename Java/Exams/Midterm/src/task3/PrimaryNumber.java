package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PrimaryNumber {
    private int number;

    /**
     * მინიჭება
     */
    public void setNumber(int number) throws IOException {
        this.number = number;
        this.save();
    }

    /**
     * მიღება
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * დაწერეთ მეთოდი, რომელიც number ცლადს მიანიჭებს შემთხვევით
     * მნიშვნელობას [100; 200] შუალედიდან;
     */
    public void method1() throws IOException {
        Random random = new Random();
        this.setNumber(
                random.nextInt(100, 200)
        );
    }

    /**
     * დაწერეთ მეთოდი, რომელიც შეინახავს number ცვლადის მნიშვნელობას
     * number.txt ფაილში მისი ყოველი ცვლილებისას.
     */
    private void save() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("number.txt", true)
        );
        bufferedWriter.write(
                String.format("%d\n", this.number)
        );
        bufferedWriter.close();
    }
}
