package com.epam.parsing;

import com.epam.textComponents.Component;
import com.epam.textComponents.Composite;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    public AbstractParser() {
        successor = null;
    }
    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    protected Composite parseByTemplate(String text, String regExDelimiter) {
        Composite result = new Composite();
        String[] parsedText = text.split(regExDelimiter);
        for (String element : parsedText) {
            Component textPart = getSuccessor().parse(element);
            result.add(textPart);
        }
        return result;
    }
}