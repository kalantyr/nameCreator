package com.kalantyr.nameCreator.testing;

import com.kalantyr.nameCreator.core.*;
import org.junit.Assert;
import org.junit.Test;

public class RuToEnConverter_Test {
    @Test
    public void convertToEn() {
        var letterConverter = new RuToEnConverter();
        var result = letterConverter.convertToEn('А');
        Assert.assertEquals('A', result);
    }
}
