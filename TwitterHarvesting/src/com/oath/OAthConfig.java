package com.oath;

import java.util.HashMap;
import java.util.Map;

import com.resource.GeoType;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class OAthConfig {

    private static final Map<GeoType, OAthInfo> map = new HashMap<>();
    private static final Map<Integer, GeoType> initalMap = new HashMap<>();
    private static GeoType geoType = GeoType.Inner_Rct;

    static {
        initalMap.put(1, GeoType.Inner_Rct);
        initalMap.put(2, GeoType.East_Rct);
        initalMap.put(3, GeoType.West_Rct);
        initalMap.put(4, GeoType.North_Rct);
        initalMap.put(5, GeoType.Inner_Cir);
        initalMap.put(6, GeoType.East_Cir);
        initalMap.put(7, GeoType.West_Cir);
        initalMap.put(8, GeoType.North_Cir);

        /* Harvesting 1 Inner */
        map.put(GeoType.Inner_Rct,
                new OAthInfo(
                        "IkoXSddjZHDuzdpgToiRPbi4di12iTptRevHwDLGDdjkKmoXJZ",
                        "OljCaeSTjxIYxPW01xG1eDuEv",
                        "4035327626-POQsYQEyFccE7ptVoGG5eX36h3ftGcJrC0TfvB3",
                        "pnyiNTsGGQJbfI5Xjj6WUaFEhGGBicosRQFNkfqERnHBR"));

        /* Harvesting 2 East */
        map.put(GeoType.East_Rct,
                new OAthInfo(
                        "BPHNDOj7kOlHa1izVNkJ1oHgyvqNJurR9AgoPpCW5PvqHtwOt2",
                        "wLndHBmWyRxLjoErlDNlDDUkX",
                        "728261638839664640-Qm46bPkAsbJmJGDPxePoiqrlTQdickx",
                        "0MMrlJNaGUNByLudidcy7ELv00SQU1Uu0hXig5GOS76wx"));

        /* Harvesting 3 West */
        map.put(GeoType.West_Rct,
                new OAthInfo(
                        "Zjk5urEuvMT4ipj7wD1OkKvpcCrTnfdYqvIEOOOW7IvVg4mfvY",
                        "gegAKPdB0VqC0cg5kTWd6s8Qg",
                        "321842685-v2fLN3tyP7AQUr3AzGwGYiDGHbm1xcRuEoEyGEos",
                        "vpMWX4KPpt8ulPet0lcAsugKibMbgAR5FkTPx4MmOGKK4"));

        /* Harvesting 4 North */
        map.put(GeoType.North_Rct,
                new OAthInfo(
                        "DPi2ixuchm4qYoy0NL02IY0qRs13Drgzy0G41KShsioYeOaOZM",
                        "GAPDFACAdNSRTkJiCwcLn59kR",
                        "728264517315002368-PZDXJOmE2wXVjWVHCPxS9UUWdmxUlTI",
                        "VSKthKSYbqPQ7Zl9jETvU9TU3ieGTYax3gEZaCaRsjtw6"));

        /* Harvesting 5 Inner REST */
        map.put(GeoType.Inner_Cir,
                new OAthInfo(
                        "k4iIb6YYWM65aLvwGByXKTxh8eX9ti1xesuvuVMUGRtkkVYBJf",
                        "RT4Xcmi1ESTEvz0pPTmUWAkom",
                        "724816606916972545-RI3ykR0toPT01HYwpUJitzet57Rp8z4",
                        "8bPUVFo0sm7GS5WjVlPOyhyMVhornBPv1oUbQfFaLv0q3"));

        /* Harvesting 6 East REST */
        map.put(GeoType.East_Cir,
                new OAthInfo(
                        "tlHm8AcxgNztbIVqGkb7w5VGW3QuNMYfoSaokfOTEkwPPwfRjQ",
                        "38mwawhkcrhn6CympL10kaSIF",
                        "2908455812-Vpg5MMpKeyFccAaOlz94j6bjMCzgeOAAP6kM71H",
                        "ksO9w7FU7A6LauyCJi0sL6FhTwd2AhaglGqlZNmQcQxUr"));

        /* Harvesting 7 West REST */
        map.put(GeoType.West_Cir,
                new OAthInfo(
                        "nLwPuqKrk9OmxPrOzqz2hIUSRDavejRbhbkqKNSfddGHicA6lH",
                        "1iuYkYjcsnHdCkIpJylqv68Et",
                        "729178942590967808-AQ1I4vcMs8z68VAFhcQ9WiOMjWjuWv0",
                        "I5NnoeVPsQeq5rYfutNYXo6Wz1WzAqGBWtuJSjiOAHyry"));

        /* Harvesting 8 North REST */
        map.put(GeoType.North_Cir,
                new OAthInfo(
                        "fiGaPTb3IYjAAumTogpSCJhec8vHdrdccZ8tSx7AChjje8LH7B",
                        "oeH7cSkLfq8cqFD6XH277DTxR",
                        "722223938684649473-f0H86hxVHfekaCjjKbo2jrrUk9gNtaL",
                        "bBbNf1lFWXz9FWx4c02vWgtuOlHx6XjQqYohVzIRCigdS"));
    }

    public static void setApplicationNum(int applicationNum) {
        OAthConfig.geoType = initalMap.get(applicationNum);
    }
    
    public static GeoType verify(int applicationNum) {
        return initalMap.get(applicationNum);
    }

    public static GeoType getGeoType() {
        return geoType;
    }

    public static OAthInfo get() {
        return map.get(geoType);
    }

    public static Configuration getConfig(boolean isJSONStoreEnabled) {
        return new ConfigurationBuilder()
                .setOAuthConsumerKey(get().getConsumerKey())
                .setOAuthConsumerSecret(get().getConsumerSecret())
                .setOAuthAccessToken(get().getAccessToken())
                .setOAuthAccessTokenSecret(get().getAccessTokenSecret())
                .setJSONStoreEnabled(isJSONStoreEnabled).build();
    }
}
