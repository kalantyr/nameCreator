package ru.kalantyr.nameCreator;

public class NameDetector {
    public String[] Detect(IRuWordsSource ruWordsSource, ILetterConverter converter, boolean caps) {
        var ruWords = ruWordsSource.getRuWords();
        converter.convertToEn('E');
        return new String[] { "Тест1", "Тест2", "Тест3" };
    }
}
