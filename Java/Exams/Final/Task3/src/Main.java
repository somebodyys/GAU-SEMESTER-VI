import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            int number = 0;
            Scanner scanner = new Scanner(System.in);
            while(String.valueOf(number).length() != 2){
                System.out.print("Enter Two digits number : ");
                number = scanner.nextInt();
            }
            processNumber(number);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * დაწერეთ პროგრამა, რომელიც file.txt ფაილში ჩაწერს შეტანილი ორნიშნა რიცხვის
     * ციფრებით შედგენილ ნებისმიერ ერთნიშნა ან ორნიშნა რიცხვებს.
     */
    private static void processNumber(int number) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("file.txt", true)
        );

        String myNumber = String.valueOf(number);
        char[] split = myNumber.toCharArray();

        bufferedWriter.write(split[0] + "\n");
        bufferedWriter.write(split[1] + "\n");
        bufferedWriter.write("" + split[0] + split[1] + "\n");
        bufferedWriter.write("" + split[1] + split[0] + "\n");

        bufferedWriter.close();
    }
}