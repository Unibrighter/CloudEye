package test;

import java.util.HashMap;
import java.util.Map;

import org.lightcouch.CouchDbClient;

public class CouchDBTest {

    public static void main(String[] args) {
        CouchDbClient dbClient = new CouchDbClient(); 
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("content", "zac");
        dbClient.save(map);
        
        map = new HashMap<>();
        map.put("id", "2");
        map.put("content", "li");
        dbClient.save(map);
        
        map = new HashMap<>();
        map.put("id", "3");
        map.put("content", "ge");
        dbClient.save(map);
        
        map = new HashMap<>();
        map.put("id", "4");
        map.put("content", "yu");
        dbClient.save(map);
        
        map = new HashMap<>();
        map.put("id", "5");
        map.put("content", "tong");
        dbClient.save(map);
        
        dbClient.shutdown();
    }
}

