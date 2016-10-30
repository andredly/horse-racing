package com.charniauski.training.horsesrace.daodb.util;

import java.util.Random;

public class RandomUtil {

    public static final String pattern =
            "!Q@A#a$0%bc&L*d(U)K-2=e+H{f}J[g]?TP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR";

    public static String newString(int length) {
        StringBuffer buffer;
        Random random;

        buffer = new StringBuffer();
        random = new Random();

        for (int i = 1; i <= length; i++) {
            buffer.append(RandomUtil.pattern.charAt(random.nextInt(RandomUtil.pattern.length())));
        }

        return buffer.toString();
    }
}