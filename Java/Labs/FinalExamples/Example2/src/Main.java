import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int inputNumber;
        Scanner scanner = new Scanner(System.in);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter("file.txt", true)
            );
            System.out.print("Enter Number : ");
            inputNumber = scanner.nextInt();

            for (int i = 0; i < inputNumber; i++) {
                if (containsDigit(i, '5')){
                    bufferedWriter.write(String.format("%d \n", i));
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean containsDigit(int number, char digit){
        String casted = String.valueOf(number);
        for (char singleDigit : casted.toCharArray()) {
            if(singleDigit == digit)
                return true;
        }

        return false;
    }
}