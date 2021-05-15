package com.kalantyr.nameCreator.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RuWordsCollection implements WordsSource {
    private List<String> words = new ArrayList<>();

    @Override
    public Iterable<String> getWords() {
        return words;
    }

    public RuWordsCollection(String text) {
        words.addAll(RuWordsCollection.parseWords(text));
    }

    public static List<String> parseWords(String text) {
        return Arrays.stream(text.split("\n"))
                .map(line -> line.replace("\r", ""))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(w -> w.length() > 2)
                .filter(RuWordsCollection::isRu)
                .collect(Collectors.toUnmodifiableList());
    }

    private static boolean isRu(String word) {
        for (var i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            var isRu = (ch >= 'а' && ch <= 'я') || (ch >= 'А' && ch <= 'Я');
            if (!isRu)
                return false;
        }
        return true;
    }
}
