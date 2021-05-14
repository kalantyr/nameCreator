package com.kalantyr.nameCreator.testing;

import com.kalantyr.nameCreator.core.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class NameDetector_Test {

    @Test
    public void detect() {
        var ruWordsSource = mock(WordsSource.class);
        when(ruWordsSource.getWords()).thenReturn(Arrays.asList("Марс", "Венера"));

        var letterConverter = mock(LetterConverter.class);
        when(letterConverter.convertToEn('М')).thenReturn('M');
        when(letterConverter.convertToEn('а')).thenReturn('a');
        when(letterConverter.convertToEn('р')).thenReturn('p');
        when(letterConverter.convertToEn('с')).thenReturn('c');
        when(letterConverter.convertToEn('А')).thenReturn('A');
        when(letterConverter.convertToEn('Р')).thenReturn('P');
        when(letterConverter.convertToEn('С')).thenReturn('C');
        when(letterConverter.convertToEn('В')).thenReturn('B');
        when(letterConverter.convertToEn('е')).thenReturn('e');
        when(letterConverter.convertToEn('В')).thenReturn('B');
        when(letterConverter.convertToEn('Е')).thenReturn('E');
        when(letterConverter.convertToEn('Н')).thenReturn('H');

        var detector = new NameDetector(letterConverter);
        var result = detector.detect(ruWordsSource);

        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.contains("Mapc"));
        Assert.assertTrue(result.contains("MAPC"));
        Assert.assertTrue(result.contains("BEHEPA"));
    }

}
