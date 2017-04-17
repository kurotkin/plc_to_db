package com.kurotkin;
import org.json.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting ...");
        HTTPgetter getJson = new HTTPgetter("http://192.168.1.50/awp/json.htm");

        //String jsonString = getJson.get();
        String jsonString = TestVals.getJSON();
        System.out.println(jsonString);
        //JSONObject resultJson = new JSONObject("jsonString");


    }

}
