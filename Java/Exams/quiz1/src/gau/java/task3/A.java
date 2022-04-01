package gau.java.task3;

import java.util.Random;
import java.util.Scanner;

public class A {

    /**
     * შეიტანეთ a და b მთელი რიცხვები, გამოიტანეთ [a; b] შუალედიდან 20 შემთხვევითი
     * რიცხვი (თუ a მეტია b-ზე, ამ ორი ცვლადის მნიშვნელობას გაუცვალეთ ადგილები).
     * დაადგინეთ რამდენი მარტივი რიცხვია გამოტანილ რიცხვებს შორის
     */
    public void method1(){
        int a, b, primeCounter = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        a = scanner.nextInt();
        b = scanner.nextInt();

        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(a, b);
            System.out.println(randomNumber);
            if(isPrime(randomNumber))
                primeCounter++;
        }

        System.out.println(primeCounter);
    }

    private boolean isPrime(int number){
        boolean isPrime = false;
        for (int i = 2; i < number / 2; i++) {
            if(number % i == 0){
                isPrime = true;
                break;
            }
        }

        return isPrime;
    }
}
