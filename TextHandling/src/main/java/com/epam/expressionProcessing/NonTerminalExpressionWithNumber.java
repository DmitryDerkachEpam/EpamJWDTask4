package com.epam.expressionProcessing;

public class NonTerminalExpressionWithNumber extends MathExpression {

    private int number;

    public NonTerminalExpressionWithNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(ContextWrapper context) {
        context.addToQueueValue(number);
    }
}
