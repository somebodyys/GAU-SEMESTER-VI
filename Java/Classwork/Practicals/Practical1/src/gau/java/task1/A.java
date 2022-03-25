package gau.java.task1;

import java.util.Scanner;

public class A {
    protected int number1;
    protected int number2;

    // ანიჭებს ცვლადებს მნიშვნელობებს კლავიატურიდან
    public void method1(){
        Scanner scanner = new Scanner(System.in);
        this.number1 = scanner.nextInt();
        this.number2 = scanner.nextInt();
    }

    // აბრუნებს პირველი ცლადის მნიშვნელობის ბოლო ციფრს
    public int method2(){
        return number1 % 10;
    }

    // აბრუნებს მეორე ცვლადის მნიშვნელობის პირველ ციფრს
    public int method3(){
        return this.number2 / (int)Math.pow(10, String.valueOf(this.number2).length());
    }
}
