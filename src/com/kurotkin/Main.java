package com.kurotkin;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Starting ...");
        HTTPgetter getJson = new HTTPgetter("http://192.168.1.50/awp/json.htm");

        //String jsonString = getJson.get();
        String jsonString = TestVals.getJSON();
        System.out.println(jsonString);
        PostgesqlConn.getCour();
        //JSONObject resultJson = new JSONObject("jsonString");



    }



}
