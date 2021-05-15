package com.kalantyr.nameCreator.core;

public class RuToEnConverter implements LetterConverter {

    @Override
    public boolean canConvert(char ruChar) {
        switch (ruChar)
        {
            case 'А':
                return true;
            default:
                return false;
        }
    }

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
