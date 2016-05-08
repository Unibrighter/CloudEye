package test;

import java.util.HashMap;
import java.util.Map;

import org.lightcouch.CouchDbClient;

public class CouchDBTest {

    public static void main(String[] args) {
        CouchDbClient dbClient = new CouchDbClient(); 
        Map<String, String> map = new HashMap<>();
        map.put("id", "1234234235");
        map.put("content", "sdfsdfsdfsdf");
        dbClient.save(map);
        dbClient.shutdown();
    }
}

