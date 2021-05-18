package com.kalantyr.nameCreator.core;

import java.util.ArrayList;
import java.util.Collection;

public class NameDetector {

    private LetterConverter converter;

    public NameDetector(LetterConverter converter) {
        this.converter = converter;
    }

    public Collection<String> detect(WordsSource ruWordsSource, boolean caps) {
        var result = new ArrayList<String>();

        for (var ruWord : ruWordsSource.getWords()) {
            var enWord = getEnWord(ruWord, caps);
            if (enWord != null)
                if (!result.contains(enWord))
                    result.add(enWord);
        }

        return result;
    }

    private String getEnWord(String ruWord, boolean caps) {
        var chars = new char[ruWord.length()];
        for (var i = 0; i < ruWord.length(); i++) {
            char ruChar = ruWord.charAt(i);
            if (i == 0 || caps)
                ruChar = Character.toUpperCase(ruChar);
            if (converter.canConvert(ruChar)) {
                var enChar = converter.convertToEn(ruChar);
                chars[i] = enChar;
            }
            else
                return null;
        }
        return new String(chars);
    }
}
