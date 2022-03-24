package gau.java;

import java.util.Scanner;

public class FirstCalculator {

    public FirstCalculator() {
        double x, y, result = 0;
        char operator;
        Scanner scanner = new Scanner(System.in);

        x = scanner.nextDouble();
        operator = scanner.next().charAt(0);
        y = scanner.nextDouble();

        switch (operator) {
            case '*' -> result = x * y;
            case '+' -> result = x + y;
            case '-' -> result = x - y;
            case '/' -> result = y == 0 ? 0 : x / y;
            case '^' -> result = Math.pow(x, y);
        }

        System.out.println(result);
    }
}
