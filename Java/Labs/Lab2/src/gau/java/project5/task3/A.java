package gau.java.project5.task3;

import java.util.Random;
import java.util.Scanner;

public class A {
    protected int x;
    protected int y;

    // შეაქვს x და y ცვლადებში მონაცემები კლავიატურიდან
    public void method1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x : ");
        this.x = scanner.nextInt();
        System.out.print("Enter y : ");
        this.y = scanner.nextInt();
    }

    //შეაქვს x და y ცვლადებში შემთხვევითი მონაცემები [12; 78] შუალედიდან
    public void method2(){
        Random random = new Random();
        this.x = random.nextInt(12, 78);
        this.y = random.nextInt(12, 78);
    }

    // ბეჭდავს y ცვლადის მნიშვნელობას
    public void method3(){
        System.out.println(this.y);
    }
}
