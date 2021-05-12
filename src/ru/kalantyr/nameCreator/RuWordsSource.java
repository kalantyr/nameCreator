package ru.kalantyr.nameCreator;

public class RuWordsSource implements IRuWordsSource {

    @Override
    public String[] getRuWords() {
        return new String[] { "Топор", "Вор", "Марс" };
    }
}
