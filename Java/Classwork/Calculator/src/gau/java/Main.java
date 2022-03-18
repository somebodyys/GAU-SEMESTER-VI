package gau.java;

import java.util.Scanner;

public class Main {

    private static void firstCalculator(){
        double x, y, result = 0;
        char operator;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Calculator : ");
        System.out.print("x = ");
        x = scanner.nextDouble();
        System.out.print("Operator = ");
        operator = scanner.next().charAt(0);
        System.out.print("y = ");
        y = scanner.nextDouble();

        switch (operator) {
            case '*' -> result = x * y;
            case '+' -> result = x + y;
            case '-' -> result = x - y;
            case '/' -> result = x / y;
            case '^' -> result = Math.pow(x, y);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        firstCalculator();
    }
}
