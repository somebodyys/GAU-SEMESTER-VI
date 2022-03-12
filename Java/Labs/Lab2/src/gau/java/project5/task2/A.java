package gau.java.project5.task2;

import java.util.Scanner;

public class A {

    protected int x;
    protected int y;

    public void method1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x : ");
        this.x = scanner.nextInt();
        System.out.print("Enter y : ");
        this.y = scanner.nextInt();
    }

    public void method2(){
        System.out.println(this.x);
    }

    public void method3(){
        System.out.println(this.y);
    }
}
