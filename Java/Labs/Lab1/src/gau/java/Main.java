package gau.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /*
    გამოიტანეთ დაპროგრამების ენების სახელები ცალ–ცალკე ხაზზე
    ( C++, C#,java, pascal, php, JavaScropt, ActionScript).
     */
    private static void task1(){
        String[] languages = { "C++", "C#", "Java", "Pascal", "PHP", "JavaScript", "ActionScript"};

        for (String language: languages) {
            System.out.println(language);
        }
    }

    /*
    დავწეროთ კოდი რომელიც გამოიტანს შეტანილი ორი მთელი რიცხვის
    შემთხვევაში, პირველის მეორეზე გაყოფის შედეგად მიღებულ მთელ შედეგს
    და მეორის პირველზე გაყოფის შედეგად მიღებულ ნაშთს. (ფორმატის
    გათვალისწინებით).
     */
    private static void task2(){
        Scanner scanner = new Scanner(System.in);
        int number1, number2;
        System.out.print("Number 1 : ");
        number1 = scanner.nextInt();
        System.out.print("Number 2 : ");
        number2 = scanner.nextInt();

        System.out.printf("%d / %d = %d%n", number1, number2, number1/number2);
        System.out.printf("%d %% %d = %d", number2, number1, number2 % number1);
    }

    /*
    შეიტანეთ სამი მთელი რიცხვი, გამოიტანეთ მათი ჯამი და ნამრავლი.
     */
    private static void task3(){
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;

        System.out.print("Number 1 : ");
        num1 = scanner.nextInt();
        System.out.print("Number 2 : ");
        num2 = scanner.nextInt();
        System.out.print("Number 3 : ");
        num3 = scanner.nextInt();

        System.out.printf("%d + %d + %d = %d%n", num1, num2, num3, num1+num2+num3);
        System.out.printf("%d * %d * %d = %d", num1, num2, num3, num1*num2*num3);
    }

    /*
    4) შეიტანეთ სამნიშნა მთელი რიცხვი, დაბეჭდეთ რიცხვის ციფრები ცალ-ცალკე ხაზზე.
    5) შეიტანეთ ოთხნიშნა მთელი რიცხვი, დაბეჭდეთ რიცხვის ციფრთა ჯამი.
    6) შეიტანეთ ნებისმიერი მთელი რიცხვი, დაბეჭდეთ რიცხვის ციფრთა ჯამი.
     */
    private static void tasks456(){
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Number : ");
        number = scanner.nextInt();

        int digitSum = 0;
        while(number > 0){
            int digit = number % 10;
            System.out.println(digit);
            digitSum += digit;
            number /= 10;
        }
        System.out.printf("digitSum = %d", digitSum);
    }

    /*
    იპოვეთ ორი მთელი რიცხვის უდიდესი საერთო გამყოფი და უმცირესი საერთო ჯერადი.(ევკლიდეს ალგორითმი).
     */
    private static void task7(){
        Scanner scanner = new Scanner(System.in);
        int number1, number2;
        System.out.print("Number 1 : ");
        number1 = scanner.nextInt();
        System.out.print("Number 2 : ");
        number2 = scanner.nextInt();

        int gcd = gcd(number1, number2);
        System.out.printf("GCD(%d, %d) = %d%n", number1, number2, gcd);
        System.out.printf("LCM(%d, %d) = %d", number1, number2, (number1 * number2)/gcd);

    }

    private static int gcd(int number1, int number2){
        if (number1 == 0)
            return number2;

        return gcd(number2 % number1, number1);
    }

    /*
    დაბეჭდეთ მთელი რიცხვები M-დან N-მდე.
     */
    private static void task8(){
        Scanner scanner = new Scanner(System.in);
        int number1, number2;
        System.out.print("Number 1 : ");
        number1 = scanner.nextInt();
        System.out.print("Number 2 : ");
        number2 = scanner.nextInt();

        for (int i = number1; i < number2; i++) {
            System.out.printf("%d ", i);
        }
    }

    /*
    9) განსაზღვრეთ 8 ელემენტიანი ნამდვილ რიცხვთა მასივი, დაბეჭდეთ მასივის
    ელემენტები, მასივის უდიდესი და უმცირესი ელემენტი.
    10) განსაზღვრეთ 8 ელემენტიანი ნამდვილ რიცხვთა მასივი, დაალაგეთ მასივი
    ზრდადობით, დაბეჭდეთ მასივი.
    11) განსაზღვრეთ 8 ელემენტიანი ნამდვილ რიცხვთა მასივი, ჩაწერეთ მასში
    შემთხვევითი რიცხვები, დაბეჭდეთ მასივი.
    12) განსაზღვრეთ 8 ელემენტიანი მთელ რიცხვთა მასივი, ჩაწერეთ მასში
    შემთხვევითი რიცხვები, დაალაგეთ მასივი კლებადობით, დაბეჭდეთ მასივი.
     */
    private static void tasks9101112(){
        Random random = new Random();
        Integer[] numbers = new Integer[8];
        for (int i = 0; i < 8; i++) {
            numbers[i] = random.nextInt(-1000, 1000);
        }
        System.out.printf("Array -> %s%n", Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.printf("ASC -> %s%n", Arrays.toString(numbers));
        System.out.printf("Max = %d%nMin = %d%n", numbers[numbers.length - 1], numbers[0]);
        Arrays.sort(numbers, Collections.reverseOrder());
        System.out.printf("DESC -> %s%n", Arrays.toString(numbers));
    }

    public static void main(String[] args) {
	    task1();
        task2();
        task3();
        tasks456();
        task7();
        task8();
        tasks9101112();
    }
}
