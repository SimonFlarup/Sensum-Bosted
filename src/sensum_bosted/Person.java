/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

/**
 *
 * @author Ryge
 */
public abstract class Person {

    //Attributes
    private String name;
    private String username;
    private String password;
    private UserRoles field;

    public Person(String name, String username, String password, UserRoles field) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRoles getField() {
        return field;
    }

}
