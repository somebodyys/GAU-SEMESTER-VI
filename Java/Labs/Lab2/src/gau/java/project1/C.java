package gau.java.project1;

import java.util.Scanner;

public class C {

    private int a;
    private int b;
    private int c;

    // ანიჭებს a, b და c ცვლადებს მნიშვნელობებს კლავიატურიდან.
    public void method1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        this.a = scanner.nextInt();
        System.out.print("Enter b : ");
        this.b = scanner.nextInt();
        System.out.print("Enter c : ");
        this.c = scanner.nextInt();
    }

    // აბრუნებს a-ს მნიშვნელობის ბოლო ციფრს.
    public int method2(){
        return this.a % 10;
    }

    // აბრუნებს b-ს მნიშვნელობის პირველ ციფრს.
    public int method3(){
        return this.b / (int)Math.pow(10, String.valueOf(this.b).length());
    }

    // აბრუნებს c-ს მნიშვნელობის ციფრთა ჯამს.
    public int method4(){
        int digitSum = 0;
        int temp = this.c;

        while(temp > 0){
            digitSum += temp % 10;
            temp /= 10;
        }

        return digitSum;
    }

    // ბეჭდავს მეთოდი 1-ის მნიშნველობისა და მეთოდი 2-ის მნიშვნელობის ნამრავლს.
    public void method5(){
        System.out.println(
                method2() * method3()
        );
    }

    // ბეჭდავს მეთოდი 3-ის მნიშნველობისა და მეთოდი 5-ის მნიშვნელობის ჯამს.
    public void method6(){
        System.out.println(
                method3() + method4()
        );
    }
}
