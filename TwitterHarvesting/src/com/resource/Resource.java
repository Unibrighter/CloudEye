package com.resource;

import java.util.HashMap;
import java.util.Map;

import com.beans.GeoCircle;
import com.oath.OAthConfig;

public class Resource {

    private static final Map<GeoType, GeoResource> areaMap = new HashMap<>();

    /* Topic key words */
    public final static String[] crime = { "theft", "police", "suicide", "rape",
            "security", "rob", "unsafe", "insecure", "steal", "thief", "robber",
            "crime", "offence", "murder", "violent" };

    public final static String[] politic = { "Abbott", "Malcolm Turnbull",
            "law", "politics", "politic", "politician", "Liberal Party",
            "Labor Party", "National Party", "council", "government" };

    public final static String[] fitness = { "workout", "fitness", "exercise",
            "HIIT", "running", "yoga", "jogging", "Nike+", "gym" };

    public final static String[] tvshow = { "Neighbors", "Neighbors2" };

    public final static String[] asianfood = { "Don", "Thai", "curry", "pho",
            "noodle", "spring roll", "laska", "chin chin" };

    public final static String[] ozfood = { "burger", "fish & chips",
            "kangaroo fillet", "poached egg", "calamari", "chicken fillet",
            "Lamingtons", "flat white", "vegemite", "pavlova", "cafe",
            "fish chips" };

    public final static String[] chinesefood = { "dumpling", "hotpot",
            "dim sim", "chinese food", "long bao", "buns" };

    public final static String[] italianfood = { "pizza", "spaghetti", "pasta",
            "ricotta", "mozzarella", "gnocchi", "spanino" };

    public final static String[] frenchfood = { "crepe", "creperie",
            "French fries", "poivre", "L¡¯oignon", "boeuf", "tartare",
            "Basquaise" };

    public final static String[] immigration = { "PR", "visa", "immigration",
            "SOL", "migration", "EOI", "ACS", "permanent resident" };

    public final static String[] trump = { "Trump" };

    /* 4 main areas */
    public final static double[][] EAST = { { 145.0435, -38.5181 },
            { 145.7850, -37.7218 } };

    public final static double[][] NORTH = { { 144.8857, -37.7316 },
            { 145.6175, -37.2161 } };

    public final static double[][] INNER = { { 144.8857, -37.8932 },
            { 145.0435, -37.7316 } };

    public final static double[][] WEST = { { 144.3238, -38.0200 },
            { 144.8857, -37.1504 } };

    /* 4 main areas circle for REST API */
    public final static GeoCircle REST_EAST = new GeoCircle(-38.105385902838094,
            145.41229248046875, 26);
    public final static GeoCircle REST_NORTH = new GeoCircle(-37.49338360812416,
            145.2447509765625, 23);
    public final static GeoCircle REST_INNER = new GeoCircle(-37.80869897600677,
            144.964599609375, 6);
    public final static GeoCircle REST_WEST = new GeoCircle(-37.652295930239426,
            144.4427490234375, 26);

    /* Different language */
    public final static String[] EN = { "en" };
    public final static String[] CN = { "zh" };
    public final static String[] JA = { "ja" };
    public final static String[] KO = { "ko" };
    public final static String[] FR = { "fr" };
    public final static String[] GE = { "de" };
    public final static String[] IT = { "it" };

    static {
        areaMap.put(GeoType.Inner_Rct, new GeoResource().setArea(INNER));
        areaMap.put(GeoType.East_Rct, new GeoResource().setArea(EAST));
        areaMap.put(GeoType.West_Rct, new GeoResource().setArea(WEST));
        areaMap.put(GeoType.North_Rct, new GeoResource().setArea(NORTH));
        areaMap.put(GeoType.Inner_Cir, new GeoResource().setCircle(REST_INNER));
        areaMap.put(GeoType.East_Cir, new GeoResource().setCircle(REST_EAST));
        areaMap.put(GeoType.West_Cir, new GeoResource().setCircle(REST_WEST));
        areaMap.put(GeoType.North_Cir, new GeoResource().setCircle(REST_NORTH));
    }

    public static GeoResource getGeoResource() {
        return areaMap.get(OAthConfig.getGeoType());
    }
}
