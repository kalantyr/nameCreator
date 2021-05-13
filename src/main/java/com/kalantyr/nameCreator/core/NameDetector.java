package com.kalantyr.nameCreator.core;

public class NameDetector {
    public String[] detect(IRuWordsSource ruWordsSource, ILetterConverter converter, boolean caps) {
        var ruWords = ruWordsSource.getRuWords();
        converter.convertToEn('А');
        return new String[] { "Тест1", "Тест2", "Тест3" };
    }
}
