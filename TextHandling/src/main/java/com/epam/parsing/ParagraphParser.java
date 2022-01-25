package com.epam.parsing;

import com.epam.textComponents.Component;

public class ParagraphParser extends AbstractParser {

    public static final String REGEX_FOR_SENTENCE_DELIMITER = "(?<=[\\.?!]){3}[\\n\\s]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        return parseByTemplate(text, REGEX_FOR_SENTENCE_DELIMITER);
    }
}
