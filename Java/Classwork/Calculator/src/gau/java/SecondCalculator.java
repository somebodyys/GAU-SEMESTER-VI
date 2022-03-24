package gau.java;

import java.util.Arrays;
import java.util.Stack;

public class SecondCalculator {
    private final String expression;

    public SecondCalculator(String expression) {
        this.expression = expression;
    }

    public int calculate(){
        char[] chars = this.expression.toCharArray();
        String operators = "+-*/";

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                continue;

            if(Character.isDigit(chars[i])){
                StringBuilder valueBuffer = new StringBuilder();

                while(i < chars.length && Character.isDigit(chars[i]))
                    valueBuffer.append(chars[i++]);

                values.push(Integer.parseInt(valueBuffer.toString()));

                i--;
            }
            else if(chars[i] == '(')
                ops.push(chars[i]);
            else if(chars[i] == ')'){
                while(ops.peek() != '(')
                    values.push(applyOp(
                            ops.pop(), values.pop(), values.pop()
                    ));
                ops.pop();
            }else if(operators.indexOf(chars[i]) != -1){
                while(!ops.empty() && hasAdvantage(chars[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                ops.push(chars[i]);
            }
        }

        while (!ops.empty())
            values.push(
                    applyOp(ops.pop(), values.pop(), values.pop())
            );

        return values.pop();
    }

    public static boolean hasAdvantage(char op1, char op2){
        if(op2 == '(' || op2 == ')')
            return false;
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }

    public static int applyOp(char op, int b, int a){
        switch (op){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if(b == 0)
                    throw new UnsupportedOperationException("No zero division");
                return a / b;
        }

        return 0;
    }
}
