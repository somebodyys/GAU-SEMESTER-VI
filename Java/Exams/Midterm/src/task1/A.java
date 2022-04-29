package task1;

import java.util.Random;
import java.util.Scanner;

interface myInterface {
    void method1();
    void method2();
}

public class A implements myInterface {
    protected int a, b;
    protected int[] m = new int[12];

    /**
     * ანიჭებს a და b-ს მნიშვნელობების კლავიატურიდან;
     */
    @Override
    public void method1() {
        Scanner scanner = new Scanner(System.in);
        this.a = scanner.nextInt();
        this.b = scanner.nextInt();
    }

    /**
     * ანიჭებს m მასივის ელემენტებს შემთხვევით მნიშვნელობებს [a; b]
     * შუალედუდან;
     */
    @Override
    public void method2() {
        Random random = new Random();

        for (int i = 0; i < this.m.length; i++) {
            this.m[i] = random.nextInt(this.a, this.b);
        }
    }

    /**
     * აბრუნებს მასივის დადებითი ელემენტებიდან უმცირესს
     */
    public int method3(){
        int result = 0;

        // უზრუნველყოფს რომ თავდაპირველი მნიშვნელობა იყოს დადებითი ელემენტი მასივიდან
        for (int j : this.m) {
            if (j > 0) {
                result = j;
                break;
            }
        }

        for (int j : this.m) {
            if (j > 0 && j < result)
                result = j;
        }
        
        return result;
    }

    /**
     * ბეჭდავს m მასივის ელემენტებს ინდექსები ჩვენებით;
     */
    public void method4(){
        for (int i = 0; i < this.m.length; i++) {
            System.out.printf("m[%d] = %d\n", i, this.m[i]);
        }
    }

    /**
     * ბეჭდავს მასივიდან 3-ის ჯერად რიცხვებს.
     */
    public void method5(){
        for (int j : this.m) {
            if (j % 3 == 0)
                System.out.println(j);
        }
    }
}
