package gau.java;

import java.util.Stack;

public class SecondCalculator {
    private final String expression;

    public SecondCalculator(String expression) {
        this.expression = expression;
    }

    public int calculate(){
        char[] spitedCharacters = this.expression.toCharArray();
        String supportedOperators = "+-*/";

        Stack<Integer> valuesStack = new Stack<>();
        Stack<Character> operationsStack = new Stack<>();

        for (int i = 0; i < spitedCharacters.length; i++) {
            if (spitedCharacters[i] == ' ')
                continue;

            if(Character.isDigit(spitedCharacters[i])){
                StringBuilder valueBuffer = new StringBuilder();

                while(i < spitedCharacters.length && Character.isDigit(spitedCharacters[i]))
                    valueBuffer.append(spitedCharacters[i++]);

                valuesStack.push(Integer.parseInt(valueBuffer.toString()));

                i--;
            }
            else if(spitedCharacters[i] == '(')
                operationsStack.push(spitedCharacters[i]);
            else if(spitedCharacters[i] == ')'){
                while(operationsStack.peek() != '(')
                    valuesStack.push(apply(
                            operationsStack.pop(), valuesStack.pop(), valuesStack.pop()
                    ));
                operationsStack.pop();
            }else if(supportedOperators.indexOf(spitedCharacters[i]) != -1){
                while(!operationsStack.empty() && hasAdvantage(spitedCharacters[i], operationsStack.peek()))
                    valuesStack.push(apply(operationsStack.pop(), valuesStack.pop(), valuesStack.pop()));

                operationsStack.push(spitedCharacters[i]);
            }
        }

        while (!operationsStack.empty())
            valuesStack.push(
                    apply(operationsStack.pop(), valuesStack.pop(), valuesStack.pop())
            );

        return valuesStack.pop();
    }

    public static boolean hasAdvantage(char firstOperation, char secondOperation){
        if(secondOperation == '(' || secondOperation == ')')
            return false;
        return (firstOperation != '*' && firstOperation != '/') || (secondOperation != '+' && secondOperation != '-');
    }

    public static int apply(char operation, int followingNumber, int leadingNumber){
        switch (operation){
            case '+': return leadingNumber + followingNumber;
            case '-': return leadingNumber - followingNumber;
            case '*': return leadingNumber * followingNumber;
            case '/':
                if(followingNumber == 0)
                    throw new UnsupportedOperationException("No zero division");
                return leadingNumber / followingNumber;
        }

        return 0;
    }
}
