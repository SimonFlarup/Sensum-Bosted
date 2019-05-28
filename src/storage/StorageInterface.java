/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.time.LocalDate;
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
    public Patient getPatient(String cpr);
    public boolean setPatient(Patient data);
    
    public User getUser(String userName);
    public boolean setUser(User data);
    
    public boolean setAssignment(User user, Patient patient);
    
    public Diary getDiary(Patient patient);
    public boolean setNotation(Patient patient, Notation data);
    
    public Diary getDiaryHistory(Patient patient, LocalDate date);
    
    //public Notation getNotation(UUID id);
    //public boolean setNotation(UUID id, Notation data);
    
    
}
