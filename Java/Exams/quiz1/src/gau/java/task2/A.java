package gau.java.task2;

import java.util.Random;

public class A {
    protected int x;

    /**
     * ბეჭდავს „Hello A Class“
     */
    public A() {
        System.out.println("Hello A Class");
    }

    /**
     * შეაქვს x ცვლადში შემთხვევითი მნიშვნელობა
     */
    public void method1(){
        Random random = new Random();
        this.x = random.nextInt();
    }

    /**
     * ბეჭდავს x-1
     */
    public void method2(){
        System.out.println(this.x - 1);
    }

    /**
     * ადგენს x მარტივია თუ შედგენილი
     */
    public boolean method3(){
        boolean isPrime = true;
        for (int i = 2; i < Math.sqrt(this.x); i++) {
            if(this.x % i == 0){
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
