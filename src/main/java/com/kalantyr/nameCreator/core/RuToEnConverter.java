package com.kalantyr.nameCreator.core;

public class RuToEnConverter implements LetterConverter {

    @Override
    public char convertToEn(char ruChar) {
        switch (ruChar)
        {
            case 'А':
                return 'A';
            default:
                throw new UnsupportedOperationException();
        }
    }

}
