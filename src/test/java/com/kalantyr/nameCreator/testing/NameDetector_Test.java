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
        when(letterConverter.convertToEn('А')).thenReturn('A');
        when(letterConverter.convertToEn('Р')).thenReturn('P');
        when(letterConverter.convertToEn('С')).thenReturn('C');

        var detector = new NameDetector(letterConverter);
        var q = detector.detect(ruWordsSource);
        Assert.assertNotNull(q);
    }

}
