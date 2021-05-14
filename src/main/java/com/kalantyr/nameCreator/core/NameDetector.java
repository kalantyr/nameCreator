package com.kalantyr.nameCreator.core;

import java.util.ArrayList;
import java.util.Collection;

public class NameDetector {

    private LetterConverter converter;

    public NameDetector(LetterConverter converter) {

        this.converter = converter;
    }

    public Collection<String> detect(WordsSource ruWordsSource) {
        var result = new ArrayList<String>();

        for (var ruWord : ruWordsSource.getWords()) {
            var enWord = getEnWord(ruWord);
            if (enWord != null)
                result.add(enWord);
        }

        converter.convertToEn('А');
        return result;
    }

    private String getEnWord(String ruWord) {
        throw new UnsupportedOperationException();
    }
}
