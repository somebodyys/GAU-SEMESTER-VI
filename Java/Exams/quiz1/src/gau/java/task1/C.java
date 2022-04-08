package gau.java.task1;

import java.util.Scanner;

public class C {

    protected int a, b;

    /**
     * ანიჭებს a, b ცვლადებს მნიშვნელობებს კლავიატურიდან;
     */
    public void method1(){
        Scanner scanner = new Scanner(System.in);
        this.a = scanner.nextInt();
        this.b = scanner.nextInt();
    }

    /**
     * აბრუნებს a რიცხვის ლუწი ციფრების ჯამს;
     */
    public int method2(){
        int temp = this.a, evenDigitSum = 0;

        while (temp > 0){
            int digit = temp % 10;
            if (digit % 2 == 0)
                evenDigitSum += digit;
            temp /= 10;
        }

        return evenDigitSum;
    }

    /**
     * აბრუნებს b რიცხვის გამყოფების ნამრავლს;
     */
    public double method3(){
        double divisorsMultiply = this.b;

        for (int i = 2; i < Math.sqrt(this.b); i++) {
            if (this.b % i == 0){
                if(this.b / i == i)
                    divisorsMultiply *= i;
                else
                    divisorsMultiply *= this.b;
            }
        }

        return divisorsMultiply;
    }

    /**
     * ბეჭდავს მეთოდი 2-ის მნიშნველობისა და მეთოდი 3-ის მნიშვნელობის
     * ჯამს;
     */
    public void method4(){

        System.out.println(
                this.method2() + this.method3()
        );
    }
}
