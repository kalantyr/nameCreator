package com.kalantyr.nameCreator.core;

/**
 *  Умеет конвертировать русский символ в английский
 */
public interface LetterConverter {
    /**
     * Определяет, можно ли указанный символ преобразовать в английский
     */
    boolean canConvert(char ruChar);

    /**
     *  Конвертирует русский символ в английский
     */
    char convertToEn(char ruChar);
}
