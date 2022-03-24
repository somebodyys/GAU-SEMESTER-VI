package gau.java;


public class Main {
    public static void main(String[] args) {
//        FirstCalculator firstCalculator = new FirstCalculator();

        String expression = "3+ 4*(28+4/2+6)/27";
        SecondCalculator secondCalculator = new SecondCalculator(expression);

        System.out.printf("%s = %d", expression, secondCalculator.calculate());
    }
}
