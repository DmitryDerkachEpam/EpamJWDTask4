package com.epam.expressionProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.epam.expressionProcessing.mathOperations.DivideExpression;
import com.epam.expressionProcessing.mathOperations.MinusExpression;
import com.epam.expressionProcessing.mathOperations.MultiplyExpression;
import com.epam.expressionProcessing.mathOperations.PlusExpression;

public class CalculatorForExpression {

    private static final String REGEX_FOR_EXPRESSIONS = "\\s+";

    private List<MathExpression> expressionList;

    public CalculatorForExpression(String expression) {
        this.expressionList = new ArrayList<>();
        parseExpression(expression);
    }

    private void parseExpression(String expression) {
        for (String lexeme : expression.split(REGEX_FOR_EXPRESSIONS)) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char tempCharacter = lexeme.charAt(0);
            switch (tempCharacter) {
                case '+':
                    expressionList.add(new PlusExpression());
                    break;
                case '-':
                    expressionList.add(new MinusExpression());
                    break;
                case '*':
                    expressionList.add(new MultiplyExpression());
                    break;
                case '/':
                    expressionList.add(new DivideExpression());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        expressionList.add(new NonTerminalExpressionWithNumber(scanner.nextInt()));
                    }
            }
        }
    }

    public Integer calculate() {
        ContextWrapper context = new ContextWrapper();
        for (MathExpression expression : expressionList) {
            expression.interpret(context);
        }
        return context.getAndDeleteValue();
    }
}
