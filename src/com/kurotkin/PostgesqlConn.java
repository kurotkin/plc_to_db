package com.kurotkin;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

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
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "33321");
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

    public static void insert () throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "33321");
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
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "33321");
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
