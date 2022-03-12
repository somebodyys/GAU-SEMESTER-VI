package gau.java.project2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class B {

    private final double[] m = new double[12];

    // ანიჭებს m მასივის ელემენტებს მნიშვნელობებს კლავიატურიდან.
    public void method1(){
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 12; i++) {
            System.out.printf("m[%d] = ", i);
            this.m[i] = scanner.nextDouble();
        }
    }

    // ანიჭებს m მასივის ელემენტებს შემთხვევით მნიშვნელობებს [0; 15] შუალედუდან.
    public void method2(){
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            this.m[i] = random.nextDouble(15);
        }
    }

    /*
    ბეჭდავს მასივის იმ ელემენტების მნიშვნელობებს შესაბამისი
    ინდექსებით, რომელთა მნიშვნელობებიც მეტია 7-ზე.
     */
    public void method3(){
        for (int i = 0; i < 12; i++) {
            if (this.m[i] > 7)
                System.out.printf("m[%d] = %,.4f", i, this.m[i]);
        }
    }

    /*
    გვიბრუნებს მასივის უდიდესი და უმცირესი ელემენტების
    სხვაობას(გაბნევის დიაპაზონს).
     */
    public double method4(){
        double[] temp = this.m;
        Arrays.sort(temp);

        return temp[temp.length - 1] - temp[0];
    }
}
