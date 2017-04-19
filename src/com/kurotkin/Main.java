package com.kurotkin;
import com.google.gson.*;

import java.sql.SQLException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Starting ...");
        HTTPgetter getJson = new HTTPgetter("http://192.168.1.50/awp/json.htm");

        //String jsonString = getJson.get();
        String jsonString = TestVals.getJSON();
        System.out.println(jsonString);
        PostgesqlConn.getCour();
        //JSONObject resultJson = new JSONObject("jsonString");

        String jsonLine = "{\"data\": { \"translations\": [ { \"translatedText\": \"Hello world\"}]}} ";

        //String jsonLine = TestVals.getJSON();
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("data");
        JsonArray jarray = jobject.getAsJsonArray("translations");
        jobject = jarray.get(0).getAsJsonObject();
        String result = jobject.get("translatedText").toString();

        //Map jsonJavaRootObject = new Gson().fromJson(jsonString, Map.class);
        //System.out.println(jsonJavaRootObject);


    }



}
