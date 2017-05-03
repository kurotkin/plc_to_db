package com.kurotkin;
import com.google.gson.*;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws SQLException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            public void run() {
                // Получение данных
                HTTPgetter getJson = new HTTPgetter("http://192.168.1.50/awp/json.htm");
                String jsonLine = getJson.get();
                //String jsonLine = TestVals.getJSON();

                // Парсинг
                Gson gson = new Gson();
                Device[] data = gson.fromJson(jsonLine, Device[].class);

                // Запирсь в БД
                try {
                    PostgesqlConn.insert2(data);
                    System.out.println("Ok " + Printer.getT(data));
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }, 0, 30, TimeUnit.SECONDS);

    }

}
