package com.kalantyr.nameCreator.testing;

import com.kalantyr.nameCreator.core.*;
import org.junit.Assert;
import org.junit.Test;

public class RuToEnConverter_Test {
    @Test
    public void convertToEn() {
        var letterConverter = new RuToEnConverter("А -> A" + "\n" + "В -> B");
        Assert.assertEquals('A', letterConverter.convertToEn('А'));
        Assert.assertEquals('B', letterConverter.convertToEn('В'));
    }
}
