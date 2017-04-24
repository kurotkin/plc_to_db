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

        PostgesqlConn.createTable2();
        //PostgesqlConn.insert();
        PostgesqlConn.select();
        PostgesqlConn.update();
        PostgesqlConn.del();
    }

}
