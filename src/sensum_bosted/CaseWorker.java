/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.List;

/**
 *
 * @author Ryge
 */
public class CaseWorker extends Person {

    List<Patient> patientList;
    
    public CaseWorker(String name, String username, String password, Field field) {
        super(name, username, password, field);
    }
    
    
    
}
