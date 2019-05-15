/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Simon Holland Flarup
 */
public class User extends Person{
    
    private List<String> patients;
    
    public User(String name, String username, String password, UserRoles field, List<String> patients) {
        super(name, username, password, field);
        this.patients = patients;
    }

    public List<String> getPatients() {
        return patients;
    }

    public void setPatients(List<String> patients) {
        this.patients = patients;
    }
    
}
