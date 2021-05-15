package com.kalantyr.nameCreator.testing;

import com.kalantyr.nameCreator.core.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.*;

public class NameDetector_Test {

    private Map<Character, Character> map;

    public NameDetector_Test(){
        map = new HashMap<Character, Character>();
        map.put('М', 'M');
        map.put('а', 'a');
        map.put('р', 'p');
        map.put('с', 'c');
        map.put('А', 'A');
        map.put('Р', 'P');
        map.put('С', 'C');
        map.put('В', 'B');
        map.put('е', 'e');
        map.put('Е', 'E');
        map.put('Н', 'H');
    }

    @Test
    public void detect() {
        var ruWordsSource = mock(WordsSource.class);
        when(ruWordsSource.getWords())
                .thenReturn(Arrays.asList("Марс", "Венера"));

        var letterConverter = mock(LetterConverter.class);

        when(letterConverter.canConvert(Mockito.anyChar()))
                .thenAnswer((Answer<Boolean>) invocation -> {
                    var ch = invocation.getArgument(0, Character.class);
                    return map.containsKey(ch);
                });

        when(letterConverter.convertToEn(Mockito.anyChar()))
                .thenAnswer((Answer<Character>) invocation -> {
                    var ch = invocation.getArgument(0, Character.class);
                    return map.get(ch);
                });

        var detector = new NameDetector(letterConverter);
        var result = detector.detect(ruWordsSource);

        Assert.assertEquals(3, result.size());
        Assert.assertTrue(result.contains("Mapc"));
        Assert.assertTrue(result.contains("MAPC"));
        Assert.assertTrue(result.contains("BEHEPA"));
    }

}
