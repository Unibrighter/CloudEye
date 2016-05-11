package test;

import java.util.ArrayList;
import java.util.List;

import org.lightcouch.CouchDbClient;

import com.google.gson.JsonObject;

public class CouchDBTest {

    public static void main(String[] args) {
        CouchDbClient connection = new CouchDbClient();
        connection.save(new JsonObject());
        connection.shutdown();
        
        try {
            connection.save(new JsonObject());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
