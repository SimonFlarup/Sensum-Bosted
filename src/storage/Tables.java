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
    USERS(".//src//data//User//"),
    PATIENTS(".//src//data//Patients//"),
    DIARIES(".//src//data//Diary//");

    private String path;

    public String getPath() {
        return this.path;
    }

    private Tables(String path) {
        this.path = path;
    }
}
