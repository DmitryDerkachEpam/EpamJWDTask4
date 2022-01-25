package com.epam.expressionProcessing.mathOperations;

import com.epam.expressionProcessing.ContextWrapper;
import com.epam.expressionProcessing.MathExpression;

public class MinusExpression extends MathExpression {
    @Override
    public void interpret(ContextWrapper context) {
        context.addToQueueValue(context.getAndDeleteValue() - context.getAndDeleteValue());
    }
}
