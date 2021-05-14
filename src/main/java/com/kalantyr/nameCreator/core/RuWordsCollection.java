package com.kalantyr.nameCreator.core;

import java.util.Arrays;

public class RuWordsCollection implements WordsSource {

    @Override
    public Iterable<String> getWords() {

        String[] values = { "Топор", "Вор", "Марс" };
        return Arrays.asList(values);
    }
}
