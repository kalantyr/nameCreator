package com.kalantyr.nameCreator.core;

import java.util.*;
import java.util.stream.Collectors;

public class RuToEnConverter implements LetterConverter {

    public static final Map<Character, Character> defaultConverts;
    static {
        defaultConverts = Arrays.stream(new Character[][] {
                {'А', 'A'},
                {'В', 'B'},
                {'Е', 'E'},
                {'З', '3'},
                {'К', 'K'},
                {'М', 'M'},
                {'Н', 'H'},
                {'О', 'O'},
                {'Р', 'P'},
                {'С', 'C'},
                {'Т', 'T'},
                {'Х', 'X'},
                {'а', 'a'},
                {'е', 'e'},
                {'о', 'o'},
                {'р', 'p'},
                {'с', 'c'},
                {'у', 'y'},
                {'х', 'x'}
        }).collect(Collectors.toMap(p -> p[0], p -> p[1]));
    }

    private Map<Character, Character> map;

    public RuToEnConverter(String text) {
        map = new HashMap<>();
        for (var line: text.split("\n"))
            map.put(line.charAt(0), line.charAt(line.length() - 1));
    }

    @Override
    public boolean canConvert(char ruChar) {
        return map.containsKey(ruChar);
    }

    @Override
    public char convertToEn(char ruChar) {
        return map.get(ruChar);
    }
}
