/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Simon Holland Flarup
 */
public class User extends Person{
    
    private List<Patient> patients;
    
    public User(String name, String username, String password, UserRoles field, UUID id) {
        super(name, username, password, field, id);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
}
