/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import GUI.ListViewInfo;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Simon Holland Flarup
 */
public class CRUD {

    private static CRUD instance;
    private String url;
    private String username;
    private String password;

    private CRUD() {
        url = "jdbc:postgresql://balarama.db.elephantsql.com:5432/iznbvzji";
        username = "iznbvzji";
        password = "Lkg4zTNwLlKUVttzdA9flfTMfv9w8WFQ";
    }

    public static CRUD getInstance() {
        if (CRUD.instance == null) {
            CRUD.instance = new CRUD();
        }
        return CRUD.instance;
    }

    /*
    public void test() {
        System.out.println("Testing");
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM \"User\"");
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
                System.out.print("Column 2 returned ");
                System.out.println(rs.getString(2));
            }
            rs.close();
            st.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     */
    public void create(String table, String values) {
        System.out.println("Creating");
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            st.executeUpdate("INSERT INTO \"" + table + "\" VALUES (" + values + ")"); // change values to patient data
//            ResultSet rs = st.executeQuery("SELECT * FROM \"User\"");
//            ResultSetMetaData rsmd = rs.getMetaData();
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i));
//            }
//            while (rs.next()) {
//                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                    System.out.println(rsmd.getColumnName(i));
//                    result.put(Fields.UserFields.valueOf(rsmd.getColumnName(i).toUpperCase()), rs.getString(i));
//                }
//                System.out.print("Column 1 returned ");
//                System.out.println(rs.getString(2));
//                System.out.print("Column 2 returned ");
//                System.out.println(rs.getString(3));
//            }
//            rs.close();
            st.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public int updateName() {
//
//        try {
//            Connection db = DriverManager.getConnection(url, username, password);
//            Statement st = db.createStatement();
//            
//            
//            int foovalue = 500;
//            st.executeLargeUpdate("DELETE FROM mytable WHERE columnfoo = ?");
//            st.set(1, foovalue);
//            int rowsDeleted = st.executeUpdate();
//            System.out.println(rowsDeleted + " rows deleted");
//            st.close();
//            st.executeUpdate
//                
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return affectedrows;
//    }
//}
    //NEXT TO DO
    public HashMap<Enum, String> where(String table, String condition) {
        System.out.println("Creating");
        HashMap<Enum, String> result = new HashMap<>();
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM \"User\"");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    result.put(Fields.UserFields.valueOf(rsmd.getColumnName(i).toUpperCase()), rs.getString(i));
                }
            }
            rs.close();
            st.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        /*    
    //Create (C)
    public void create(Tables table, Map<Enum, String> data, User user);
    //Read (R)
    public HashMap<Enum, String> readFromKey(Tables table, UUID primaryKey, User user);
    public HashMap<Enum, String>[] readAll(Tables table, User user);
    //Update (U)
    public void update(Tables table, UUID primaryKey, Map<Enum, String> data, User user); */

    }
}
