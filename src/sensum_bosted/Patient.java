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
public class Patient extends Person {
    
    private String cpr;
    private String info;

    public Patient(String name, String password, UserRoles field, String cpr, String info) {
        super(name, cpr, password, field);
        this.cpr = cpr;
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }

    public String getCpr() {
        return this.cpr;
    }
    
        
    
}
