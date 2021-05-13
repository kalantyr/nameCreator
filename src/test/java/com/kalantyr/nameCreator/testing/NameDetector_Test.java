package com.kalantyr.nameCreator.testing;

import com.kalantyr.nameCreator.core.*;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class NameDetector_Test {

    @Test
    public void detect(){
        var ruWordsSource = mock(IRuWordsSource.class);
        when(ruWordsSource.getRuWords()).thenReturn(new String[]{ "Марс", "Венера" });

        var letterConverter = mock(ILetterConverter.class);
        when(letterConverter.convertToEn('М')).thenReturn('M');
        when(letterConverter.convertToEn('А')).thenReturn('A');
        when(letterConverter.convertToEn('Р')).thenReturn('P');
        when(letterConverter.convertToEn('С')).thenReturn('C');

        var detector = new NameDetector();
        var q = detector.detect(ruWordsSource, letterConverter, true);
        Assert.assertNotNull(q);
    }

}
