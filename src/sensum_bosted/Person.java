/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.UUID;

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
    private UUID id;

    public Person(String name, String username, String password, UserRoles field, UUID id) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.field = field;
        this.id = id;
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
    
    public UUID getId() {
        return id;
    }
}
