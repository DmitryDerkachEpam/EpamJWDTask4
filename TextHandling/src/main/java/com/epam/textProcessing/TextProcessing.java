package com.epam.textProcessing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.textComponents.Component;
import com.epam.textComponents.Composite;

public class TextProcessing {

    public static List<Component> sortParagraphBySentencesQuantity(Component text) {
        List<Component> listOfParagraphs = text.getTextParts().stream()
                .map(Composite.class::cast)
                .sorted(new ChildComponentsComparator())
                .collect(Collectors.toList());
        return listOfParagraphs;
    }

    public static List<Component> sortWordsInSentenceByWordLength(Component text) {
        List<Component> listOfLexemes = new ArrayList<>(text.getTextParts());
        listOfLexemes.sort(Comparator.comparing(Component::getValue));
        return listOfLexemes;
    }

/* temporal commented out
    public static List<Component> sortWordsInSentenceByWordLength(String text) {
        SentenceParser sentenceParser = new SentenceParser();
        Composite parse = sentenceParser.parse(text);
        List<Component> listOfLexemes = parse.getTextParts();
        listOfLexemes.sort(Comparator.comparing(component -> component.getValue().length()));
        return listOfLexemes;
    }*/

    public static String restoreStartText(Component text) {
        String startingText = text.getTextParts().stream()
                .map(Component::getValue)
                .collect(Collectors.joining(" "));
        return startingText;
    }
}
