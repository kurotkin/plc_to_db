package com.kurotkin;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Starting ...");
        HTTPgetter getJson = new HTTPgetter("http://192.168.1.50/awp/json.htm");

        //String jsonString = getJson.get();
        String jsonString = TestVals.getJSON();
        System.out.println(jsonString);
        PostgesqlConn.getCour();
        //JSONObject resultJson = new JSONObject("jsonString");

        //String jsonLine = "{\"data\": { \"translations\": [ { \"translatedText\": \"Hello world\"}]}} ";

        String jsonLine = TestVals.getJSON();
        //JsonElement jelement = new JsonParser().parse(jsonLine);
        //JsonObject jobject = jelement.getAsJsonObject();
        //jobject = jobject.getAsJsonObject("data");
        //JsonArray jarray = jobject.getAsJsonArray("translations");
        //jobject = jarray.get(0).getAsJsonObject();
        //String result = jobject.get("translatedText").toString();
        //System.out.println(result);
        //Map jsonJavaRootObject = new Gson().fromJson(jsonString, Map.class);
        //System.out.println(jsonJavaRootObject);

        String s = "[{\"number\" : \"3\",\"title\" : \"hello_world\"},{\"number\" : \"2\",\"title\" : \"hello_world\"}]";
        Gson gson = new Gson();
        Device[] data = gson.fromJson(jsonLine, Device[].class);
        for(Device d : data) {
            System.out.println(d.name);
            for (Content c : d.content) {
                System.out.println(c.name + " = " + c.val.toString());
            }
            System.out.println();
        }
        System.out.println(data[0].name);

    }

}
