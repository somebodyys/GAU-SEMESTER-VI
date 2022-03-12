package gau.java.project5.task1;

import java.util.Scanner;

public class B extends A{
    private int y;

    // შეაქვს y ცვლადში მონაცემი კლავიატურიდან
    public void method1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter y : ");
        this.y = scanner.nextInt();
    }

    // გვიბრუნებს  x+y გამოსახულების მნიშვნელობას
    public int childMethod2(){
        return this.x + this.y;
    }
}
