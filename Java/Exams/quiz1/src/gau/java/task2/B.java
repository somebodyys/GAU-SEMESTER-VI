package gau.java.task2;

import java.util.Scanner;

public class B extends A{

    protected int y;

    /**
     * ანიჭებს x და y ცვლადებს მნიშვნელობებს
     */
    public B(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * შეაქვს y ცვლადში მონაცემი კლავიატურიდან
     */
    public void childMethod1(){
        Scanner scanner = new Scanner(System.in);
        this.y = scanner.nextInt();
    }

    /**
     * აბრუნებს x+2y გამოსახულების მნიშვნელობას
     */
    public long childMethod2(){
        return 2L * this.y + this.x;
    }
}
