package task2;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class B {

    /**
     * დაწერეთ პროგრამა, რომლის საშუალებითაც numbers.txt ფაილში ჩაიწერება
     * შემთხვევით n ცალი მთელი რიცხვი [-12; 23] შუალედიდან, n-ის შეტანა
     * მოახდინეთ კლავიატურიდან. წაიკითხეთ numberts.txt ფაილი და დაბეჭდეთ
     * რიცხვების ჯამი.
     */
    public static void method1() throws IOException {
        int n;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("numbers.txt")
        );
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            bufferedWriter.write(
                    String.format("%d\n", random.nextInt(-12, 23))
            );
        }

        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("numbers.txt")
        );

        String newLine;
        long sum = 0;
        while ((newLine = bufferedReader.readLine()) != null)
            sum += Integer.parseInt(newLine);

        System.out.println(sum);
    }
}
