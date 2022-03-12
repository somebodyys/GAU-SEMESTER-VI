package gau.java.project5.task1;

import java.util.Scanner;

public class A {
    protected int x;

    public A() {
        System.out.println("Hello My A Class");
    }

    //შეაქვს x ცვლადში მონაცემი კლავიატურიდან
    public void method1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x : ");
        this.x = scanner.nextInt();
    }

    //ბეჭდავს x ცვლადის მნიშვნელობას
    public void method2(){
        System.out.printf("x = %d", this.x);
    }

    public String method3(){
        return this.x % 2 == 1 ? "Odd" : "Even";
    }
}
