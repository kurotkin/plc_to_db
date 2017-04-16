package com.kurotkin;
import java.io.*;
import java.net.*;
import org.json.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting ...");
        String jsonString = getHTML("http://192.168.1.50/awp/json.htm");
        System.out.println(jsonString);
        String test = "[  {\"name\":\"out\",   \"content\":[                {\"name\":\"temp\",\"val\":\"4.3\"},                {\"name\":\"dump\",\"val\":\"98\"},                {\"name\":\"light\",\"val\":\"0\"},                {\"name\":\"press\",\"val\":\"730.5\"}             ]  },  {\"name\":\"in\",   \"content\":[                {\"name\":\"temp\",\"val\":\"25.2\"},                {\"name\":\"dump\",\"val\":\"30\"},                {\"name\":\"CO2\",\"val\":\"995\"}             ]  },  {\"name\":\"balc\",   \"content\":[                {\"name\":\"temp\",\"val\":\"18.6\"},                {\"name\":\"dump\",\"val\":\"53.7\"},                {\"name\":\"t1\",\"val\":\"1853159188\"}             ]  }]";
        System.out.println(test);
        JSONObject resultJson = new JSONObject("jsonString");

    }

    public static String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
