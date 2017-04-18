package com.kurotkin;

/**
 * Created by Vitaly Kurotkin on 17.04.2017.
 */
public class TestVals {
    private String jsonString = "[  {\"name\":\"out\",   \"content\":[                {\"name\":\"temp\",\"val\":\"4.3\"},                {\"name\":\"dump\",\"val\":\"98\"},                {\"name\":\"light\",\"val\":\"0\"},                {\"name\":\"press\",\"val\":\"730.5\"}             ]  },  {\"name\":\"in\",   \"content\":[                {\"name\":\"temp\",\"val\":\"25.2\"},                {\"name\":\"dump\",\"val\":\"30\"},                {\"name\":\"CO2\",\"val\":\"995\"}             ]  },  {\"name\":\"balc\",   \"content\":[                {\"name\":\"temp\",\"val\":\"18.6\"},                {\"name\":\"dump\",\"val\":\"53.7\"},                {\"name\":\"t1\",\"val\":\"1853159188\"}             ]  }]";
    public static String getJSON() {
        String json = "{[  {\"name\":\"out\",   \"content\":[                {\"name\":\"temp\",\"val\":\"4.3\"},                {\"name\":\"dump\",\"val\":\"98\"},                {\"name\":\"light\",\"val\":\"0\"},                {\"name\":\"press\",\"val\":\"730.5\"}             ]  },  {\"name\":\"in\",   \"content\":[                {\"name\":\"temp\",\"val\":\"25.2\"},                {\"name\":\"dump\",\"val\":\"30\"},                {\"name\":\"CO2\",\"val\":\"995\"}             ]  },  {\"name\":\"balc\",   \"content\":[                {\"name\":\"temp\",\"val\":\"18.6\"},                {\"name\":\"dump\",\"val\":\"53.7\"},                {\"name\":\"t1\",\"val\":\"1853159188\"}             ]  }]}";
        return json;
    }
}
