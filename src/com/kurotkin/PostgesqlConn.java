package com.kurotkin;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.sql.*;

/**
 * Created by Vitaly Kurotkin on 17.04.2017.
 */
public class PostgesqlConn {
    private static String hostName = "192.168.1.20";
    private static String hostUser = "padmin";
    private static String hostPass = "ab12345678";

    public static void getCour () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/demo", "postgres", "33321");
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
        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/demo", "postgres", "33321");
        PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS vals(" +   // CREATE TABLE IF NOT EXISTS vals
                                                                                        "CREATED_DATE NOT NULL PRIMARY KEY," +
                                                                                        "username varchar(225) NOT NULL UNIQUE," +
                                                                                        "password varchar(225)," +
                                                                                        "islogged varchar(10))");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void createTable2 () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/demo", "postgres", "33321");
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS COMPANY " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " AGE            INT     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " SALARY         REAL)";
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }

    public static void createTable3 () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/demo", "postgres", "33321");
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS T_TIME " +
                "(ID timestamptz PRIMARY KEY NOT NULL," +
                " S1 REAL, " +
                " S2 REAL, " +
                " S3 REAL )";
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
    public static void insert2 (Device[] data) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/demo", hostUser, hostPass);
        Statement stmt = conn.createStatement();

        for(Device d : data) {
            for (Content c : d.content) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                                        d.name + "_" + c.name +
                                        " (ID timestamptz PRIMARY KEY NOT NULL, val REAL);");

                stmt.executeUpdate("INSERT INTO " +
                                        d.name + "_" + c.name +
                                        " VALUES (now(), " + c.val.toString() + ");");
            }
        }
        stmt.close();
        conn.close();
    }

    public static void insert () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/demo", "postgres", "33321");
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
        stmt.executeUpdate(sql);

        stmt.close();
        conn.commit();
        conn.close();
    }

    public static void select () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/demo", "postgres", "33321");
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            int age  = rs.getInt("age");
            String  address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "AGE = " + age );
            System.out.println( "ADDRESS = " + address );
            System.out.println( "SALARY = " + salary );
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public static void update () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "33321");
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
        stmt.executeUpdate(sql);
        conn.commit();

        ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            int age  = rs.getInt("age");
            String  address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "AGE = " + age );
            System.out.println( "ADDRESS = " + address );
            System.out.println( "SALARY = " + salary );
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public static void del () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "33321");
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();

        String sql = "DELETE from COMPANY where ID = 2;";
        stmt.executeUpdate(sql);
        conn.commit();

        ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            int age  = rs.getInt("age");
            String  address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "AGE = " + age );
            System.out.println( "ADDRESS = " + address );
            System.out.println( "SALARY = " + salary );
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
}
