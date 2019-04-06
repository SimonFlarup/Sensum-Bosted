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
public class Patient extends Person {
    
    private String cpr; 

    public Patient(String name, String username, String password, UserRoles field, String cpr) {
        super(name, username, password, field);
        this.cpr = cpr;
    }
    
        
    
}
