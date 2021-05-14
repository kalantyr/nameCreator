package com.kalantyr.nameCreator.core;

/**
 *  Умеет конвертировать русский символ в английский
 */
public interface LetterConverter {
    /**
     *  Конвертирует русский символ в английский
     */
    char convertToEn(char ruChar);
}
