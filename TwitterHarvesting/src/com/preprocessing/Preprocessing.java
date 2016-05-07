package com.preprocessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preprocessing {
    
    /**
     * Remove all neutral words.
     * 
     * @param text
     * @return
     */
    public static String removeNeuWords(String text) {
        
        return null;
    }
    
    /**
     * Remove url from the string using regular expression
     * 
     * @param text
     * @return URL free text
     */
    public static String removeUrl(String text) {
        String url = "((https?|ftp|telnet|file|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(url, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(text);
        int i = 0;
        while (match.find()) {
            text = text.replaceAll(match.group(i), "").trim();
            i++;
        }

        return removeHTMLChar(text);
    }

    /**
     * Public tweets contains certain reserve character of HTML such as &amp,
     * &quote This method cleans such HTMl reserve characters from the text
     * using Regular Expression.
     * 
     * @param text
     * @return
     */
    private static String removeHTMLChar(String text) {

        return text.replaceAll("&amp;", "&").replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'").replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">");
    }
}
