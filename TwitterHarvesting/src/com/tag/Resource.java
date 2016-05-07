package com.tag;

import com.beans.GeoCircle;

public class Resource {

    /* Topic key words */
    public final static String[] DIET = { "diet", "hunger", "hunger control",
            "low carb", "reduce intake" };
    public final static String[] EXERCISE = { "workout", "fitness", "exercise",
            "HIIT", "running", "yoga", "jogging", "Nike+" };
    public final static String[] PRODUCT = { "Nike", "Adidas", "Puma",
            "New Balance", "Skechers" };
    public final static String[] CAR = {};
    public final static String[] RELIGION = {};
    public final static String[] TRANSPORT = {};
    public final static String[] CAFE = {};

    /* 4 main areas */
    public final static double[][] EAST = { { 144.9955, -38.5181 },
            { 145.7850, -37.7218 } };

    public final static double[][] NORTH = { { 144.8857, -37.7316 },
            { 145.6175, -37.2161 } };

    public final static double[][] INNER = { { 144.8857, -37.8932 },
            { 145.0435, -37.7316 } };

    public final static double[][] WEST = { { 144.3238, -38.0200 },
            { 144.8857, -37.1504 } };

    /* 4 main areas circle for REST API */
    public final static GeoCircle REST_EAST = new GeoCircle(-38.1054, 145.4123,
            26);
    public final static GeoCircle REST_NORTH = new GeoCircle(-37.4934, 145.2447,
            23);
    public final static GeoCircle REST_INNER = new GeoCircle(-37.8087, 144.9646,
            6);
    public final static GeoCircle REST_WEST = new GeoCircle(-37.6523, 144.4427,
            26);

    /* Different language */
    public final static String[] EN = { "en" };
    public final static String[] CN = { "zh" };
    public final static String[] JA = { "ja" };
    public final static String[] KO = { "ko" };
    public final static String[] FR = { "fr" };
    public final static String[] GE = { "de" };
    public final static String[] IT = { "it" };
}
