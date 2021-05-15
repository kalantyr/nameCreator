package com.kalantyr.nameCreator.testing;

import com.kalantyr.nameCreator.core.RuWordsCollection;
import org.junit.Assert;
import org.junit.Test;

public class RuWordsCollection_Test {
    @Test
    public void parseWords(){
        var words = RuWordsCollection.parseWords("");
        Assert.assertEquals(0, words.size());

        words = RuWordsCollection.parseWords("Один два Три четыре п ш се во де");
        Assert.assertEquals(4, words.size());

        words = RuWordsCollection.parseWords("Слово Slovo Слове4ко Sлово");
        Assert.assertEquals(1, words.size());

        words = RuWordsCollection.parseWords(
                "абажур\n" +
                "абаз\n" +
                "абазин\n" +
                "абазинка\n" +
                "абака");
        Assert.assertEquals(5, words.size());

        words = RuWordsCollection.parseWords("раз\nдва\nтри");
        Assert.assertEquals(3, words.size());
    }
}
