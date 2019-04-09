/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Simon Holland Flarup
 */
public class User extends Person{
    
    private Map<UUID, String> patients;
    
    public User(String name, String username, String password, UserRoles field, Map<UUID, String> patients, UUID id) {
        super(name, username, password, field, id);
    }

    public Map<UUID, String> getPatients() {
        return patients;
    }

    public void setPatients(Map<UUID, String> patients) {
        this.patients = patients;
    }
    
}
