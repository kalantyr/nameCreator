package com.kalantyr.nameCreator.core;

import java.util.HashMap;
import java.util.Map;

public class RuToEnConverter implements LetterConverter {
    private Map<Character, Character> map;

    public static Map<Character, Character> defaultConverts;
    static {
        defaultConverts = new HashMap<>();
        defaultConverts.put('А', 'A');
        defaultConverts.put('В', 'B');
        defaultConverts.put('Е', 'E');
        defaultConverts.put('З', '3');
        defaultConverts.put('К', 'K');
        defaultConverts.put('М', 'M');
        defaultConverts.put('Н', 'H');
        defaultConverts.put('О', 'O');
        defaultConverts.put('Р', 'P');
        defaultConverts.put('С', 'C');
        defaultConverts.put('Т', 'T');
        defaultConverts.put('Х', 'X');
        defaultConverts.put('а', 'a');
        defaultConverts.put('е', 'e');
        defaultConverts.put('о', 'o');
        defaultConverts.put('р', 'p');
        defaultConverts.put('с', 'c');
        defaultConverts.put('у', 'y');
        defaultConverts.put('х', 'x');
    }

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
