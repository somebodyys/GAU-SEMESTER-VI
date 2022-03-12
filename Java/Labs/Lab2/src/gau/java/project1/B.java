package gau.java.project1;

import java.util.Scanner;

public class B {

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

    // ბეჭდავს ცვლადებს შორის მაქსიმალურს.
    public void method2(){
        int max = this.a;
        if(this.b > max) max = this.b;
        if(this.c > max) max = this.c;

        System.out.println(max);
    }

    // გვიბრუნებს ცვლადებს შორის მინიმალურს.
    public int method3(){
        int min = this.a;
        if(this.b < min) min = this.b;
        if(this.c < min) min = this.c;

        return min;
    }
}
