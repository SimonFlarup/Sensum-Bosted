/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.UUID;
import sensum_bosted.Diary;
import sensum_bosted.Notation;
import sensum_bosted.Patient;
import sensum_bosted.User;

/**
 *
 * @author Simon Holland Flarup
 */
public interface StorageInterface {
    //getPatient | Set
    //getUser | Set
    //getDiary | Set
    //getNotation | Set
    public Patient getPatient(UUID id);
    public boolean setPatient(Patient data);
    
    public User getUser(UUID id);
    public boolean setUser(User data);
    
    public Diary getDiary(UUID patientId);
    public boolean setNotation(UUID patientId, Notation data);
    
    //public Notation getNotation(UUID id);
    //public boolean setNotation(UUID id, Notation data);
    
    
}
