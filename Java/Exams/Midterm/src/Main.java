import task3.PrimaryNumber;
import task3.SubtractNumber;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //  შექმენით SubtractNumber ტიპის ორი ობიექტი. ორივე ობიექტს გადაეცით
        //  PrimaryNumber-ის ერთი ობიექტი.
        SubtractNumber objectOne = new SubtractNumber(
                new PrimaryNumber()
        );

        SubtractNumber objectTwo = new SubtractNumber(
                new PrimaryNumber()
        );

        // ობიექტები გაუშვით ცალ-ცალკე ნაკადში
        Thread threadOne = new Thread(objectOne);
        Thread threadTwo = new Thread(objectTwo);

        threadOne.start();
        threadTwo.start();
    }
}