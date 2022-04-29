package midterm_examples.task1;

import java.util.Random;
import java.util.Scanner;

interface myInterface{
    void method1();
}

public class A implements myInterface {
    protected int[] m = new int[15];

    /**
     * ანიჭებს m მასივის ელემენტებს შემთხვევით მნიშვნელობებს [a; b]
     * შუალედუდან, a და b-ს მნიშვნელობების შეტანა ხდება კლავიატურიდან;
     */
    @Override
    public void method1() {
        int a, b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        Random random = new Random();

        for (int i = 0; i < this.m.length; i++) {
            this.m[i] = random.nextInt(a, b);
        }
    }

    /**
     * აბრუნებს მასივის იმ ელემენტების მნიშვნელობათა ჯამს, რომლის
     * მნიშვნელობა თავის ინდექსზე ნაკლებია;
     */
    public long method2(){
        long sum = 0;

        for (int i = 0; i < this.m.length; i++) {
            if(this.m[i] < i)
                sum += this.m[i];
        }

        return sum;
    }

    /**
     * აბრუნებს მასივის იმ ელემენტების ინდექსების ნამრავლს, რომლის
     * მნიშვნელობა თავის ინდექსზე მეტია;
     */
    public long method3(){
        long multiply = 1;

        for (int i = 0; i < this.m.length; i++) {
            if(this.m[i] > i)
                multiply *= i;
        }

        return multiply;
    }

    /**
     * ბეჭდავს მასივში არსებულ ლუწ რიცხვებს.
     */
    public void method4(){
        for (int j : this.m) {
            if (j % 2 == 0)
                System.out.printf("%d\t", j);
        }
    }
}
