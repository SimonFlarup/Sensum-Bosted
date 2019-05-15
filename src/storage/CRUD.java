/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import GUI.ListViewInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import static storage.Tables.*;

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
            db.close();
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
    public HashMap<Enum, String>[] read(String table, String condition) {
        System.out.println("Whereing: " + table + " | " + condition);
        ArrayList<HashMap<Enum, String>> result = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs;
            if (condition == null) {
                rs = st.executeQuery("SELECT * FROM \"" + table + "\"");
            } else {
                rs = st.executeQuery("SELECT * FROM \"" + table + "\" WHERE " + condition);
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                System.out.println("Creating row - 2");
                HashMap<Enum, String> row = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (table.equals(ASSIGNMENTS.getTableName())) {
                        row.put(Fields.AssignmentFields.valueOf(rsmd.getColumnName(i).toUpperCase()), rs.getString(i));
                    } else if (table.equals(NOTATIONS.getTableName())) {
                        row.put(Fields.NotationFields.valueOf(rsmd.getColumnName(i).toUpperCase()), rs.getString(i));
                    } else if (table.equals(PATIENTS.getTableName())) {
                        row.put(Fields.PatientFields.valueOf(rsmd.getColumnName(i).toUpperCase()), rs.getString(i));
                    } else if (table.equals(USERS.getTableName())) {
                        row.put(Fields.UserFields.valueOf(rsmd.getColumnName(i).toUpperCase()), rs.getString(i));
                    }
                }
                result.add(row);
            }
            rs.close();
            st.close();
            db.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

        if (result.isEmpty()) {
            return null;
        }

        return result.toArray(
                new HashMap[result.size()]);
    }

    public void update(String table, String values, String condition) {
        System.out.println("Updating: " + table + " | " + condition + " | " + values);
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            st.executeUpdate("UPDATE \"" + table + "\" SET " + values + " WHERE " + condition); // change values to patient data
            st.close();
            db.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
