/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import static storage.Tables.*;

/**
 *
 * @author Jonas Ahwazian
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
    
    public void create(String table, String values) {
        sensum_bosted.PrintHandler.println("Creating");
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            st.executeUpdate("INSERT INTO \"" + table + "\" VALUES (" + values + ")"); // change values to patient data
            st.close();
            db.close();
        } catch (java.sql.SQLException e) {
            sensum_bosted.PrintHandler.println(e.getMessage());
        }
    }
    
    public HashMap<Enum, String>[] read(String table, String condition) {
        sensum_bosted.PrintHandler.println("Whereing: " + table + " | " + condition);
        ArrayList<HashMap<Enum, String>> result = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs;
            if (condition == null) {
                rs = st.executeQuery("SELECT * FROM \"" + table + "\"");
            } else {
                sensum_bosted.PrintHandler.println("SELECT * FROM \"" + table + "\" WHERE " + condition, true);
                rs = st.executeQuery("SELECT * FROM \"" + table + "\" WHERE " + condition);
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                sensum_bosted.PrintHandler.println(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                sensum_bosted.PrintHandler.println("Creating row - 2");
                HashMap<Enum, String> row = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (table.equals(ASSIGNMENTS.getTableName())) {
                        row.put(Fields.AssignmentFields.valueOf(rsmd.getColumnName(i).toUpperCase()), rs.getString(i));
                    } else if (table.equals(NOTATIONS.getTableName()) || table.equals(NOTATIONS_HISTORY.getTableName())) {
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
            sensum_bosted.PrintHandler.println(e.getMessage());
        }

        if (result.isEmpty()) {
            return null;
        }

        return result.toArray(
                new HashMap[result.size()]);
    }

    public void update(String table, String values, String condition) {
        sensum_bosted.PrintHandler.println("Updating: " + table + " | " + condition + " | " + values);
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            st.executeUpdate("UPDATE \"" + table + "\" SET " + values + " WHERE " + condition); // change values to patient data
            st.close();
            db.close();
        } catch (java.sql.SQLException e) {
            sensum_bosted.PrintHandler.println(e.getMessage());
        }
    }
}
