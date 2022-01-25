package com.epam.parsing;

public class ChainBuilder {

    public Parser build() {
        //TODO add WordParser class
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
