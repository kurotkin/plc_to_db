package com.kurotkin;

import java.sql.*;

/**
 * Created by Vitaly Kurotkin on 17.04.2017.
 */
public class PostgesqlConn {

    public static void getCour () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "33321");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM cour;");
        while (rs.next()) {
            System.out.print(rs.getString(1) + " | ");
            System.out.print(rs.getString(2) + " | ");
            System.out.println(rs.getString(3));
        }
        rs.close();
        st.close();
        conn.close();
    }

    public static void createTable () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "33321");
        PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS vals(" +
                                                                                        "CREATED_DATE NOT NULL PRIMARY KEY," +
                                                                                        "username varchar(225) NOT NULL UNIQUE," +
                                                                                        "password varchar(225)," +
                                                                                        "islogged varchar(10))");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
}
