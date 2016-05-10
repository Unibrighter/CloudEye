package com.preprocess;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.file.FileUtils;
import com.utils.UtilHelper;

public class Preprocessing {

    public static final String EXACT_PATTERN = "\\b(%s)\\b";
    public static final String URL_PATTERN = "((https?|ftp|telnet|file|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
    private static final String NEUTRAL_WORDS_PATTERN;

    static {
        Set<String> words = FileUtils.getInstance().read(
                Preprocessing.class.getResourceAsStream("neutral_words.txt"));
        NEUTRAL_WORDS_PATTERN = UtilHelper
                .getExactPattern(words.toArray(new String[words.size()]));
    }

    public static String process(String text) {
        return removeNeuWords(removeUrl(text));
    }

    /**
     * Remove all neutral words.
     * 
     * @param text
     * @return
     */
    public static String removeNeuWords(String text) {
        Pattern pattern = Pattern.compile(NEUTRAL_WORDS_PATTERN,
                Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(text);
        while (match.find()) {
            text = text.replaceAll(match.group(), "").trim();
        }
        return text;
    }

    /**
     * Remove url from the string using regular expression
     * 
     * @param text
     * @return URL free text
     */
    public static String removeUrl(String text) {
        Pattern pattern = Pattern.compile(URL_PATTERN,
                Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(text);
        while (match.find()) {
            try {
                text = text.replaceAll(match.group(), "").trim();
            }
            catch (PatternSyntaxException e) {
                String s = match.group().replace(")", "");
                text = text.replaceAll(s, "").trim();
                continue;
            }
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
