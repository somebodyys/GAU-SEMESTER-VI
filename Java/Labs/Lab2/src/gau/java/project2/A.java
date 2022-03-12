package gau.java.project2;

import java.util.Random;
import java.util.Scanner;

public class A {

    private final int[] m = new int[10];

    // ანიჭებს m მასივის ელემენტებს მნიშვნელობებს კლავიატურიდან.
    public void method1(){
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.printf("m[%d] = ", i);
            this.m[i] = scanner.nextInt();
        }
    }

    //ანიჭებს m მასივის ელემენტებს შემთხვევით მნიშვნელობებს [0; 15] შუალედუდან.
    public void method2(){
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            this.m[i] = random.nextInt(15);
        }
    }

    // გვიბრუნებს იმ ელემენტების მნიშვნელობათა ჯამს, რომლის მნიშვნელობა თავის ინდექსზე ნაკლებია.
    public int method3(){
        int result = 0;

        for (int i = 0; i < 10; i++) {
            if(this.m[i] < i) result += this.m[i];
        }

        return result;
    }

    // გვიბრუნებს იმ ელემენტების ინდექსების ნამრავლს, რომლის მნიშვნელობა თავის ინდექსზე მეტია.
    public int method4(){
        int result = 1;

        for (int i = 0; i < 10; i++) {
            if(this.m[i] > i) result *= i;
        }

        return result;
    }
}
