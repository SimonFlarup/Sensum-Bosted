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
    PATIENTS("Patient"),
    NOTATIONS("Notation"),
    NOTATIONS_HISTORY("Notation_History"),
    ASSIGNMENTS("Assignment");

    private String path;

    public String getTableName() {
        return this.path;
    }

    private Tables(String path) {
        this.path = path;
    }
}
