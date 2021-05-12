package ru.kalantyr.nameCreator;

/**
 *  Умеет конвертировать русский символ в английский
 */
public interface ILetterConverter {
    /**
     *  Конвертирует русский символ в английский
     */
    char convertToEn(char ruChar);
}
