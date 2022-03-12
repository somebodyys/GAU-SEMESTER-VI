package gau.java.project5.task4;

import java.util.Random;
import java.util.Scanner;

public class B extends A{

    private int a;
    private int b;

    public void childMethod1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        this.a = scanner.nextInt();
        System.out.print("Enter b : ");
        this.b  = scanner.nextInt();
    }

    //თუ a მეტია b-ზე, მაშინ a-ს და b-ს გავუცვალოთ ადგილები
    public void childMethod2(){
        if(this.a > this.b){
            int temp = a;
            this.a = this.b;
            this.b = temp;
        }
    }

    // მიანიჭებს x შემთხვევით მნიშვნელობას [a, b] შუალედიდან
    public void childMethod3(){
        Random random = new Random();
        this.x = random.nextInt(this.a, this.b);
    }
}
