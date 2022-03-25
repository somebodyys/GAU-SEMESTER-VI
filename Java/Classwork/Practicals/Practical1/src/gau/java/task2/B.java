package gau.java.task2;

import java.util.Scanner;

public class B extends A{

    protected int y;

    public B(int x) {
        super(x);
    }

    // ანიჭებს x და y ცვლადებს მნიშვნელობებს კლავიატურიდან
    public void childMethod1(){
        Scanner scanner = new Scanner(System.in);
        this.x = scanner.nextInt();
        this.y = scanner.nextInt();
    }

    // აბრუნებს x და y-ის ჯამს
    public int childMethod2(){
        return this.x + this.y;
    }
}
