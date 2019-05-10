/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author Simon Holland Flarup
 */
public enum Tables {
    USERS("User"),
    PATIENTS(".//src//data//Patients//"),
    NOTATIONS(".//src//data//Notations//"),
    ASSIGNMENTS(".//src//data//Assignment//");

    private String path;

    public String getPath() {
        return this.path;
    }

    private Tables(String path) {
        this.path = path;
    }
}
