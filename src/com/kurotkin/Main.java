package com.kurotkin;
import org.json.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting ...");
        HTTPgetter getJson = new HTTPgetter("http://192.168.1.50/awp/json.htm");

        //String jsonString = getJson.get();
        String jsonString = "[  {\"name\":\"out\",   \"content\":[                {\"name\":\"temp\",\"val\":\"4.3\"},                {\"name\":\"dump\",\"val\":\"98\"},                {\"name\":\"light\",\"val\":\"0\"},                {\"name\":\"press\",\"val\":\"730.5\"}             ]  },  {\"name\":\"in\",   \"content\":[                {\"name\":\"temp\",\"val\":\"25.2\"},                {\"name\":\"dump\",\"val\":\"30\"},                {\"name\":\"CO2\",\"val\":\"995\"}             ]  },  {\"name\":\"balc\",   \"content\":[                {\"name\":\"temp\",\"val\":\"18.6\"},                {\"name\":\"dump\",\"val\":\"53.7\"},                {\"name\":\"t1\",\"val\":\"1853159188\"}             ]  }]";
        System.out.println(jsonString);
        JSONObject resultJson = new JSONObject("jsonString");

    }

}
