package gau.java.task3;

import java.util.Random;
import java.util.Scanner;

public class A {

    public static void method1(){
        int a, b, evenCounter = 0, oddCounter = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        a = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            int randNumber = random.nextInt(a, b);
            System.out.println(randNumber);
            if(randNumber % 2 == 1){
                oddCounter++;
            } else {
                evenCounter++;
            }
        }

        System.out.printf("Odds : %d\nEven : %d", oddCounter, evenCounter);
    }
}
