package gau.java.project1;

import java.util.Scanner;

public class A {
    private int a;
    private int b;

    //ანიჭებს a და b ცვლადებს მნიშვნელობებს კლავიატურიდან.
    public void method1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        this.a = scanner.nextInt();
        System.out.print("Enter b : ");
        this.b = scanner.nextInt();
    }

    //დაბეჭდოს ცვლადების ჯამი.
    public void method2(){
        System.out.printf("%d + %d = %d", a, b, a+b);
    }

    //დაგვიბრუნოს ცვლადების ნამრავლი.
    public int method3(){
        return a*b;
    }

}
