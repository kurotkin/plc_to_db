package com.kurotkin;
import com.google.gson.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        // Получение данных
        HTTPgetter getJson = new HTTPgetter("http://192.168.1.50/awp/json.htm");
        //String jsonLine = getJson.get();
        String jsonLine = TestVals.getJSON();

        // Парсинг
        Gson gson = new Gson();
        Device[] data = gson.fromJson(jsonLine, Device[].class);

        // Запирсь в БД
        PostgesqlConn.insert2(data);

    }



    public static void printDevice(Device[] data) {
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
